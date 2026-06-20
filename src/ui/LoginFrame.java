package ui;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    public LoginFrame() {

        setTitle("Hotel Management System");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Login");
        panel.add(loginButton);

        add(panel);

        setVisible(true);
    }
}