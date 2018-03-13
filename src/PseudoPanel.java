import javafx.scene.layout.Border;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PseudoPanel extends JPanel
{
    private String pseudo;
    private JTextField tf;
    private Frame frame;
    public PseudoPanel(Frame frame)
    {
        this.frame = frame;
        BorderLayout bl = new BorderLayout();
        this.setLayout(bl);
        tf = new JTextField(25);
        JButton button = new JButton("connexion");
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                pseudo = tf.getText();
                System.out.println(pseudo);
                setVisible(false);
                frame.setContentPane(new Panel());
            }
        });
        this.add(tf, BorderLayout.CENTER);
        tf.setPreferredSize(new Dimension(25, 15));
        this.add(button, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public String getPseudo()
    {
        return pseudo;
    }
}
