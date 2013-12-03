package pl.grzeslowski.project_euler_3;

import java.util.Arrays;
import java.util.Collection;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public final class PrimeFactorGeneratorTest {
    private final int in;
    private final long out;

    public PrimeFactorGeneratorTest(final int in, final long out) {
        this.in = in;
        this.out = out;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final Object[][] data = new Object[][] { { 4, 5 }, { 12, 13 }, {6916,6917} };
        return Arrays.asList(data);
    }

    @Test
    public void test_normal_parameters() {

        // given
        final PrimeFactorGenerator generator = new PrimeFactorGenerator();

        // when
        final long prime = generator.findFirstSmallerPrime(in);

        // then
        Assertions.assertThat(prime).isEqualTo(out);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_maxValue_equals_0() {

        // given
        final PrimeFactorGenerator generator = new PrimeFactorGenerator();

        // when
        generator.findFirstSmallerPrime(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_maxValue_equals_minus_1() {

        // given
        final PrimeFactorGenerator generator = new PrimeFactorGenerator();

        // when
        generator.findFirstSmallerPrime(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_maxValue_equals_1() {

        // given
        final PrimeFactorGenerator generator = new PrimeFactorGenerator();

        // when
        generator.findFirstSmallerPrime(1);
    }
}
