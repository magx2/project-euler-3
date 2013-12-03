package pl.grzeslowski.project_euler_3;

public class ProjectEuler3DiffrentWay implements ProjectEuler3 {

    @Override
    public long findLargestPrimeFactor(final long value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }

        if (value <= 1_000_000L) {
            return quickFind(value);
        } else {
            final long smallerValue = findFirstDivider(value);

            return findLargestPrimeFactor(smallerValue);
        }
    }

    private long findFirstDivider(final long value) {
        final long sqrt = (long) Math.ceil(Math.sqrt(value));

        for (int i = 2; i <= sqrt; i++) {
            if (value % i == 0) {
                return value / i;
            }
        }

        throw new RuntimeException();
    }

    private long quickFind(final long value) {
        final Prime prime = new Prime();
        final long sqrt = getMaxDivider(value);

        for (int i = 0; i < sqrt; i += 2) {
            final long tmp = sqrt - i;

            if (value % tmp == 0 && prime.isPrime(tmp)) {
                return tmp;
            }
        }

        // value is prime
        return value;
    }

    private long getMaxDivider(final long value) {
        final long ceil = (long) Math.ceil(value / 2.0);

        if (ceil % 2 == 0 && ceil != 2) {
            return ceil - 1;
        } else {
            return ceil;
        }
    }

}
