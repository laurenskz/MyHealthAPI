package nl.hanze.json;

import com.google.gson.Gson;

/**
 * Created by Laurens on 28-9-2017.
 */
public class ObjectOutput implements AutoCloseable {

    private JsonDataOutput jsonDataOutput;
    private static final Gson GSON = new Gson();

    public ObjectOutput(JsonDataOutput jsonDataOutput) {
        this.jsonDataOutput = jsonDataOutput;
    }

    public void write(Object object) {
        String serializedObject = GSON.toJson(object);
        jsonDataOutput.write(serializedObject);
    }

    @Override
    public void close() throws Exception {
        jsonDataOutput.close();
    }
}
