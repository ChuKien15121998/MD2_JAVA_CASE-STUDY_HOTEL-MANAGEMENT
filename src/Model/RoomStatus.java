package Model;

import java.io.Serializable;

public class RoomStatus implements Serializable {
    public enum roomStatusName {
        AVAILABLE, UNAVAILABLE, FIXING
    }
}
