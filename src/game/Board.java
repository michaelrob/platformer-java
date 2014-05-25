package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.environment.*;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Map map;
    private Map map2;
    private Map map3;

    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.white);
        setDoubleBuffered(true);

        map = new Map("map", 1.0);
        map2 = new Map("map2", 1.0);
        map3 = new Map("map3", 0.5);

        timer = new Timer(5, this);
        timer.start();
    }

    public void paint (Graphics graphics) {
        super.paint(graphics);

        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.drawImage(map3.getMap(), map3.getX(), map3.getY(), this);
        graphics2D.drawImage(map2.getMap(), map2.getX(), map2.getY(), this);
        graphics2D.drawImage(map.getMap(), map.getX(), map.getY(), this);

        Toolkit.getDefaultToolkit().sync();

        graphics.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        map.move();
        map2.move();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            map.control.keyReleased(e);
            map2.control.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            map.control.keyPressed(e, map.getMapSpeed());
            map2.control.keyPressed(e, map2.getMapSpeed());
        }
    }
}
