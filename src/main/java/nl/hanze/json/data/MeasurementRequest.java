package nl.hanze.json.data;

import com.google.gson.Gson;

/**
 * Created by Laurens on 28-9-2017.
 */
public class MeasurementRequest {
    private static final Gson GSON = new Gson();
    private MeasurementType measurementType;

    public MeasurementRequest(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    public static MeasurementRequest fromJson(String json) {
        return GSON.fromJson(json, MeasurementRequest.class);
    }
}
