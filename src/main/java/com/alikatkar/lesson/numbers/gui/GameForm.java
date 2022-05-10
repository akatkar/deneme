package com.alikatkar.lesson.numbers.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameForm extends JFrame implements ActionListener {

    private final GamePanel gamePanel;
    private final Toolbar toolbar;

    public static void run() {
        new GameForm();
    }

    private GameForm() throws HeadlessException {
        JFrame f = new JFrame("Numbers v1.0");
        f.setSize(800, 400);
        f.setLocation(200, 200);
        f.setResizable(false);
        f.addWindowListener(new WindowAdapter( ) {
            @Override
            public void windowClosing(WindowEvent we) { System.exit(0); }
        });

        JButton playButton = new JButton("Play");

        // put the controls the content pane
        Container c = f.getContentPane( );
        gamePanel = new GamePanel();
        toolbar = new Toolbar(this);
        c.add(toolbar, BorderLayout.NORTH);
        c.add(gamePanel, BorderLayout.CENTER);
        c.add(playButton, BorderLayout.SOUTH);

        playButton.setFont(new Font("Consolas", Font.BOLD, 20));

        playButton.addActionListener(ae -> gamePanel.nextNumber());

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox comboBox) {
            if(comboBox.getName().equals("LanguageSelection")) {
                String lang = (String) comboBox.getSelectedItem();
                gamePanel.setConverter(lang);
            } else if (comboBox.getName().equals("OrderSelection")) {
                String type = (String) comboBox.getSelectedItem();
                gamePanel.setGenerator(type);
            }
        } else if (e.getSource() instanceof JButton) {
            long startNumber = toolbar.getStartNumber();
            long stopNumber = toolbar.getStopNumber();
            if (stopNumber <= startNumber) {
                toolbar.setFocusStopNumber();
                return;
            }
            gamePanel.setNumberRange(startNumber, stopNumber);
        }
    }
}
