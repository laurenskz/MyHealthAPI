package nl.hanze.json.data;

import com.google.gson.Gson;

/**
 * Created by Laurens on 28-9-2017.
 */
public class HeartRate implements Measurement {

    public static final Gson GSON = new Gson();
    private double value;

    public HeartRate() {

    }

    public HeartRate(double heartRate) {
        this.value = heartRate;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toJson() {
        return GSON.toJson(this);
    }
}
