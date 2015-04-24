package com.tyshchenko.training.java.oop.lesson12.chat.server;

import javax.swing.*;
import java.awt.*;

/**
 * @author Alexander Tyshchenko.
 */
public class ChatServer {

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.start();
    }

    public void start() {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Nimbus LookAndFeel is unavailable");
        }

        EventQueue.invokeLater(() -> {
            ServerChatForm frame = new ServerChatForm("ServerChatForm");
            frame.setContentPane(frame.getContentPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }

}
