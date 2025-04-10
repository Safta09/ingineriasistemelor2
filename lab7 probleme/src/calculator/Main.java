
package calculator;

public class Main {
    public static void main(String[] args) {
        NewIntCalculator intCalculator = new NewIntCalculator(10);
        int intResult = intCalculator.add(5).subtract(3).multiply(2).result();
        System.out.println("Integer result: " + intResult);

        DoubleCalculator doubleCalculator = new DoubleCalculator(10.0);
        double doubleResult = doubleCalculator.add(5).subtract(3.3).multiply(2.2).result();
        System.out.println("Double result: " + doubleResult);
    }
}
