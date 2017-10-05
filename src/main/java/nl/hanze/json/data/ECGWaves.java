package nl.hanze.json.data;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laurens on 28-9-2017.
 */
public class ECGWaves implements Measurement {


    public static final Gson GSON = new Gson();
    private List<Measurement> measurements = new ArrayList<>();

    public ECGWaves() {

    }

    public static class Measurement {
        private long time = System.currentTimeMillis();
        private double amplitude;


        public Measurement() {

        }

        public Measurement(long time, double amplitude) {
            this.time = time;
            this.amplitude = amplitude;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public double getAmplitude() {
            return amplitude;
        }

        public void setAmplitude(double amplitude) {
            this.amplitude = amplitude;
        }
    }

    public void addMeasurement(Measurement measurement) {
        measurements.add(measurement);
    }

    public List<Measurement> getMeasurements() {
        return new ArrayList<>(measurements);
    }

    @Override
    public String toJson() {
        return GSON.toJson(measurements);
    }
}
