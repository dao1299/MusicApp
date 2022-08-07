package com.example.mockproject.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

import com.example.mockproject.model.SongModel;
import com.example.mockproject.model.SongModel;

import java.util.ArrayList;
import java.util.List;

public class SongsUtils {
    private static final String TAG = "SongsUtils";

    public List<SongModel> getSongs(ContentResolver contentResolver){
        List<SongModel> songModelList = new ArrayList<>();
        Cursor cursor = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                new String[]{
                        MediaStore.Audio.Media._ID,
                        MediaStore.Audio.Media.TITLE,
                        MediaStore.Audio.Media.DATA,
                        MediaStore.Audio.Media.ARTIST,
                        MediaStore.Audio.Media.DURATION,
                },null,null,null);
        Log.i(TAG, "getMusic: "+cursor.getCount()+" "+Thread.currentThread().getName());
        while(cursor.moveToNext()){

            SongModel SongModel = new SongModel(
                    Long.parseLong(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );
            Log.i(TAG, "getMusic: "+SongModel);

            songModelList.add(SongModel);

        }
        cursor.close();
        return songModelList;
    }
}