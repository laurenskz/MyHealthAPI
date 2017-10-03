package nl.hanze.json;

import org.hamcrest.Matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;

import static org.junit.Assert.*;

/**
 * Created by Laurens on 3-10-2017.
 */
public class ObjectInputTest {

    @org.junit.Test
    public void onArrival() throws Exception {
        ObjectInput<String> objectInput = new ObjectInput<>(Function.identity());
        List<String> collectedStrings = new ArrayList<>();
        objectInput.addConsumer(collectedStrings::add);
        objectInput.addConsumer(collectedStrings::add);
        objectInput.onArrival("Hello");
        assertThat(collectedStrings, Matchers.containsInAnyOrder("Hello", "Hello"));
    }

}