package nl.hanze.json.data;

import com.google.gson.Gson;

/**
 * Created by Laurens on 28-9-2017.
 */
public class BloodPressure implements Measurement {

    public static final Gson GSON = new Gson();
    private double systolic;
    private double diastolic;

    public BloodPressure() {

    }

    public BloodPressure(double systolic, double diastolic) {
        this.systolic = systolic;
        this.diastolic = diastolic;
    }

    public double getSystolic() {
        return systolic;
    }

    public double getDiastolic() {
        return diastolic;
    }

    @Override
    public String toJson() {
        return GSON.toJson(this);
    }
}
