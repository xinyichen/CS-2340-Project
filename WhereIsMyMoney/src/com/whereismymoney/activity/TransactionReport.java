package com.whereismymoney.activity;
 
import com.whereismymoney.R;
import com.whereismymoney.activity.opengl.GLSurf;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
 
public class TransactionReport extends Activity {
 
    // Our OpenGL Surfaceview
    private GLSurfaceView glSurfaceView;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
 
        // Super
        super.onCreate(savedInstanceState);
 
        // We create our Surfaceview for our OpenGL here.
        glSurfaceView = new GLSurf(this);
 
        // Set our view.
        setContentView(R.layout.activity_transaction_report);
 
        // Retrieve our Relative layout from our main layout we just set to our view.
        LinearLayout layout = (LinearLayout) findViewById(R.id.linear_layout_transaction_report_main);
 
        // Attach our surfaceview to our relative layout from our main layout.
        RelativeLayout.LayoutParams glParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layout.addView(glSurfaceView, glParams);
    }
 
    @Override
    protected void onPause() {
        super.onPause();
        glSurfaceView.onPause();
    }
 
    @Override
    protected void onResume() {
        super.onResume();
        glSurfaceView.onResume();
    }
 
}