package nl.hanze.json.data;

/**
 * Created by Laurens on 28-9-2017.
 */
public class SerializedJsonMeasurement {

    private MeasurementType measurementType;
    private String serializedJson;

    public SerializedJsonMeasurement(MeasurementType measurementType, String serializedJson) {
        this.measurementType = measurementType;
        this.serializedJson = serializedJson;
    }

    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    public String getSerializedJson() {
        return serializedJson;
    }

    public void setSerializedJson(String serializedJson) {
        this.serializedJson = serializedJson;
    }
}
