import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

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

    Label titleLabel = new Label("GPA Calculator");
    Label totalLabel = new Label("Total = 0");
    Label averageLabel = new Label("Average = 0");
    Label gpaLabel = new Label("GPA = 0");
    Label promptLabel = new Label("Enter a number to add:");
    TextField input = new TextField(5);
    Button enter = new Button("Enter");
    
    int ammount = 0;
    String toAdd;
    double total = 0, average = 0, gpa = 0;

    public gpaCalculator() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(titleLabel)
                                .addComponent(promptLabel)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(totalLabel)
                                        .addComponent(averageLabel)
                                        .addComponent(gpaLabel))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(input)
                                        .addComponent(enter)))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addComponent(promptLabel)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(totalLabel)
                                .addComponent(averageLabel)
                                .addComponent(gpaLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(input)
                                .addComponent(enter))
        );

        //output.setEditable(false);
        enter.addActionListener(this);
    }

    @Override
    public void init() {
        input.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enter) {
            toAdd = input.getText();
            input.setText("");
            total += Double.parseDouble(toAdd);
            ammount++;
            
            average = total / ammount;
            gpa = 4 * average / 100;
            
            totalLabel.setText("Total = " + total);
            averageLabel.setText("Average = " + String.format("%.4g", average));
            gpaLabel.setText("GPA = " + String.format("%.3g", gpa));
        }
    }
}
