package game;

import java.awt.event.KeyEvent;

public class Control {

    public Double x = 0.0;
    public Double y = 0.0;

    public void keyPressed(KeyEvent e, Double speed) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            x = speed;
        }

        if (key == KeyEvent.VK_RIGHT) {
            x = -speed;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            x = 0.0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            x = 0.0;
        }
    }
}
