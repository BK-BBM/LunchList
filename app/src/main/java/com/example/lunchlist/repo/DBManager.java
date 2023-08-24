package com.example.lunchlist.repo;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager {
    private Integer intCounter = 0;

    private static DBManager instance;
    private static SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase mDatabase;


    /* the synchronized keyword isn't a new thing. This method exists in Java programming.
    The whole idea behind making methods synchronized is to "lock" access to whatever we're trying to access
    In this example we use it to "lock" access to the DB instances, this way only one thread/ operation
    can be performed at a time.
    */
    public static synchronized void initializeInstance(SQLiteOpenHelper helper){
        if (instance == null){
            instance = new DBManager();
            sqLiteOpenHelper = helper;
        }
    }

    public static synchronized DBManager getInstance(){
     if (instance == null){
         throw new IllegalStateException(DBManager.class.getSimpleName() +
                 "is not initialized");
     }
        return  instance;
    }

    public synchronized SQLiteDatabase openDatabase(){
      intCounter +=1;
      if(intCounter == 1){
          //we want to open the DB
          mDatabase = sqLiteOpenHelper.getWritableDatabase();
      }
        return mDatabase;
    }

    public synchronized void closeDatabase(){
        intCounter -= 1;
        if(intCounter == 0){
            //we want to close the DB
            mDatabase.close();
        }
    }

}
