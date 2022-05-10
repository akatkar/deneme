package com.alikatkar.lesson.numbers.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Toolbar extends JToolBar {

    private JTextField startNumber;
    private JTextField stopNumber;

    public Toolbar(ActionListener actionListener) {
        // create a combo box
        String [] languages = { "TR", "EN", "DE" };
        JComboBox<String> comboBox = new JComboBox<>(languages);
        comboBox.setEditable(true);
        comboBox.addActionListener(actionListener);
        comboBox.setName("LanguageSelection");
        this.add(comboBox);

        String [] items = { "Random", "Sequential"};
        JComboBox<String> orders = new JComboBox<>(items);
        orders.setEditable(true);
        orders.addActionListener(actionListener);
        orders.setName("OrderSelection");
        this.add(orders);

        JLabel startLabel = new JLabel();
        startLabel.setText("Start:");
        startNumber = new NumberTextField();
        startNumber.setText("0");

        this.add(startLabel);
        this.add(startNumber);

        JLabel stopLabel = new JLabel();
        stopLabel.setText("Stop:");
        stopNumber = new NumberTextField();
        stopNumber.setText("100");

        this.add(stopLabel);
        this.add(stopNumber);

        JButton setButton = new JButton();
        setButton.setText("Set Range");
        setButton.setName("SetRange");
        setButton.addActionListener(actionListener);
        this.add(setButton);
    }

    public long getStartNumber() {
        return Long.parseLong(startNumber.getText());
    }

    public long getStopNumber() {
        return Long.parseLong(stopNumber.getText());
    }

    public void setFocusStopNumber() {
        stopNumber.setText((getStartNumber() + 1) + "");
        stopNumber.requestFocusInWindow();
    }
}
