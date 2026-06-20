package ui;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard() {

        setTitle("Hotel Management System");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setBounds(0, 0, 250, 700);
        sidebar.setBackground(new Color(33, 43, 54));
        sidebar.setLayout(null);

        JLabel logo = new JLabel("HOTEL HMS");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        logo.setBounds(40, 30, 180, 30);

        JButton btnDashboard = createButton("Dashboard", 100);
        JButton btnRooms = createButton("Manage Rooms", 160);
        JButton btnCustomers = createButton("Customers", 220);
        JButton btnCheckIn = createButton("Check-In", 280);
        JButton btnCheckOut = createButton("Check-Out", 340);
        JButton btnBills = createButton("Bills", 400);
        JButton btnReports = createButton("Reports", 460);
        JButton btnLogout = createButton("Logout", 520);

        sidebar.add(logo);
        sidebar.add(btnDashboard);
        sidebar.add(btnRooms);
        sidebar.add(btnCustomers);
        sidebar.add(btnCheckIn);
        sidebar.add(btnCheckOut);
        sidebar.add(btnBills);
        sidebar.add(btnReports);
        sidebar.add(btnLogout);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(250, 0, 950, 700);
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setLayout(null);

        JLabel heading = new JLabel("Dashboard");
        heading.setFont(new Font("Segoe UI", Font.BOLD, 28));
        heading.setBounds(30, 20, 250, 40);

        JPanel totalRooms = createCard("Total Rooms", "120");
        totalRooms.setBounds(30, 100, 220, 120);

        JPanel availableRooms = createCard("Available Rooms", "85");
        availableRooms.setBounds(280, 100, 220, 120);

        JPanel occupiedRooms = createCard("Occupied Rooms", "35");
        occupiedRooms.setBounds(530, 100, 220, 120);

        JPanel revenue = createCard("Revenue Today", "₹25,000");
        revenue.setBounds(780, 100, 220, 120);

        JTextArea activityArea = new JTextArea();
        activityArea.setText(
                "Recent Activities\n\n" +
                "• Room 101 Checked In\n" +
                "• Room 203 Checked Out\n" +
                "• New Customer Added\n");
        activityArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(activityArea);
        scrollPane.setBounds(30, 280, 850, 250);

        mainPanel.add(heading);
        mainPanel.add(totalRooms);
        mainPanel.add(availableRooms);
        mainPanel.add(occupiedRooms);
        mainPanel.add(revenue);
        mainPanel.add(scrollPane);

        add(sidebar);
        add(mainPanel);

        setVisible(true);
    }

    private JButton createButton(String text, int y) {
        JButton button = new JButton(text);
        button.setBounds(20, y, 210, 40);
        button.setFocusPainted(false);
        button.setBackground(new Color(52, 73, 94));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        return button;
    }

    private JPanel createCard(String title, String value) {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblTitle.setBounds(20, 20, 180, 20);

        JLabel lblValue = new JLabel(value);
        lblValue.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblValue.setBounds(20, 50, 180, 40);

        panel.add(lblTitle);
        panel.add(lblValue);

        return panel;
    }
}