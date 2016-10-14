package com.axa.academy.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvTitle = (TextView) findViewById(R.id.tvTitle);

        final EditText etName = (EditText) findViewById(R.id.etName);

        Button btnclick = (Button) findViewById(R.id.btnClick);

        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTitle.setText(String.format(getString(R.string.hello_name),
                        etName.getText().toString()));
            }
        });

    }

}
