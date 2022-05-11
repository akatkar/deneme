package com.alikatkar.lesson.numbers.gui;

import javax.swing.*;
import java.awt.*;

public class TextField extends JLabel {
    public TextField() {
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(new Font("Consolas", Font.PLAIN, 40));
        this.setBorder(BorderFactory.createRaisedSoftBevelBorder());
    }
}
