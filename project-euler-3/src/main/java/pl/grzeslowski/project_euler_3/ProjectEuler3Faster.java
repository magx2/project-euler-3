package pl.grzeslowski.project_euler_3;

public class ProjectEuler3Faster implements ProjectEuler3 {

    @Override
    public long findLargestPrimeFactor(final long value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }

        final Prime prime = new Prime();

        // if we get prime w know that its biggest factor is it
        if (prime.isPrime(value)) {
            return value;
        }

        long biggestResult = -1;

        long dividedValue = value;
        long primeDivider = 2;
        while (!prime.isPrime(dividedValue)) {
            if (dividedValue % primeDivider == 0) {
                dividedValue /= primeDivider;

                if (primeDivider > biggestResult) {
                    biggestResult = primeDivider;
                }

                primeDivider = 2;
            } else {
                primeDivider = prime.getNextPrime(primeDivider);
            }

        }

        return biggestResult > dividedValue ? biggestResult : dividedValue;
    }

}
