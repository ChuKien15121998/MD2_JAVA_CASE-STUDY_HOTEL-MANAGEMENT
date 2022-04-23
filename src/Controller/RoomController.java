package Controller;

import Model.Room;
import Model.RoomStatus;
import Service.roomService.RoomServiceIMPL;

import java.util.List;

public class RoomController {
    RoomServiceIMPL roomServiceIMPL = new RoomServiceIMPL();

    public List<Room> showListRoom() {
        return roomServiceIMPL.findAll();
    }

    public void createRoom(Room room) {
        roomServiceIMPL.save(room);
    }

    public Room findById(int id) {
        return roomServiceIMPL.findByID(id);
    }

    public void editRoomByID(int id, double roomPrice, String numberOfBedroom, String numberOfToilet, RoomStatus.roomStatusName roomStatusName) {
        roomServiceIMPL.editRoomByID(id, roomPrice, numberOfBedroom, numberOfToilet, roomStatusName);
    }

    public void deleteById(int id) {
        roomServiceIMPL.deleteByID(id);
    }

    public List<Room> showAvailableRoom() {
        return roomServiceIMPL.showAvailableRoom();
    }

    public List<Room> findAvailableRoomByPriceRange(double minPriceRoom, double maxPriceRoom) {
        return roomServiceIMPL.findAvailableRoomByPriceRange(minPriceRoom,maxPriceRoom);
    }
}
