package com.example.luxprotoss.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.nio.ByteBuffer;

import libcore.net.RawSocket;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button01 = (Button)findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //------------------------------------------------------------------
                try {
                    short protocolType=8000;
                    RawSocket rawSocket = new RawSocket("UDP",protocolType);
                    byte[] MAC = new byte[5];
                    for (int i=0 ;i<5;i++){
                        MAC= ByteBuffer.allocate(2).putInt(255).array();
                    }
                    rawSocket.write(MAC,MAC,0,0);
                }catch (Exception e){

                }
                //------------------------------------------------------------------

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
