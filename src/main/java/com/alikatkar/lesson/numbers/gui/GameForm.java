package com.alikatkar.lesson.numbers.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.alikatkar.lesson.numbers.converter.Language;
import com.alikatkar.lesson.numbers.generator.GeneratorType;

public class GameForm extends JFrame implements ActionListener {

    private static final String TITLE = "Numbers v1.0";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;

    private static final int X_LOCATION = 200;
    private static final int Y_LOCATION = 200;

    private GamePanel gamePanel;
    private Toolbar toolbar;

    public static void run() {
        new GameForm();
    }

    private GameForm() throws HeadlessException {
        super(TITLE);
        initComponents();
        setSize(WIDTH, HEIGHT);
        setLocation(X_LOCATION, Y_LOCATION);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        toolbar = new Toolbar(this);
        toolbar.setBorder(BorderFactory.createRaisedSoftBevelBorder());
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
        if (e.getSource() instanceof JComboBox<?> comboBox) {
            if(comboBox.getName().equals("LanguageSelection")) {
                Language lang = (Language) comboBox.getSelectedItem();
                gamePanel.setConverter(lang);
            } else if (comboBox.getName().equals("OrderSelection")) {
                GeneratorType type = (GeneratorType) comboBox.getSelectedItem();
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
