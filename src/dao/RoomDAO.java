package dao;

import db.DBConnection;
import model.Room;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RoomDAO {git 

    // Add Room
    public boolean addRoom(Room room) {

        try {
            Connection con = DBConnection.getConnection();

            String query =
                    "INSERT INTO rooms(room_no, room_type, price, status) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, room.getRoomNo());
            ps.setString(2, room.getRoomType());
            ps.setDouble(3, room.getPrice());
            ps.setString(4, room.getStatus());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Get All Rooms
   public ArrayList<Room> getAllRooms() {

    ArrayList<Room> rooms = new ArrayList<>();

    try {

        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM rooms";

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {

            Room room = new Room();

            room.setRoomId(rs.getInt("room_id"));
            room.setRoomNo(rs.getString("room_no"));
            room.setRoomType(rs.getString("room_type"));
            room.setPrice(rs.getDouble("price"));
            room.setStatus(rs.getString("status"));

            rooms.add(room);
        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage()
        );

        e.printStackTrace();
    }

    return rooms;
}
}