package game.environment;

import game.Control;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Map extends JPanel {

    public Control control;
    BufferedImage map = null;
    private int x;
    private int y;
    private int dx;
    private int dy;

    public Map() {

        try {
            map = ImageIO.read(new File("src/game/res/map.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        x = 0;
        y = 0;

        control = new Control();
    }

    public void move() {
        x += control.x;
        y += control.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getMap() {
        return map;
    }
}
