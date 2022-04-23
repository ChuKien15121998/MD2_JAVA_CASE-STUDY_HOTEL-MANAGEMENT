package Model;

import java.io.Serializable;
import java.util.Date;

public class Receipt implements Serializable {
    private int receiptId;
    private User staff;
    private User guest;
    private Room room;
    private Date checkIn;
    private Date checkOut;
    private double totalPrice;

    public Receipt() {
    }

    public Receipt(int receiptId, User staff, User guest, Room room, Date checkIn, Date checkOut, double totalPrice) {
        this.receiptId = receiptId;
        this.staff = staff;
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public User getGuest() {
        return guest;
    }

    public void setGuest(User guest) {
        this.guest = guest;
    }

    public User getStaff() {
        return staff;
    }

    public void setStaff(User staff) {
        this.staff = staff;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptId=" + receiptId +
                ", staff=" + staff.toStringReceiptUser() +
                ", guest=" + guest.toStringReceiptUser() +
                ", room=" + room.toStringReceiptRoom() +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", totalPrice=" + totalPrice +
                '}' + "\n\n\n";
    }
}
