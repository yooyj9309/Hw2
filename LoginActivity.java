package com.example.yooyj.hw2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by yooyj on 2016-04-11.
 * This is login activity before user enter and user should input password.
 * This is displayed at first when user clicks this app.
 * And if user inputs password,
 * it changes password to '*' marker and automatically next editext is focused by using TextWatcher.
 */
public class LoginActivity extends Activity {

    EditText edit1, edit2, edit3, edit4;
    String pw1 = "0000";
    String pw="";

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        edit3 = (EditText) findViewById(R.id.edit3);
        edit4 = (EditText) findViewById(R.id.edit4);
        sharedPreference();
        edit1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            /*
            * if editText's length is 1, pass next editText and focus change.
            * And concatenation this editText string to pw.
            * */
            @Override
            public void afterTextChanged(Editable s) {
                if (edit1.length() == 1) {
                    edit2.requestFocus();
                }

                pw += edit1.getText().toString();
            }
        });
        edit2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            /*
        * if editText's length is 1, pass next editText and focus change.
        * And concatenation this editText string to pw.
        * */
            @Override
            public void afterTextChanged(Editable s) {
                if (edit2.length() == 1)
                    edit3.requestFocus();
                pw += edit2.getText().toString();
            }
        });
        edit3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            /*
             * if editText's length is 1, pass next editText and focus change.
             * And concatenation this editText string to pw.
             */
            @Override
            public void afterTextChanged(Editable s) {
                if (edit3.length() == 1) {
                    edit4.requestFocus();
                }
                pw += edit3.getText().toString();

            }
        });
        edit4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            /*
        * Take Shared Preferences file's data.
        * If the file is not null exists Password file, compare password in the file to password that user input.
        * If same, pass next intent or not, give toast message to this activity and clean editText.
        * */
            @Override
            public void afterTextChanged(Editable s) {
                if (edit4.length() == 1) {
                    pw += edit4.getText().toString();

                    if (pw1.equalsIgnoreCase(pw)) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong PassWord~~!", Toast.LENGTH_SHORT).show();
                        pw = "";
                        edit1.setText("");
                        edit2.setText("");
                        edit3.setText("");
                        edit4.setText("");
                        edit1.requestFocus();
                    }
                }
            }
        });

    }
/*
* Initial version password 0000 but if it changes password,
* it apply with changed password .
* */
    public void sharedPreference() {

        sp = getSharedPreferences("Login", MODE_PRIVATE);
        if (sp != null && sp.contains("Password")) {
            pw1=sp.getString("Password","");
        }

    }
}
