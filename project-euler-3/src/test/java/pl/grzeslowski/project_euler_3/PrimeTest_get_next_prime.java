package pl.grzeslowski.project_euler_3;

import java.util.Arrays;
import java.util.Collection;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class PrimeTest_get_next_prime {
    private final int in;
    private final long out;

    public PrimeTest_get_next_prime(final int in, final long out) {
        this.in = in;
        this.out = out;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final Object[][] data = new Object[][] { { 2, 3 }, { 5, 7 },
                { 13, 17 }, { 22481, 22483 } };
        return Arrays.asList(data);
    }

    @Test
    public void test_normal_parameters() {

        // given
        final Prime prime = new Prime();

        // when
        final long nextPrime = prime.getNextPrime(in);

        // then
        Assertions.assertThat(nextPrime).isEqualTo(out);
    }
}
