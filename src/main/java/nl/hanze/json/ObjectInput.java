package nl.hanze.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Laurens on 28-9-2017.
 */
public class ObjectInput<T> implements JsonInputListener {

    private Function<String, T> deserializer;
    private Collection<Consumer<T>> consumers = new ArrayList<>();

    public ObjectInput(Function<String, T> deserializer) {
        this.deserializer = deserializer;
    }

    public void addConsumer(Consumer<T> consumer) {
        consumers.add(consumer);
    }

    public void deleteConsumer(Consumer<T> consumer) {
        consumers.remove(consumer);
    }

    @Override
    public void onArrival(String json) {
        T deserializedObject = deserializer.apply(json);
        consumers.forEach(consumer -> consumer.accept(deserializedObject));
    }
}
