package com.alikatkar.lesson.numbers.gui;

import com.alikatkar.lesson.numbers.converter.NumberToTextConverter;
import com.alikatkar.lesson.numbers.generator.NumberGenerator;
import com.alikatkar.lesson.numbers.generator.RandomGenerator;
import com.alikatkar.lesson.numbers.generator.SequentialGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {

    private final TextField numberLabel = new TextField();
    private final TextField textLabel = new TextField();
    private String generatorType = "Random";
    private long currentNumber;
    private long startNumber = 0;
    private long stopNumber = 100;
    private transient NumberGenerator numberGenerator;

    private transient NumberToTextConverter converter = NumberToTextConverter.of("tr");

    public GamePanel(ActionListener actionListener){
        this.actionListener = actionListener;
        this.initComponents();
        this.updateGenerator();
    }

    private void initComponents(){
        this.setLayout(new GridLayout(2, 1));
        numberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numberLabel.setVerticalAlignment(SwingConstants.CENTER);
        textLabel.setVerticalAlignment(SwingConstants.CENTER);

        this.add(numberLabel);
        this.add(textLabel);
    }

    public void nextNumber() {
        currentNumber = numberGenerator.nextNumber();
        updateScreen();
    }

    public void setConverter(String language) {
        converter = NumberToTextConverter.of(language);
        updateScreen();
    }

    public void setGenerator(String type) {
        generatorType = type;
        updateGenerator();
    }

    public void setNumberRange(long start, long stop) {
        this.startNumber = start;
        this.stopNumber = stop;
        updateGenerator();
    }

    private void updateGenerator() {
        numberGenerator = "Random".equals(generatorType)
                ? new RandomGenerator(startNumber, stopNumber)
                : new SequentialGenerator(startNumber, stopNumber);
        nextNumber();
    }

    private void updateScreen() {
        numberLabel.setText(String.valueOf(currentNumber));
        textLabel.setText(converter.toText(currentNumber));
    }

}
