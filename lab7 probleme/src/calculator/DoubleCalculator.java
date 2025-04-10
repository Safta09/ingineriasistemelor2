
// DoubleCalculator.java
package calculator;

public class DoubleCalculator extends ACalculator<Double> {
    public DoubleCalculator(Double initialState) {
        super(initialState);
    }

    @Override
    protected Double init() {
        return 0.0;
    }

    public DoubleCalculator add(double value) {
        this.state += value;
        return this;
    }

    public DoubleCalculator subtract(double value) {
        this.state -= value;
        return this;
    }

    public DoubleCalculator multiply(double value) {
        this.state *= value;
        return this;
    }
}