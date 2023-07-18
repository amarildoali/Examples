package com.amarildo.room;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.amarildo.room.database.Database;
import com.amarildo.room.database.UserDao;
import com.amarildo.room.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Database database = Room.databaseBuilder(
                getApplicationContext(),
                Database.class,
                Database.NOME_DB).build();
        UserDao userDao = database.userDao();

        List<User> userList = generateRandomUserList();

        userDao.insertOneUser(userList.get(0));
    }

    /**
     * Generate a list with random User.
     *
     * @return List with Users.
     */
    public List<User> generateRandomUserList() {
        List<User> userList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            User user = new User(
                    random.nextInt(10000000),
                    "Name" + random.nextInt(10),
                    "Surname" + random.nextInt(10));
            userList.add(user);
        }
        return userList;
    }
}
