package com.tyshchenko.training.java.oop.lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alexander Tyshchenko.
 */
public class InnerAnonymousClassExample {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(new Dimension(640, 480));

        window.setLayout(new BorderLayout());

        JButton button = new JButton();
        button.setText("Click");
        button.setFont(new Font("Arial", Font.BOLD, 40));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setText("Clicked");
                button.setForeground(Color.BLUE);
            }
        });

        // java 8
//        button.addActionListener((e) -> {
//            button.setText("Clicked");
//            button.setForeground(Color.BLUE);
//        });

        window.add(button, BorderLayout.CENTER);
        window.setVisible(true);
    }
}
