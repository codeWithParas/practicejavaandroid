package test.practice.android_lifecycle;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by parasmani.sharma on 07/04/2017.
 */

public class SqliteTest extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "contactsManager";
    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

    String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
            + KEY_PH_NO + " TEXT" + ")";




    public SqliteTest(Context context) {
        super(context, "MY_FIRST_DATABASE", null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d("", "onCreate called");
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d("", "onUpgrade from " + oldVersion + " to " + newVersion);
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }
}
