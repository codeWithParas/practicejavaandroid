package test.practice.android_parcelable;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import test.practice.R;
import test.practice.model.Student;

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
