package Service.receiptService;

import Model.Receipt;
import Service.IGenericService;

public interface IReceiptService extends IGenericService<Receipt> {
    Receipt findReceiptByRoomId (int id);
    double getAllTotalPrice ();
    void save();
}
