package com.javasoul.swframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.javasoul.swframework.component.SWToast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    Button btnError, btnInfo, btnWarning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnError = findViewById(R.id.btn_error);
        btnInfo = findViewById(R.id.btn_info);
        btnWarning = findViewById(R.id.btn_warning);

        /*linearLayout = findViewById(R.id.linearLayout);


        SWEditText swEditText = new SWEditText(this);
        swEditText.setId(123);
        swEditText.setCode("123");
        swEditText.setTitle("TEst");
        swEditText.setError("SWTest");
        swEditText.setDescription("test");

        final SWEditText swEditText2 = new SWEditText(this);
        swEditText2.setId(1234);
        swEditText2.setCode("1234");
        swEditText2.setTitle("TEst2");
        swEditText2.setError("Test2");
        swEditText2.setDescription("test2");

        linearLayout.addView(swEditText.build());
        linearLayout.addView(swEditText2.build());*/

        btnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TEST", new SWTestStorage(null).createTable());
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SWToast.showLongWarning("SWTest akkhfjhkas fhskfh jakhfa ");
            }
        });
    }
}
