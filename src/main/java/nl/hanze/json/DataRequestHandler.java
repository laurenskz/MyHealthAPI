package nl.hanze.json;

import nl.hanze.json.data.Measurement;
import nl.hanze.json.data.MeasurementType;
import nl.hanze.json.data.SerializedJsonMeasurement;
import nl.hanze.json.data.MeasurementRequest;

import java.util.function.Consumer;

/**
 * Created by Laurens on 28-9-2017.
 */
public abstract class DataRequestHandler implements Consumer<MeasurementRequest> {

    private Consumer<SerializedJsonMeasurement> answerSink;

    public DataRequestHandler(Consumer<SerializedJsonMeasurement> answerSink) {
        this.answerSink = answerSink;
    }

    protected abstract Measurement generateMeasurementWithType(MeasurementType measurementType);

    @Override
    public void accept(MeasurementRequest measurementRequest) {
        Measurement measurement = generateMeasurementWithType(measurementRequest.getMeasurementType());
        SerializedJsonMeasurement serializedMeasurement = new SerializedJsonMeasurement(measurementRequest.getMeasurementType(),
                measurement.toJson());
        answerSink.accept(serializedMeasurement);
    }
}
