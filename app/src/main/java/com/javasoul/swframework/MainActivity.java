package com.javasoul.swframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.javasoul.swframework.component.SWEditText;
import com.javasoul.swframework.component.SWToast;

public class MainActivity extends AppCompatActivity {

    private SWEditText swEditText;
    private Spinner cmbOption;
    private Button btnChange;

    private String[] options = new String[]{"Title","Placeholder","Description","Warning","Error"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swEditText = findViewById(R.id.txt_custom);
        cmbOption = findViewById(R.id.cmb_option);
        btnChange = findViewById(R.id.btn_change);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options);
        cmbOption.setAdapter(adapter);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String option = cmbOption.getSelectedItem().toString();
                String value = swEditText.getValue();

                if(option.equals("Title")) {
                    swEditText.setTitle(value);
                } else if(option.equals("Placeholder")) {
                    swEditText.setPlaceholder(value);
                } else if(option.equals("Description")) {
                    swEditText.setDescription(value);
                } else if(option.equals("Warning")) {
                    swEditText.setWarning(value);
                } else if(option.equals("Error")) {
                    swEditText.setError(value);
                }
            }
        });
    }
}
