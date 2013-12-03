package pl.grzeslowski.project_euler_3;

import java.util.Arrays;
import java.util.Collection;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class PrimeTest_is_prime {
    private final int in;
    private final boolean out;

    public PrimeTest_is_prime(final int in, final boolean out) {
        this.in = in;
        this.out = out;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final Object[][] data = new Object[][] { { 2, true }, { 4, false },
                { 14, false }, { 6917, true } };
        return Arrays.asList(data);
    }

    @Test
    public void test_normal_parameters() {

        // given
        final Prime prime = new Prime();

        // when
        final boolean isPrime = prime.isPrime(in);

        // then
        Assertions.assertThat(isPrime).isEqualTo(out);
    }
}
