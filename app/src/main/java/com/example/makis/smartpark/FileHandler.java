package com.example.makis.smartpark;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by makis on 7/5/2017.
 */

public class FileHandler extends AppCompatActivity {
    public void saveFile(String File, String Content, View view) {
        java.io.File path= view.getContext().getFilesDir();
        File file=new File(path,File);
        FileOutputStream stream= null;

        try {
            stream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try{
            stream.write(Content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String readFile(String File, File view)
    {
        String token = "";

        File path = view;
        File file=new File(path,File);

        int length = (int) file.length();
        byte[] bytes = new byte[length];

        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            in.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        token = new String(bytes);


        return token;
    }
}
