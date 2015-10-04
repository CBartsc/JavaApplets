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

    public void work() {

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
