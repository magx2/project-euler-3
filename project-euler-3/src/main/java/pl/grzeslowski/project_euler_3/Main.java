package pl.grzeslowski.project_euler_3;

public class Main {

    public static void main(final String[] args) {
        final long l = 6_008_514_143L;

        try {
            System.out.println(new ProjectEuler3SimpleImpl()
                    .findLargestPrimeFactor(l));
        } catch (final Throwable ex) {
            System.out.println(ex.getClass().getSimpleName());
        }
    }

}
