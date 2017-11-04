package test.practice.android_sqlite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import test.practice.R;

/**
 * Created by parasmani.sharma on 12/10/2017.
 */

public class Sqlite_Example extends AppCompatActivity {

    /*
    * refer : https://thebhwgroup.com/blog/how-android-sqlite-onupgrade
    * */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_activity);

        MySQLiteHelper db = new MySQLiteHelper(this);

        /**
         * CRUD Operations
         * */
        // add Books
        db.addBook(new Book("Android Application Development Cookbook", "Wei Meng Lee"));
        db.addBook(new Book("Android Programming: The Big Nerd Ranch Guide", "Bill Phillips and Brian Hardy"));
        db.addBook(new Book("Learn Android App Development", "Wallace Jackson"));

        // get all books
        List<Book> list = db.getAllBooks();

        // delete one book
        db.deleteBook(list.get(0));

        // get all books
        db.getAllBooks();

    }
}
