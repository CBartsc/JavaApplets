import javax.swing.*;
import java.applet.Applet;
import java.awt.event.*;
import java.util.Scanner;

/*
* Thread tutorial
* https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
*
* Java applet tutorial
* https://docs.oracle.com/javase/tutorial/deployment/applet/appletMethods.html
* http://www.realapplets.com/tutorial/ActionExample.html
*
* Layout tutorial
* https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
*/

public class gpaCalculator extends Applet implements ActionListener {

    private Scanner in = new Scanner(System.in);
    private Scanner user = new Scanner(System.in);

    // Constructor
    public gpaCalculator() {}

    public void work() {
        boolean loop = true;
        String userInput;
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

            System.out.println("\nAverage = " + String.format("%.4g%n", average));
            System.out.println("GPA = " + String.format("%.3g%n", gpa));

            System.out.println("\nAgain?");
            userInput = user.nextLine();

            if (!userInput.equals("yes")) loop = false;
        }
        System.out.println("\nDone");
    }

    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    gpaCalculator calc = new gpaCalculator();
                    calc.work();
                }
            });
        } catch (Exception e) {
            System.err.println("program didn't complete successfully");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}
