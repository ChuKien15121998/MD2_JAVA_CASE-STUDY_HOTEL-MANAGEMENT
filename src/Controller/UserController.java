package Controller;

import Model.User;
import Service.staffService.UserServiceIMPL;

import java.util.List;

public class UserController {
    UserServiceIMPL userServiceIMPL = new UserServiceIMPL();

    public List<User> showListUser() {
        return userServiceIMPL.findAll();
    }

    public void createUser (User user) {
        userServiceIMPL.save(user);
    }

    public User findById (int id) {
        return userServiceIMPL.findByID(id);
    }

    public void deleteById (int id) {
        userServiceIMPL.deleteByID(id);
    }

    public boolean existedByUserName (String username) {
        return userServiceIMPL.existedByUsername(username);
    }

    public List<User> showUserLogging() {
        return userServiceIMPL.findAllLogging();
    }

    public void updateUserLogging (User user) {
        userServiceIMPL.saveLogging(user);
    }

    public User findStaffById(int id) {
        return userServiceIMPL.findStaffById(id);
    }

    public User findGuestById(int id) {
        return userServiceIMPL.findGuestById(id);
    }

    public List<User> showStaffList() {
        return userServiceIMPL.findAllStaff();
    }

    public List<User> showGuestList() {
        return userServiceIMPL.findAllGuest();
    }

    public void createStaff (User user) {
        userServiceIMPL.saveStaff(user);
    }

    public void createGuest (User user) {
        userServiceIMPL.saveGuest(user);
    }

    public void louout() {
        userServiceIMPL.logout();
    }
}
