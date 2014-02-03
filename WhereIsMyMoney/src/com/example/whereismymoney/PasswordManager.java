package com.example.whereismymoney;

import android.content.Context;
import android.content.SharedPreferences;

public class PasswordManager {
    private Context myContext;
    private SharedPreferences passwordPool;
    private SharedPreferences.Editor editor;
    
    public PasswordManager(Context context) {
        myContext = context;
        passwordPool = myContext.getSharedPreferences("passwordPool", 0);
        editor = passwordPool.edit();
        
        // initialize admin entry
        if (!passwordPool.contains("admin")) {
            editor.putString("admin", "pass123");
            editor.commit();
        }
    }
    
    public boolean isLoginValid(String userName, String password) {
        return (passwordPool.contains(userName) && passwordPool.getString(userName, "defValue").equals(password));
    }
    
    public void setPassword(String userName, String newPassword) {
        editor.remove(userName);
        editor.putString(userName, newPassword);
        editor.commit();
    }
}
