package com.axa.academy.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private UtilsHelper utilsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calculator calculator = new Calculator();
        utilsHelper = new UtilsHelper();

        tvResult = (TextView) findViewById(R.id.tvResult);

        final EditText etFirst = (EditText) findViewById(R.id.etFirst);
        final EditText etSecond = (EditText) findViewById(R.id.etSecond);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnSubstract = (Button) findViewById(R.id.btnSubstract);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    updateResult(String.valueOf(calculator.add(
                            Integer.parseInt(etFirst.getText().toString()),
                            Integer.parseInt(etSecond.getText().toString()))));
                    closeKeyboard();
                } catch (NumberFormatException ex) {
                    showError(getString(R.string.input_error));
                }
            }
        });

        btnSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    updateResult(String.valueOf(calculator.substract(
                            Integer.parseInt(etFirst.getText().toString()),
                            Integer.parseInt(etSecond.getText().toString()))));
                    closeKeyboard();
                } catch (NumberFormatException ex) {
                    showError(getString(R.string.input_error));
                }
            }
        });

        updateResult("");
    }

    public UtilsHelper getUtilsHelper() {
        return utilsHelper;
    }

    public void setUtilsHelper(UtilsHelper utilsHelper) {
        this.utilsHelper = utilsHelper;
    }

    private void showError(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void closeKeyboard() {
        utilsHelper.closeKeyboard(this);
    }

    private void updateResult(String text) {
        tvResult.setText(String.format(getString(R.string.result), text));
    }

}
