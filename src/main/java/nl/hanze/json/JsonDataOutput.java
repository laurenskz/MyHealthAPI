package nl.hanze.json;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.stream.Stream;

/**
 * Created by Laurens on 28-9-2017.
 */
public class JsonDataOutput implements AutoCloseable {

    private final PrintWriter printWriter;
    private OutputStream outputStream;

    public JsonDataOutput(OutputStream outputStream) {
        this.outputStream = outputStream;
        printWriter = new PrintWriter(outputStream);
    }

    public void write(String json) {
        printWriter.println(json);
        printWriter.flush();
    }


    public void close() throws Exception {
        printWriter.close();
    }
}
