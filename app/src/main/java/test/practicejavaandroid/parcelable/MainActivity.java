package test.practicejavaandroid.parcelable;

import android.content.Intent;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import test.practicejavaandroid.R;
import test.practicejavaandroid.model.Student;

public class MainActivity extends AppCompatActivity {

    private Button txt_checkparcelable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * 1)Container for a message (data and object references) that can
        * be sent through an IBinder.  A Parcel can contain both flattened data
        * that will be unflattened on the other side of the IPC
        *
        * 2)Parcel is <strong>not</strong> a general-purpose
        * serialization mechanism.  This class (and the corresponding
        * {@link Parcelable} API for placing arbitrary objects into a Parcel) is
        * designed as a high-performance IPC transport.  As such, it is not
        * appropriate to place any Parcel data in to persistent storage: changes
        * in the underlying implementation of any of the data in the Parcel can
        * render older data unreadable.
        *
        * 3) Usefull : Intent generally pass primitive type objects not custom objects.
        * So in order to satisfy IPC between Activities via intent we can use Parcelable Interface for our object class.
        *
        * 4)In Parcelable, developers write custom code for marshaling and unmarshaling so
        * it creates less garbage objects in comparison to Serialization. The performance of Parcelable
        * over Serialization dramatically improves (around two times faster), because of this custom implementation.
        *
        * 5)Serialization is a marker interface, which implies the user cannot marshal the data according
        * to their requirements. In Serialization, a marshaling operation is performed on a Java Virtual Machine (JVM)
        * using the Java reflection API. This helps identify the Java objects member and behavior, but also ends up
        * creating a lot of garbage objects. Due to this, the Serialization process is slow in comparison to Parcelable.
        *
        *
        * */

        final Student student = new Student("Boy1", 1);

        txt_checkparcelable = (Button) findViewById(R.id.txt_checkparcelable);
        txt_checkparcelable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Student", student);
                startActivity(intent);

            }
        });
    }
}
