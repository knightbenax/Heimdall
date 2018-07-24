package android.heimdallr.app.heimdallr.core.database;

import android.heimdallr.app.heimdallr.core.database.models.User;

import javax.inject.Inject;


public class OfflineStore {

    private RoomManager roomManager;

    @Inject
    public OfflineStore(RoomManager roomManager){
        this.roomManager = roomManager;
    }

    public void saveUser(String name, String email, String phone, String token, String refreshToken, String wallet){

        roomManager.saveUser(name, email, phone, token, refreshToken, wallet);

    }

    public void saveUser(User user){
        roomManager.saveUser(user);
    }

    public boolean userExists(){
        return roomManager.userExists();
    }

    public void deleteUsers(){
        roomManager.deleteUsers();
    }

    public User getUser(){
        return roomManager.getUser();
    }
}
