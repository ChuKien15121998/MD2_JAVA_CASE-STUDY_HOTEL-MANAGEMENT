package Model;

import java.io.Serializable;

public class Room implements Serializable {
    private int roomID;
    private double roomPrice;
    private String numberOfBedroom;
    private String numberOfToilet;
    private RoomStatus.roomStatusName roomStatus;

    public Room() {
    }

    public Room(int roomID, double roomPrice, String numberOfBedroom, String numberOfToilet, RoomStatus.roomStatusName roomStatus) {
        this.roomID = roomID;
        this.roomPrice = roomPrice;
        this.numberOfBedroom = numberOfBedroom;
        this.numberOfToilet = numberOfToilet;
        this.roomStatus = roomStatus;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getNumberOfBedroom() {
        return numberOfBedroom;
    }

    public void setNumberOfBedroom(String numberOfBedroom) {
        this.numberOfBedroom = numberOfBedroom;
    }

    public String getNumberOfToilet() {
        return numberOfToilet;
    }

    public void setNumberOfToilet(String numberOfToilet) {
        this.numberOfToilet = numberOfToilet;
    }

    public RoomStatus.roomStatusName getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus.roomStatusName roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomID=" + roomID +
                ", roomPrice='" + roomPrice + '\'' +
                ", numberOfBedroom='" + numberOfBedroom + '\'' +
                ", numberOfToilet='" + numberOfToilet + '\'' +
                ", roomStatus=" + roomStatus +
                '}' + "\n";
    }

    public String toStringReceiptRoom() {
        return "Room{" +
                "roomID=" + roomID +
                ", roomPrice=" + roomPrice +
                ", numberOfBedroom='" + numberOfBedroom + '\'' +
                ", numberOfToilet='" + numberOfToilet + '\'' +
                '}' + "\n";
    }
}
