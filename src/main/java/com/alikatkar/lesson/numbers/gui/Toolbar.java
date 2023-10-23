package com.alikatkar.lesson.numbers.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

import com.alikatkar.lesson.numbers.converter.Language;
import com.alikatkar.lesson.numbers.generator.GeneratorType;

public class Toolbar extends JToolBar {

    private final JTextField startNumber;
    private final JTextField stopNumber;

    public Toolbar(ActionListener actionListener) {
        // create a combo box
        JComboBox<Language> comboBox = new JComboBox<>(Language.values());
        comboBox.setEditable(true);
        comboBox.addActionListener(actionListener);
        comboBox.setName("LanguageSelection");
        this.add(comboBox);

        JComboBox<GeneratorType> orders = new JComboBox<>(GeneratorType.values());
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
