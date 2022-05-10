package com.alikatkar.lesson.numbers.gui;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class NumberTextField extends JTextField {
    @Override
    protected Document createDefaultModel() {
        return new NumberDocument();
    }

    static class NumberDocument extends PlainDocument {
        String numbers = "1234567890";

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str.length() == 1) {
                if (numbers.contains(str)) {
                    super.insertString(offs, str, a);
                }
            } else {
                try {
                    Long.parseLong(str);
                    super.insertString(offs, str, a);
                } catch (Exception ignored) {
                    // ignored exception
                }
            }
        }
    }
}