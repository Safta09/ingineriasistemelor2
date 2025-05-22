package src.main.java.dataprocessing;

import src.main.java.storage.SensorData;
import java.util.ArrayList;
import java.util.List;

public class BasicStepCountStrategy implements StepCountStrategy {

    private final List<SensorData> records = new ArrayList<>();

    @Override
    public void consumeMessage(SensorData data) {
        records.add(data);
    }

    @Override
    public int getTotalSteps() {
        int total = 0;
        for (SensorData data : records) {
            total += data.getStepsCount();
        }
        return total;
    }


    @Override
    public String getStrategyDescription() {
        return "Numarare basic a numerelor (adunare)";
    }
}
