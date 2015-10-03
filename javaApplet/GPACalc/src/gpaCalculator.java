import javax.swing.*;
import java.applet.Applet;
import java.util.Scanner;

/*
    Threads
    https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
    Java applets
    https://docs.oracle.com/javase/tutorial/deployment/applet/appletMethods.html
 */

public class gpaCalculator extends Applet {

    private Scanner in = new Scanner(System.in);

    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    boolean loop = true;
                    String user;
                    double total = 0;
                    double average;
                    double gpa;
                    int gradeAmt;

                    while (loop) {
                        System.out.println("How many grades to average?");
                        gradeAmt = in.nextInt();

                        for (int i = 1; i <= gradeAmt; i++) {
                            System.out.println("Enter grade " + i + ":");
                            total += in.nextDouble();
                        }

                        average = total / gradeAmt;
                        gpa = 4 * average / 100;

                        System.out.println("\nAverage = " + average);
                        System.out.println("GPA = " + gpa);

                        System.out.println("\nAgain?");
                        user = in.nextLine();

                        if (!user.equals("yes")) loop = false;
                    }
                    System.out.println("\nDone");
                }
            });
        } catch (Exception e) {
            System.err.println("program didn't complete successfully");
        }
    }
}
