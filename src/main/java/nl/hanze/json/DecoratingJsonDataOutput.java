package nl.hanze.json;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created by Laurens on 28-9-2017.
 */
public class DecoratingJsonDataOutput implements JsonDataOutput {

    private final PrintWriter printWriter;
    private OutputStream outputStream;

    public DecoratingJsonDataOutput(OutputStream outputStream) {
        this.outputStream = outputStream;
        printWriter = new PrintWriter(outputStream);
    }

    @Override
    public void write(String json) {
        printWriter.println(json);
        printWriter.flush();
    }


    @Override
    public void close() throws Exception {
        printWriter.close();
    }
}
