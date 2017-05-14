/**
 * Created by Joonas on 13.5.2017.
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class askName extends JFrame {

    private String name;
    private boolean done = false;

    public askName(client talker, ArrayList<String> moves){

        setLayout(new BorderLayout());

        JLabel enterFileName = new JLabel("Enter the name of your scribble:");
        JTextField textBoxToEnterName = new JTextField(21);
        JPanel panelTop = new JPanel();
        panelTop.add(enterFileName);
        panelTop.add(textBoxToEnterName);

        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = textBoxToEnterName.getText();
                new save(talker, moves, name);
                dispose();
            }
        });
        JPanel panelBottom = new JPanel();
        panelBottom.add(submit);
        //Add panelTop to JFrame
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);

        //JFrame set-up
        setTitle("Name Prompt Program");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
