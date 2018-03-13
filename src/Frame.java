import javax.swing.*;

public class Frame extends JFrame
{
    private String pseudo;
    private Panel panel;
    private PseudoPanel pseudoPanel;
    public Frame()
    {
        this.pseudoPanel = new PseudoPanel(this);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400,400);
        setContentPane(pseudoPanel);
        this.setVisible(true);
    }

    public String getPseudo()
    {
        return pseudoPanel.getPseudo();
    }
}
