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
        final ArrayList<Long> reversed = new ArrayList<>(cache);
        Collections.reverse(reversed);
        
        for (final Long prime : reversed) {
            if(value == prime) {
                return true;
            } else if(prime > value) {
                return false;
            }
        }
        
        // need to find next prime
        findNextPrime(cache.get(0));
        return false;
    }
    
    private void findNextPrime(final Long prime) {
        // TODO Auto-generated method stub
        
    }

    public long getNextPrime(final long prime) {
        return 0L;
    }
}
