package nl.hanze.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.LazyReflectiveObjectGenerator;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Created by Laurens on 28-9-2017.
 */
public class JsonDataInput implements Runnable,AutoCloseable {

    private final JsonStreamParser jsonStreamParser;
    private InputStream inputStream;
    private boolean running = true;
    private Collection<JsonInputListener> jsonInputListeners = new ArrayList<>();
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static final Logger log = LoggerFactory.getLogger(JsonDataInput.class);

    public JsonDataInput(InputStream inputStream) {
        this.inputStream = inputStream;
        jsonStreamParser = new JsonStreamParser(new InputStreamReader(inputStream));
    }

    public void addJsonInputListener(JsonInputListener inputListener) {
        jsonInputListeners.add(inputListener);
    }

    public void removeJsonInputListener(JsonInputListener inputListener) {
        jsonInputListeners.remove(inputListener);
    }

    private Collection<Runnable> pushJsonToListeners(String json) {
        return jsonInputListeners.stream()
                .map(jsonInputListener -> (Runnable) () ->
                        jsonInputListener.onArrival(json)
                )
                .collect(Collectors.toList());
    }

    public void run() {
        while (running) {
            JsonElement nextJsonObject = jsonStreamParser.next();
            pushJsonToListeners(nextJsonObject.toString())
                    .forEach(executorService::submit);
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            log.error("Exception while closing jsoninputStream");
        }
    }

    @Override
    public void close() throws Exception {
        running = false;
        executorService.shutdown();
    }
}
