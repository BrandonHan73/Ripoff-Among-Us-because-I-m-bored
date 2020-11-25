package main;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("window");
        frame.setVisible(true);
        frame.setSize(1900, 1100);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final ImageIcon CharacterRight = new ImageIcon("D:/Pictures/among-us-character.png");
        final ImageIcon CharacterLeft = new ImageIcon("D:/Pictures/among-us-character-left.png");
        final ImageIcon Map = new ImageIcon("D:/Pictures/among-us-map.jpg");

        Keyboard k = new Keyboard();
        Coordinate c = new Coordinate(-100, 100);

        JLabel l = new JLabel(CharacterRight);
        l.setBounds(100, 100, 220, 241);
        frame.add(l);

        JLabel map = new JLabel(Map);
        map.setBounds(-1000, -1000, 7090, 4120);
        frame.add(map);

        frame.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                char key = e.getKeyChar();

                switch(key) {
                    case 'w': k.w = true; break;
                    case 'a': k.a = true; l.setIcon(CharacterLeft); break;
                    case 's': k.s = true; break;
                    case 'd': k.d = true; l.setIcon(CharacterRight); break;

                }

            }

            public void keyReleased(KeyEvent e) {
                char key = e.getKeyChar();

                switch(key) {
                    case 'w': k.w = false; break;
                    case 'a': k.a = false; break;
                    case 's': k.s = false; break;
                    case 'd': k.d = false; break;

                }

            }

        });

        l.setBounds(100, 101, 220, 241);
        map.setBounds(-1001, -1000, 7090, 4120);

        int speed = 5;

        while(true) {
            if(k.w) {
                c.move(0, speed);

            }
            if(k.a) {
                c.move(speed, 0);

            }
            if(k.s) {
                c.move(0, 0-speed);

            }
            if(k.d) {
                c.move(0-speed, 0);

            }

            int wantedX, wantedY;
            wantedY = (frame.getSize().height / 2) - 120;
            wantedX = (frame.getSize().width / 2) - 110;

            l.setBounds(wantedX, wantedY, 220, 241);
            map.setBounds(c.getX(), c.getY(), 7090, 4120);

            long time = System.currentTimeMillis();
            while(true) {
                if(Math.abs(System.currentTimeMillis() - time) > 10) break;

            }

        }

    }

}
