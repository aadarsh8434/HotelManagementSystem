import dao.RoomDAO;
import model.Room;

public class TestRoom {

    public static void main(String[] args) {

        Room room = new Room(
                "103",
                "Single",
                1500,
                "Available"
        );

        RoomDAO dao = new RoomDAO();

        if (dao.addRoom(room)) {
            System.out.println("Room Added Successfully!");
        } else {
            System.out.println("Failed to Add Room!");
        }
    }
}