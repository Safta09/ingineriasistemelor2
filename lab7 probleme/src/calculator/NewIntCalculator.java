// ACalculator.java
package calculator;

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

public class NewIntCalculator extends ACalculator<Integer> {
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


