package com.example.yooyj.hw2;

/**
 * Created by yooyj on 2016-04-11.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;

/*
Homework #3
Author : Yoo Young Joon
Date : 2015/03/27
이 프로젝트는 계산기를 구현한 어플리케이션.
사용한 자료구조는 큐이고 두개의 큐를 이용해 연산자를 입력받으면 연산자 큐에 저장 및
숫자용 큐의 사이즈가 2가 되면 연산자스택에 저장되어있는 연산자를 실행.
나누기 0의 Exception의 경우 다시 초기화 될 수 있도록 함.
컨트롤 변수들을 통해 숫자 입력과 연산자 입력을 통제함
* */
public class CalActivity extends AppCompatActivity implements View.OnClickListener {
    EditText display;
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;

    Button add;
    Button cancel;
    Button sub;
    Button divide;
    Button multi;
    Button equal;
    Queue<Float> num = new LinkedList<Float>();
    Queue<String> oper = new LinkedList<String>();
    Boolean control = true, opercontrol = true;
    String value1 = "",tmp="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        display = (EditText) findViewById(R.id.display);

        zero = (Button) findViewById(R.id.zero);
        zero.setOnClickListener(this);

        one = (Button) findViewById(R.id.one);
        one.setOnClickListener(this);

        two = (Button) findViewById(R.id.two);
        two.setOnClickListener(this);

        three = (Button) findViewById(R.id.three);
        three.setOnClickListener(this);

        four = (Button) findViewById(R.id.four);
        four.setOnClickListener(this);

        five = (Button) findViewById(R.id.five);
        five.setOnClickListener(this);

        six = (Button) findViewById(R.id.six);
        six.setOnClickListener(this);

        seven = (Button) findViewById(R.id.seven);
        seven.setOnClickListener(this);

        eight = (Button) findViewById(R.id.eight);
        eight.setOnClickListener(this);

        nine = (Button) findViewById(R.id.nine);
        nine.setOnClickListener(this);

        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(this);

        equal = (Button) findViewById(R.id.equal);
        equal.setOnClickListener(this);

        sub = (Button) findViewById(R.id.sub);
        sub.setOnClickListener(this);

        multi = (Button) findViewById(R.id.multi);
        multi.setOnClickListener(this);

        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(this);

        divide = (Button) findViewById(R.id.divide);
        divide.setOnClickListener(this);

        if(savedInstanceState!=null)
        {
            value1=savedInstanceState.getString(tmp);
        }
    }
    //계산이 될 숫자를 변수에 저장하고 입력창에 변수를 띄워준다.
    public void textCal(String s) {
        value1 = display.getText().toString() + s;
        display.setText(value1);
    }
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putString(value1,tmp);
        super.onSaveInstanceState(savedInstanceState);
    }
    //연산자가 입력되면 연산자 큐에서 연산자를 꺼낸 후 숫자 들을 꺼내서 계산을 실행한다.
//만약 나누기 0일 경우 바로 초기화하고 에러 메시지를 띄운다.
    public void calculator() {
        float tempv;
        switch (oper.poll()) {
            case "+":
                tempv = num.poll() + num.poll();
                num.offer(tempv);
                display.setText("" + num.peek() + "");
                break;
            case "-":
                tempv = num.poll() - num.poll();
                num.offer(tempv);
                display.setText("" + num.peek() + "");
                break;
            case "x":
                tempv = num.poll() * num.poll();
                num.offer(tempv);
                display.setText("" + num.peek() + "");
                break;
            case "/":
                float n1 = num.poll();
                float n2 = num.poll();

                if (n2 == 0) {
                    Toast.makeText(getApplicationContext(), "No divided by zero. Please new input", Toast.LENGTH_SHORT).show();
                    clearCal();
                } else {
                    num.offer(n1 / n2);
                    display.setText("" + num.peek() + "");
                }

                break;
        }
    }
    //만약 입력창에 아무것도 쓰이지 않았을 경우, 연산자의 입력을 막아놓고
//숫자가 두개가 되면 계산기를 돌릴 수 있도록 한다.
    public void realCal(String s) {
        if (!display.getText().toString().equalsIgnoreCase("")) {
            num.add(Float.parseFloat(display.getText().toString()));
            oper.add(s);
            if (num.size() == 2) {
                calculator();
            }
            value1 = "";
            control = false;
        }
    }
    //control변수가  True일 경우 평상시로 입력 될 수 있게 하고
//opercontrol을 true로 바꿔주어 연산자 입력이 가능하게 만들어줌
//false 일 경우 입력창을 지우고 다시 입력받게 해준다.
    public void textNum(String s) {
        opercontrol = true;
        if (control)
            textCal(s);
        else if (!control) {
            display.setText("");
            textCal(s);
            control = true;
        }
    }
    //모든 입력값 및 큐에 있는 자료들을 다 지우주며 초기화 해주는 어플이다
    public void clearCal() {
        value1 = "";
        display.setText("");
        while (!num.isEmpty()) {
            num.poll();
        }
        while (!oper.isEmpty()) {
            oper.poll();
        }
    }
    // 버튼을 누르면 각 버튼에 해당하는 값을 입력 받게해준다.
// =을 누르면 값을 띄워주게 하며 만약 값을 보여주는 칸에 아무것도 없으면 누를 수 없도록 하였다.
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zero:
                textNum("0");
                break;
            case R.id.one:
                textNum("1");
                break;
            case R.id.two:
                textNum("2");
                break;
            case R.id.three:
                textNum("3");
                break;
            case R.id.four:
                textNum("4");
                break;
            case R.id.five:
                textNum("5");
                break;
            case R.id.six:
                textNum("6");
                break;
            case R.id.seven:
                textNum("7");
                break;
            case R.id.eight:
                textNum("8");
                break;
            case R.id.nine:
                textNum("9");
                break;
            case R.id.add:
                if (opercontrol) {
                    realCal("+");
                    opercontrol = false;
                }
                break;
            case R.id.sub:
                if (opercontrol) {
                    realCal("-");
                    opercontrol = false;
                }
                break;
            case R.id.divide:
                if (opercontrol) {
                    realCal("/");
                    opercontrol = false;
                }
                break;
            case R.id.multi:
                if (opercontrol) {
                    realCal("x");
                    opercontrol = false;
                }
                break;
            case R.id.cancel:
                clearCal();
                break;
            case R.id.equal:
                try {
                    if (!display.getText().toString().equalsIgnoreCase("")) {
                        num.add(Float.parseFloat(display.getText().toString()));
                        calculator();
                        String t = num.poll() + "";
                        if (t.equalsIgnoreCase("null"))
                            display.setText("");
                        else
                        {
                            Intent intent = getIntent();
                           intent.putExtra("value",t);
                           setResult(Activity.RESULT_OK,intent);
                            finish();
                        }
                        value1 = "";
                        control = false;
                    }
                } catch (NullPointerException e) {
                    clearCal();
                }
                break;

        }
    }
}