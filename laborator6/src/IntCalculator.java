abstract class ACalculator<T extends Number> {
    protected T state;

    public ACalculator(T initialState) {
        this.state = initialState;
    }

    public T result() {
        return state;
    }

    public void clear() {
        this.state = init();
    }

    protected abstract T init();
}

class NewIntCalculator extends ACalculator<Integer> {
    public NewIntCalculator(Integer initialState) {
        super(initialState);
    }

    @Override
    protected Integer init() {
        return 0;
    }

    public NewIntCalculator add(int value) {
        this.state += value;
        return this;
    }

    public NewIntCalculator subtract(int value) {
        this.state -= value;
        return this;
    }

    public NewIntCalculator multiply(int value) {
        this.state *= value;
        return this;
    }
}

class DoubleCalculator extends ACalculator<Double> {
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


