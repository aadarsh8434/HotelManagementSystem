package ui;

import dao.RoomDAO;
import model.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ManageRoomsFrame extends JFrame {

    private JTextField roomNoField;
    private JTextField priceField;

    private JComboBox<String> roomTypeBox;
    private JComboBox<String> statusBox;

    private JButton addBtn;
    private JButton clearBtn;

    private JTable table;
    private DefaultTableModel tableModel;

    public ManageRoomsFrame() {

        setTitle("Hotel Management System");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("HOTEL MANAGEMENT SYSTEM");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(150, 20, 700, 40);
        add(title);
        JLabel roomNoLbl = new JLabel("Room No");
        roomNoLbl.setBounds(50, 100, 100, 30);
        add(roomNoLbl);

        roomNoField = new JTextField();
        roomNoField.setBounds(160, 100, 220, 35);
        add(roomNoField);

        JLabel roomTypeLbl = new JLabel("Room Type");
        roomTypeLbl.setBounds(50, 160, 100, 30);
        add(roomTypeLbl);

        roomTypeBox = new JComboBox<>(
                new String[]{"Single", "Double", "Deluxe", "Suite"});
        roomTypeBox.setBounds(160, 160, 220, 35);
        add(roomTypeBox);

        JLabel priceLbl = new JLabel("Price");
        priceLbl.setBounds(50, 220, 100, 30);
        add(priceLbl);

        priceField = new JTextField();
        priceField.setBounds(160, 220, 220, 35);
        add(priceField);

        JLabel statusLbl = new JLabel("Status");
        statusLbl.setBounds(50, 280, 100, 30);
        add(statusLbl);

        statusBox = new JComboBox<>(
                new String[]{"Available", "Occupied"});
        statusBox.setBounds(160, 280, 220, 35);
        add(statusBox);

        addBtn = new JButton("Add Room");
        addBtn.setBounds(50, 360, 120, 40);
        add(addBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(190, 360, 120, 40);
        add(clearBtn);

        String[] columns = {
                "ID",
                "Room No",
                "Room Type",
                "Price",
                "Status"
        };

        tableModel = new DefaultTableModel(columns, 0);

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(450, 100, 500, 400);

        add(scrollPane);

        addBtn.addActionListener(e -> addRoom());
        clearBtn.addActionListener(e -> clearFields());

        loadRooms();

        setVisible(true);
    }

    private void addRoom() {

        try {

            String roomNo = roomNoField.getText().trim();

            String roomType =
                    roomTypeBox.getSelectedItem().toString();

            String priceText =
                    priceField.getText().trim();

            String status =
                    statusBox.getSelectedItem().toString();

            if (roomNo.isEmpty() || priceText.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all fields"
                );

                return;
            }

            double price =
                    Double.parseDouble(priceText);

            Room room = new Room(
                    roomNo,
                    roomType,
                    price,
                    status
            );

            RoomDAO dao = new RoomDAO();

            if (dao.addRoom(room)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Room Added Successfully"
                );

                loadRooms();

                clearFields();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Failed To Add Room"
                );
            }

        } catch (Exception ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage()
            );
        }
    }

    private void loadRooms() {

        tableModel.setRowCount(0);

        RoomDAO dao = new RoomDAO();

        for (Room room : dao.getAllRooms()) {

            tableModel.addRow(
                    new Object[]{
                            room.getRoomId(),
                            room.getRoomNo(),
                            room.getRoomType(),
                            room.getPrice(),
                            room.getStatus()
                    }
            );
        }
    }

    private void clearFields() {

        roomNoField.setText("");
        priceField.setText("");

        roomTypeBox.setSelectedIndex(0);
        statusBox.setSelectedIndex(0);
    }
}