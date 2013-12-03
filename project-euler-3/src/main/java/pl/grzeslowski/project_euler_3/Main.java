package pl.grzeslowski.project_euler_3;

public class Main {

    public static void main(final String[] args) {
        final long value = Long.parseLong(args[0]);

        final ProjectEuler3DiffrentWay euler = new ProjectEuler3DiffrentWay();
        System.out.println(euler
                .findLargestPrimeFactor(value));
    }

}
