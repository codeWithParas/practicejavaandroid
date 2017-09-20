package test.practicejavaandroid.parcelable;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import test.practicejavaandroid.R;
import test.practicejavaandroid.model.Student;

/**
 * Created by parasmani.sharma on 20/09/2017.
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Student student = getIntent().getParcelableExtra("Student");
        if(student !=null)
        {
            Toast.makeText(SecondActivity.this, student.getName().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
