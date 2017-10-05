package nl.hanze.json;

/**
 * Created by Laurens on 3-10-2017.
 */
public interface JsonDataOutput extends AutoCloseable {
    void write(String json);
}
