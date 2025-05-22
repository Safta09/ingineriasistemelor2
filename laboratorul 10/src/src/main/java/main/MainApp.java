package src.main.java.main;

import src.main.java.storage.DataAggregator;
import src.main.java.storage.DataRepository;
import src.main.java.storage.SensorData;
import src.main.java.dataprocessing.StepCountStrategy;



import java.util.Scanner;

public class MainApp {

    private static src.main.java.main.Utils Utils;

    public static void main(String[] args) {

        System.out.println("Choose a strategy: type 'basic' or 'filtered'");
        Scanner scanner = new Scanner(System.in);
        String strategyType = scanner.next();
        scanner.close();

        DataRepository dataRepository = DataRepository.getInstance();


        StepCountStrategy strategy = Utils.getStrategy(strategyType);

        DataAggregator aggregator = new DataAggregator(strategy);

        long baseTimestamp = System.currentTimeMillis();

        dataRepository.addData(new SensorData(10, baseTimestamp + 1));
        dataRepository.addData(new SensorData(20, baseTimestamp + 2));
        dataRepository.addData(new SensorData(30, baseTimestamp + 3));
        dataRepository.addData(new SensorData(4000, baseTimestamp + 4));
        dataRepository.addData(new SensorData(50, baseTimestamp + 5));
        dataRepository.addData(new SensorData(-100, baseTimestamp + 6));
        dataRepository.addData(new SensorData(500, baseTimestamp + 600));

        System.out.println("====================================================");
        aggregator.receive(dataRepository);
        System.out.println(aggregator.getResults());
        System.out.println("====================================================");
    }
}
