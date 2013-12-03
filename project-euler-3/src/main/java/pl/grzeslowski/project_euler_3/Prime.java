package pl.grzeslowski.project_euler_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Prime {

    private final List<Long> cache = new LinkedList<Long>();

    public Prime() {
        cache.add(2L);
        cache.add(0, 3L);
    }

    public boolean isPrime(final long value) {

        // if we get over this value it will means that we dont need to find new prime
        if (value <= cache.get(0)) {

            final ArrayList<Long> reversed = new ArrayList<>(cache);
            Collections.reverse(reversed);

            for (final Long prime : reversed) {
                if (value == prime) {
                    return true;
                } else if (prime > value) {
                    return false;
                }
            }
        }

        // need to find next prime
        findNextPrime(cache.get(0), value);
        return isPrime(value);
    }

    private long findNextPrime(final Long lastPrime, final long value) {
        long newPrime = lastPrime;
        while (newPrime <= value) {
            do {
                newPrime += 2;
            } while (!isPrimeFromCache(newPrime));

            cache.add(0, newPrime);
        }

        return newPrime;
    }

    private boolean isPrimeFromCache(final long newPrime) {
        for (final long prime : cache) {
            if (newPrime % prime == 0) {
                return false;
            }
        }
        return true;
    }

    public long getNextPrime(final long prime) {
        final long nextPrime = cache.get(0);

        if (prime >= nextPrime) {
            findNextPrime(nextPrime, prime);

            return getNextPrime(prime);
        } else {
            long lastPrime = nextPrime;
            for (final long cachePrime : cache) {
                if (cachePrime == prime) {
                    return lastPrime;
                } else {
                    lastPrime = cachePrime;
                }
            }

            return 0L;
        }
    }
}
