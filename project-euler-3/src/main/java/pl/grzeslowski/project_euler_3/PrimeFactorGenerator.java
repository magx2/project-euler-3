package pl.grzeslowski.project_euler_3;

import java.util.LinkedList;
import java.util.List;

public final class PrimeFactorGenerator {

    private final List<Long> cache = new LinkedList<Long>();

    public PrimeFactorGenerator() {
        cache.add(2L);
        cache.add(0, 3L);
    }

    public long findFirstSmallerPrime(final long value) {
        if(value <=1 ) {
            throw new IllegalArgumentException();
        }
        
        final Long lastPrime = cache.get(0);

        if (lastPrime >= value) {
            return getFromCache(value);
        } else {
            final long newPrime = findNewPrime(lastPrime, value);

            cache.add(0, newPrime);

            return findFirstSmallerPrime(value);
        }
    }

    private long findNewPrime(final long lastPrime, final long value) {
        if (lastPrime > value) {
            return lastPrime;
        } else {
            long newPrime = lastPrime + 2;

            while (!isPrime(newPrime)) {
                newPrime +=  2;
            }

            cache.add(0, newPrime);
            return findNewPrime(newPrime, value);
        }
    }

    private boolean isPrime(final long newPrime) {
        for (final long prime : cache) {
            if (newPrime % prime == 0) {
                return false;
            }
        }
        return true;
    }

    private long getFromCache(final long value) {
        for (final long prime : cache) {
            if (prime <= value) {
                return prime;
            }
        }

        throw new RuntimeException();
    }
}
