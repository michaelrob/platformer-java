package game;

import java.awt.event.KeyEvent;

public class Control {

    public int x = 0;
    public int y = 0;

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            x = 1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            x = -1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            x = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            x = 0;
        }
    }
}
