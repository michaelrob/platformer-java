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

    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.white);
        setDoubleBuffered(true);

        map = new Map();

        timer = new Timer(5, this);
        timer.start();
    }

    public void paint (Graphics graphics) {
        super.paint(graphics);

        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.drawImage(map.getMap(), map.getX(), map.getY(), this);

        Toolkit.getDefaultToolkit().sync();

        graphics.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        map.move();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            map.control.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            map.control.keyPressed(e);
        }
    }
}
