package me.tangning.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by tang on 1/9/15.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String CREATE_BOOK = "CREATE TABLE books ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "author TEXT,"
            + "price REAL,"
            + "pages INTEGER,"
            + "name TEXT)";

    private static final String CREATE_CATEGORY = "CREATE TABLE categories ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT,"
            + "code INTEGER)";

    private Context mContext;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext, "Table book created.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                db.execSQL(CREATE_CATEGORY);
            default:
        }
    }
}
