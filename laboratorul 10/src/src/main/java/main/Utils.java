package src.main.java.main;

import src.main.java.dataprocessing.BasicStepCountStrategy;
import src.main.java.dataprocessing.FilteredStepCountStrategy;
import src.main.java.dataprocessing.StepCountStrategy;

public class Utils {
    public static final String BASIC_STRATEGY = "basic";
    public static final String FILTERED_STRATEGY = "filtered";

    public static int getClientId() {
        return 42;
    }


    public static StepCountStrategy getStrategy(String type) {
        if (BASIC_STRATEGY.equalsIgnoreCase(type)) {
            return new BasicStepCountStrategy();
        } else if (FILTERED_STRATEGY.equalsIgnoreCase(type))
            return new FilteredStepCountStrategy();// default
        return null;
    }
}
