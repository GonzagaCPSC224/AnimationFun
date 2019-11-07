import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    public View() {
        super("Bouncing Ball");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 500));
        getContentPane().add(new BouncingBallPanel());
        pack();
    }
}
