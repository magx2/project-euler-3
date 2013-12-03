package pl.grzeslowski.project_euler_3;

public class Main {

    public static void main(final String[] args) {
        final long l = 600_851_475_143L;

        try {
            System.out.println(new ProjectEuler3DiffrentWay()
                    .findLargestPrimeFactor(l));
        } catch (final Throwable ex) {
            System.out.println(ex.getClass().getSimpleName());
        }
    }

}
