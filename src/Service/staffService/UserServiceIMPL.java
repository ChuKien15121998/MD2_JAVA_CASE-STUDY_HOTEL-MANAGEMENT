package Service.staffService;

import Config.ConfigReadAndWriteFile;
import Model.Role;
import Model.Room;
import Model.RoomStatus;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceIMPL implements IUserService {
    public static String PATH_USER = "E:\\CODEGYM_C0222I1\\CODE\\MD2\\CASE_STUDY\\MD2_JAVA_CASE-STUDY_HOTEL-MANAGEMENT\\src\\Data\\userData.txt";
    public static List<User> userList = new ConfigReadAndWriteFile<User>().readFromFile(PATH_USER);

    public static String PATH_LOGGING = "E:\\CODEGYM_C0222I1\\CODE\\MD2\\CASE_STUDY\\MD2_JAVA_CASE-STUDY_HOTEL-MANAGEMENT\\src\\Data\\loggingData.txt";
    public static List<User> userLoggingList = new ConfigReadAndWriteFile<User>().readFromFile(PATH_LOGGING);

    public static String PATH_STAFF = "E:\\CODEGYM_C0222I1\\CODE\\MD2\\CASE_STUDY\\MD2_JAVA_CASE-STUDY_HOTEL-MANAGEMENT\\src\\Data\\staffData.txt";
    public static List<User> staffList = new ConfigReadAndWriteFile<User>().readFromFile(PATH_STAFF);

    public static String PATH_GUEST = "E:\\CODEGYM_C0222I1\\CODE\\MD2\\CASE_STUDY\\MD2_JAVA_CASE-STUDY_HOTEL-MANAGEMENT\\src\\Data\\guestData.txt";
    public static List<User> guestList = new ConfigReadAndWriteFile<User>().readFromFile(PATH_GUEST);

    @Override
    public List<User> findAllLogging() {
        new ConfigReadAndWriteFile<User>().writeToFile(PATH_LOGGING,userLoggingList);
        return userLoggingList;
    }

    @Override
    public void saveLogging(User user) {
        userLoggingList.clear();
        userLoggingList.add(user);
        new ConfigReadAndWriteFile<User>().writeToFile(PATH_LOGGING, userLoggingList);
    }

    @Override
    public void logout() {
        userLoggingList.clear();
        new ConfigReadAndWriteFile<User>().writeToFile(PATH_LOGGING, userLoggingList);
    }

    @Override
    public List<User> findAll() {
        new ConfigReadAndWriteFile<User>().writeToFile(PATH_USER,userList);
        return userList;
    }

    @Override
    public List<User> findAllStaff() {
        new ConfigReadAndWriteFile<User>().writeToFile(PATH_STAFF,staffList);
        return staffList;
    }

    @Override
    public List<User> findAllGuest() {
        new ConfigReadAndWriteFile<User>().writeToFile(PATH_GUEST,guestList);
        return guestList;
    }

    @Override
    public void save(User user) {
        userList.add(user);
        new ConfigReadAndWriteFile<User>().writeToFile(PATH_USER, userList);
    }

    @Override
    public void saveStaff(User user) {
        staffList.add(user);
        new ConfigReadAndWriteFile<User>().writeToFile(PATH_STAFF, staffList);
    }

    @Override
    public void saveGuest(User user) {
        guestList.add(user);
        new ConfigReadAndWriteFile<User>().writeToFile(PATH_GUEST, guestList);
    }

    @Override
    public void deleteByID(int id) {
        for (int i = 0; i < userList.size(); i++) {
            if (id == userList.get(i).getUserID()) {
                userList.remove(userList.get(i));
            }
        }
    }

    @Override
    public void editByID(int id) {

    }

    @Override
    public User findByID(int id) {
        for (int i = 0; i < userList.size(); i++) {
            if (id == userList.get(i).getUserID()) {
                return userList.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean existedByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if(username.equals(userList.get(i).getUserName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public User findStaffById(int id) {
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getUserID()) {
                return staffList.get(i);
            }
        }
        return null;
    }

    @Override
    public User findGuestById(int id) {
        for (int i = 0; i < guestList.size(); i++) {
            if (id == guestList.get(i).getUserID()) {
                return guestList.get(i);
            }
        }
        return null;
    }
}
