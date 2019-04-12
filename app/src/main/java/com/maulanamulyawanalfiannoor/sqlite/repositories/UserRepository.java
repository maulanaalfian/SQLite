package com.maulanamulyawanalfiannoor.sqlite.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.maulanamulyawanalfiannoor.sqlite.dao.UserDao;
import com.maulanamulyawanalfiannoor.sqlite.db.AppDatabase;
import com.maulanamulyawanalfiannoor.sqlite.models.User;

public class UserRepository {
    private UserDao dao;

    public UserRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        dao = db.userDao();
    }

    public LiveData<User> getUserByUsername(String username) {
        return dao.getUserByUsername(username);
    }

    public void insert(User user) {
        new InsertAsyncTask(dao).execute(user);
    }

    private static class InsertAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao asyncTaskDao;
        InsertAsyncTask(UserDao dao) {
            asyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(User... users) {
            asyncTaskDao.insert(users);
            return null;
        }
    }
}