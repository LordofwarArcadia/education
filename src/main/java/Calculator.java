public class Calculator {

    public Float plus(Float a, Float b) {
        validate(a);
        validate(b);
        return a + b;
    }

    public Float minus(Float a, Float b) {
        validate(a);
        validate(b);
        return a - b;
    }

    public Float multiply(Float a, Float b) {
        validate(a);
        validate(b);
        return a * b;
    }

    public Float divide(Float a, Float b) {
        validate(a);
        validate(b);
        return a / b;
    }

    private void validate(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Null is not valid");
        }
    }
}
