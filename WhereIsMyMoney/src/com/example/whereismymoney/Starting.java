package com.example.whereismymoney;

import com.example.myfirstapp.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Starting extends Activity {

	MediaPlayer ourSong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting);
		ourSong =MediaPlayer.create(Starting.this, R.raw.startingsound);
		ourSong.start();
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(4000);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
					Intent openMain = new Intent("com.example.myfirstapp.WELCOME");
					startActivity(openMain);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}

}
