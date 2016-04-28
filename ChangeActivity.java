package com.example.yooyj.hw2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by yooyj on 2016-04-13.
 * This is activity that users can change password.
 * Using SharedPreferences class, If you clicks ok button, save changed password in preferences file.
 * If you clicks cancel button, textView is cleaned and gives toast message.
 */
public class ChangeActivity extends Activity {
    EditText pwtext;
    Button ok,cancel;
    SharedPreferences sp;
    SharedPreferences.Editor toEdit;
    String pw="0000";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pwchange);
        getInit();
    }
    /*
    * Setting initial environment
    * */
    public void getInit()
    {
        pwtext=(EditText)findViewById(R.id.pwtext);
        ok=(Button)findViewById(R.id.ok);
        cancel=(Button)findViewById(R.id.cancel);
    }
    /*
    * This method saves the password data in the sharedpreferences file.
    * And finally commit() execute. Because of transaction.
    * */
    public void sharedPreference(){
        sp=getSharedPreferences("Login",MODE_PRIVATE);
        toEdit =sp.edit();
        toEdit.putString("Password",pw);
        toEdit.commit();
    }
    /*
    * If user clicks ok button, execute sharedPreference method and give toast message and finish.
    * */
    public void onOk(View v)
    {
        pw=pwtext.getText().toString();
        sharedPreference();
        Toast.makeText(this,"Change Password~~!"+pw,Toast.LENGTH_SHORT).show();
        finish();
    }
    /*
    * If user clicks cancel button, textView is cleaned and give toast message.
    * */
    public void onCancel(View v)
    {
        pwtext.setText("");
        pw="";
        Toast.makeText(this,"Cancel~~!",Toast.LENGTH_SHORT).show();
    }
}
