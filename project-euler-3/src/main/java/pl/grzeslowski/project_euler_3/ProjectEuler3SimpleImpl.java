package pl.grzeslowski.project_euler_3;

public class ProjectEuler3SimpleImpl implements ProjectEuler3 {

    public long findLargestPrimeFactor(final long value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }

        final long sqrt = (long) Math.ceil(Math.sqrt(value));
        return new PrimeFactorGenerator().findFirstSmallerPrime(value);
    }

}
