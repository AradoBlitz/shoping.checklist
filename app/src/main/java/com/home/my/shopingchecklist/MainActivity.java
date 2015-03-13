package com.home.my.shopingchecklist;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URI;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewImageButton = (Button)findViewById(R.id.button);
        viewImageButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                File file = new File("/storage/extSdCard/DCIM/Camera/20131025_173110.jpg");
                intent.setDataAndType(Uri.fromFile(file),"image/*");
                startActivity(intent);
            }
        });

        Button viewHereButton = (Button)findViewById(R.id.button2);
              viewHereButton.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      final File file = new File("/storage/extSdCard/DCIM/Camera/20131025_173110.jpg");
                      ImageView view = (ImageView)findViewById(R.id.imageView);
                      try {
                          view.setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(),Uri.fromFile(file)));
                      } catch (IOException e) {
                        e.printStackTrace();
                        System.err.println(e.getMessage());
                      }
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
