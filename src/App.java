import java.util.Scanner;

public class App {
    
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        double p = 0, p0, p1, tolerance, value, q0, q1;


        System.out.print("\nEnter the initial approximation, P0: ");
        p0 = scanner.nextDouble();

        System.out.print("\nEnter the initial approximation, P1: ");
        p1 = scanner.nextDouble();

        System.out.print("\nEnter the number of iterations: ");
        int numOfIterations = scanner.nextInt();

        System.out.print("\nEnter the tolerance value: ");
        tolerance = scanner.nextDouble();

        int i = 2;

        while(i < numOfIterations){
            q0 = getCos(p0);
            q1 = getCos1(p1);
            p = (p1 - q1 * (p1 - q0)) / (q1 - q0);
            value = p - p1;

            if((Math.abs(value)) < tolerance) {
                System.out.println("Procedure completed successfully! X = " + p);
            }

            p0 = p1;
            q0 = q1;
            p1 = p;
            q1 = getP(p);

            i++;

        }
        System.out.println("Procedure completed unsuccessfully. Method failed after no iterations. X = " + p);

    }

    private static double getCos(double p0){
        return (Math.cos(p0) - p0);
    }

    private static double getCos1(double p1){
        return (Math.cos(p1) - p1);
    }

    private static double getP(double p){
        return (Math.cos(p) - p);
    }
}
