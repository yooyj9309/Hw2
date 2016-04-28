package com.example.yooyj.hw2;

/**
 * Created by yooyj on 2016-04-11.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/*
Homework #2
Author : Yoo Young Joon
Date : 2015/03/27
This project is Tip Calculator. If you text number and click radio button, The result was shown to ToastMessage.
음수값과 기타 문자 출력에 대한 Exception 같은 경우 xml에서 inputType을 NumberDecimal로 설정
이 경우들이 입력이 되지 않게함
* */
public class TipActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton Fif;
    RadioButton Twen;
    RadioButton Other;
    EditText edit;
    EditText editText;
    String str;
    String tmp;
    //Declare variable and find view by id
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tipcalcultor);
        if(savedInstanceState!=null)
        {
            str=savedInstanceState.getString(tmp);

        }
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        Fif=(RadioButton)findViewById(R.id.fi);
        Twen=(RadioButton)findViewById(R.id.twen);
        Other=(RadioButton)findViewById(R.id.other);
        edit=(EditText)findViewById(R.id.edit);
        editText=(EditText)findViewById(R.id.editText);

    }
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putString(tmp,str);
        super.onSaveInstanceState(savedInstanceState);
    }
    //Although The activity is onDestroy() state, the important data is saved.
    public void onPause()
    {
        super.onPause();
        str=edit.getText().toString();
    }
    public void onResume()
    {
        super.onResume();
        edit.setText(str);
    }
    //주요 계산되고 입력창에 값을 띄우주는 메소드
    //각 라디오버튼의 체크를 확인후 그에 맞는 계산을 수행하게 함
    //만약 others 버튼을 누른다면 없었던 editText칸이 생기고 그 후에 계산값을 받도록함
    public void displayValue(View v)
    {
        str=edit.getText().toString();
        if(str.equalsIgnoreCase(""))
        {
            Toast.makeText(getApplicationContext(), "Please input your amount!", Toast.LENGTH_SHORT).show();
        }
        else {
            float num = Float.parseFloat(str);

            float tip, total;
            if (Fif.isChecked()) {

                tip = num * 15 / 100;
                total = tip + num;
                String tmp = "The tip : " + tip + " The Total : " + total;
                Toast.makeText(getApplicationContext(), tmp, Toast.LENGTH_SHORT).show();
            } else if (Twen.isChecked()) {
                tip = num * 20 / 100;
                total = tip + num;
                String tmp = "The tip : " + tip + " The Total : " + total;
                Toast.makeText(getApplicationContext(), tmp, Toast.LENGTH_SHORT).show();
            } else if (Other.isChecked()) {
                String val1 = editText.getText().toString();
                if(val1.equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(), "Please input your amount!", Toast.LENGTH_SHORT).show();
                }
                else {
                    float d = Float.parseFloat(val1);
                    tip = num * d / 100;
                    total = tip + num;
                    String tmp = "The tip : " + tip + " The Total : " + total;
                    Toast.makeText(getApplicationContext(), tmp, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    //other버튼을 누르면 그 EditText가 보이도록 함
    public void onRadio(View v)
    {
        editText.setVisibility(View.VISIBLE);
        editText.requestFocus();
    }
    //다른 버튼을 누를 경우 other 옆 EditText가 안보여지게함
    public void onRadio1(View v)
    {
        editText.setVisibility(View.INVISIBLE);
        editText.setText("");
    }
    public void onRadio2(View v)
    {
        editText.setVisibility(View.INVISIBLE);
        editText.setText("");
    }
}
