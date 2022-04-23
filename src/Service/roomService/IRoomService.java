package Service.roomService;

import Model.Room;
import Model.RoomStatus;
import Service.IGenericService;
import java.util.List;

public interface IRoomService extends IGenericService<Room> {
    List<Room> showAvailableRoom();

    List<Room> findAvailableRoomByPriceRange(double minRoomPrice, double maxRoomPrice);

    void editRoomByID(int id, double roomPrice, String numberOfBedroom, String numberOfToilet, RoomStatus.roomStatusName roomStatusName);

    void save();
}