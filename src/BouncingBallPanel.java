import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class BouncingBallPanel extends JPanel {
    static final int DIAMETER = 40;

    int x = 0;
    int y = 0;
    int dx = 2;
    int dy = 2;

    // animation: change in graphics over time
    // use a Timer for time
    static final int DELAY = 10; // milliseconds
    Timer timer;

    public BouncingBallPanel() {
        // first arg is the delay
        // second arg is an action listener... actionPerfromed() will be
        // called every time Timer fires (every DELAY ms)
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);

        if (x > (getWidth() - DIAMETER)) {
            dx = -Math.abs(dx);
        }
        if (y > (getHeight() - DIAMETER)) {
            dy = -Math.abs(dy);
        }
        if (x < 0) {
            dx = Math.abs(dx);
        }
        if (y < 0) {
            dy = Math.abs(dy);
        }

        x += dx;
        y += dy;

        Ellipse2D.Double ball = new Ellipse2D.Double(x, y, DIAMETER, DIAMETER);
        g2.fill(ball);
    }
}
