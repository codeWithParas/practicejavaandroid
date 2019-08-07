package test.practice.android_handler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import test.practice.R;

/**
 * Created by Parasmani Sharma on 11/20/2017.
 */

public class Handler_Example extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_example);

        findViewById(R.id.handler_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(Handler_Example.this, SendMsg_ThreadToMain.class);
                startActivity(intent);*/
                HandlerTest handlerTest = HandlerTest.create();
            }
        });

        findViewById(R.id.handler_msg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Handler_Example.this, SendMsg_ThreadToMain.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.handler_msg_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Handler_Example.this, SendMsg_ThreadToThread.class);
                startActivity(intent);
            }
        });
    }
}
