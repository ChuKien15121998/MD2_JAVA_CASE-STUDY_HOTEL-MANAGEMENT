package Service.roomService;

import Config.ConfigReadAndWriteFile;
import Model.Role;
import Model.Room;
import Model.RoomStatus;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class RoomServiceIMPL implements IRoomService{

    public static String PATH_ROOM = "E:\\CODEGYM_C0222I1\\CODE\\MD2\\CASE_STUDY\\MD2_JAVA_CASE-STUDY_HOTEL-MANAGEMENT\\src\\Data\\roomData.txt";
    public static List<Room> roomList = new ConfigReadAndWriteFile<Room>().readFromFile(PATH_ROOM);

    @Override
    public List<Room> findAll() {
        new ConfigReadAndWriteFile<Room>().writeToFile(PATH_ROOM, roomList);
        return roomList;
    }

    @Override
    public void save(Room room) {
        roomList.add(room);
        new ConfigReadAndWriteFile<Room>().writeToFile(PATH_ROOM, roomList);
    }

    public void save() {
        new ConfigReadAndWriteFile<Room>().writeToFile(PATH_ROOM, roomList);
    }

    @Override
    public void deleteByID(int id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (id == roomList.get(i).getRoomID()) {
                roomList.remove(roomList.get(i));
            }
        }
    }
    @Override
    public void editByID(int id){

    }

    @Override
    public void editRoomByID(int id, double roomPrice, String numberOfBedroom, String numberOfToilet, RoomStatus.roomStatusName roomStatusName) {
        for (int i = 0; i < roomList.size(); i++) {
            if (id == roomList.get(i).getRoomID()) {
                roomList.get(i).setRoomPrice(roomPrice);
                roomList.get(i).setNumberOfBedroom(numberOfBedroom);
                roomList.get(i).setNumberOfToilet(numberOfToilet);
                roomList.get(i).setRoomStatus(roomStatusName);
            }
        }
        new ConfigReadAndWriteFile<Room>().writeToFile(PATH_ROOM, roomList);
    }

    @Override
    public Room findByID(int id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (id == roomList.get(i).getRoomID()) {
                return roomList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Room> showAvailableRoom() {
        List<Room> availableRoomList = new ArrayList<>();
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getRoomStatus() == RoomStatus.roomStatusName.AVAILABLE) {
                availableRoomList.add(roomList.get(i));
            }
        }
        return availableRoomList;
    }

    @Override
    public List<Room> findAvailableRoomByPriceRange(double minRoomPrice, double maxRoomPrice) {
        List<Room> showAvailableRoom = new RoomServiceIMPL().showAvailableRoom();
        List<Room> priceRangeRoomList = new ArrayList<>();
        for (int i = 0; i < showAvailableRoom.size(); i++) {
            if (showAvailableRoom.get(i).getRoomPrice() >= minRoomPrice && showAvailableRoom.get(i).getRoomPrice() <= maxRoomPrice) {
                priceRangeRoomList.add(showAvailableRoom.get(i));
            }
        }
        return priceRangeRoomList;
    }
}
