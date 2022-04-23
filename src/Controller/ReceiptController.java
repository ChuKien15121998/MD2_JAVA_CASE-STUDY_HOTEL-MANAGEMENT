package Controller;

import Model.Receipt;
import Model.User;
import Service.receiptService.ReceiptServiceIMPL;
import Service.staffService.UserServiceIMPL;

import java.util.List;

public class ReceiptController {
    ReceiptServiceIMPL receiptServiceIMPL = new ReceiptServiceIMPL();

    public List<Receipt> showListReceipt() {
        return receiptServiceIMPL.findAll();
    }

    public void createReceipt (Receipt receipt) {
        receiptServiceIMPL.save(receipt);
    }

    public Receipt findReceiptById (int id) {
        return receiptServiceIMPL.findByID(id);
    }

    public void deleteById (int id) {
        receiptServiceIMPL.deleteByID(id);
    }

    public Receipt findReceiptByRoomId (int id) {
        return receiptServiceIMPL.findReceiptByRoomId(id);
    }

    public double getAllTotalPrice() {
        return receiptServiceIMPL.getAllTotalPrice();
    }

}
