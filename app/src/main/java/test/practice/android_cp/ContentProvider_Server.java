package test.practice.android_cp;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import test.practice.R;


/**
 * Created by parasmani.sharma on 03/10/2017.
 */

public class ContentProvider_Server extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cp_add_data);
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/

    public void onClickAddName(View view) {
        ContentValues values = new ContentValues();
        values.put(MyContentProvider.name, ((EditText) findViewById(R.id.txtName)).getText().toString());
        Uri uri = getContentResolver().insert(MyContentProvider.CONTENT_URI, values);
        Toast.makeText(getBaseContext(), "New record inserted", Toast.LENGTH_LONG)
                .show();
    }
}
