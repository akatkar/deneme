package com.alikatkar.lesson.numbers.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameForm extends JFrame implements ActionListener {

    private GamePanel gamePanel;
    private Toolbar toolbar;

    public static void run() {
        new GameForm();
    }

    private GameForm() throws HeadlessException {
        super("Numbers v1.0");
        initComponents();
        setSize(800, 400);
        setLocation(200, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        toolbar = new Toolbar(this);
        panel.add(toolbar, BorderLayout.NORTH);
        gamePanel = new GamePanel();
        panel.add(gamePanel, BorderLayout.CENTER);

        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Consolas", Font.BOLD, 20));
        playButton.addActionListener(ae -> gamePanel.nextNumber());
        panel.add(playButton, BorderLayout.SOUTH);
        this.add(panel);
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
