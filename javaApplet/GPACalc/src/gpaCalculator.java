import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

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

    Label label = new Label("GPA Calculator");
    TextArea output = new TextArea();
    TextField input = new TextField(5);
    Button enter = new Button("Enter");

    public gpaCalculator() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(label)
                                .addComponent(output)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(input)
                                        .addComponent(enter)))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                        .addComponent(label)
                        .addComponent(output)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(input)
                                .addComponent(enter))
        );

        output.setEditable(false);
        enter.addActionListener(this);
        input.requestFocus();
    }

    public void print(String str) {
        output.append(str);
    }

    @Override
    public void init() {
        print("How many grades to average?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enter) {
            output.append(input.getText() + "\n");
            input.setText("");
        }
    }
}
