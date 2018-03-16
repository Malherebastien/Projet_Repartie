import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel
{
    private JTextArea textArea;
    private JTextField textField;
    private JButton button;

    public Panel()
    {
        this.setLayout(new BorderLayout());
        JPanel gauche = new JPanel();
        this.add(gauche, BorderLayout.WEST);

        this.textArea = new JTextArea();
        gauche.add(this.textArea, BorderLayout.CENTER);

        this.textField = new JTextField();
        gauche.add(this.textField, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public void listenMessage()
    {

    }

    public void newMessage(String str)
    {
        this.textArea.setText(this.textArea.getText() + str);
    }
}
