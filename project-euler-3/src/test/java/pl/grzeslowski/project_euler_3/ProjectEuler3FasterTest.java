package pl.grzeslowski.project_euler_3;

import java.util.Arrays;
import java.util.Collection;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ProjectEuler3FasterTest {
    private final int in;
    private final long out;

    public ProjectEuler3FasterTest(final int in, final long out) {
        this.in = in;
        this.out = out;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final Object[][] data = new Object[][] { { 2, 2 }, { 3, 3 }, { 4, 2 },
                { 5, 5 }, { 6, 3 }, { 9, 3 }, { 14, 7 } };
        return Arrays.asList(data);
    }

    @Test
    public void test_normal_parameters() {

        // given
        final ProjectEuler3 euler = new ProjectEuler3Faster();

        // when
        final long primeFactor = euler.findLargestPrimeFactor(in);

        // then
        Assertions.assertThat(primeFactor).isEqualTo(out);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_maxValue_equals_0() {

        // given
        final ProjectEuler3Faster euler = new ProjectEuler3Faster();

        // when
        euler.findLargestPrimeFactor(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_maxValue_equals_minus_1() {

        // given
        final ProjectEuler3Faster euler = new ProjectEuler3Faster();

        // when
        euler.findLargestPrimeFactor(-1);
    }

}
