package com.example.whereismymoney;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

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
    
    public boolean login(String username, String password){
		Document doc = null;
		try {
			doc = Jsoup.connect("http://192.185.4.36/~zli342/login.php").data("username", username).data("password", password).timeout(15*1000).get();
			String loginResult = (doc.text());
			if (loginResult.equals("Found")) {
				return true;
		}
		} 
		catch (IOException e) {
		Log.i("fail",e.toString());
		}
		return false;
		}
    
    public void setPassword(String userName, String newPassword) {
        editor.remove(userName);
        editor.putString(userName, newPassword);
        editor.commit();
    }
}
