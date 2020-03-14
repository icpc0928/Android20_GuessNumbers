package com.example.leosguessnum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button guess;
    private Button btn1 ,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnBack,btnClear;
    private TextView log, num1 ,num2 ,num3 ,num4 ;
    //宣告答案為字串是answer
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guess = findViewById(R.id.guess);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        log = findViewById(R.id.log);

        //按鈕配置
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btnBack = findViewById(R.id.btnBack);
        btnClear = findViewById(R.id.btnClear);

        //TODO 這裡要把其他0-9碼數字交給btnListener去做
        btn1.setOnClickListener(btnListener);

        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess();
            }
        });

        initNewGame();
    }

    //onCreate內的 OnClickListener中做出的匿名實作物件去做以下事情
    private void guess(){
        String strN1 = num1.getText().toString();
        String strN2 = num2.getText().toString();
        String strN3 = num3.getText().toString();
        String strN4 = num4.getText().toString();
        String strInput = strN1+strN2+strN3+strN4;
        String result = checkAB(strInput);


        log.append(strInput + "  =>  " + result +"\n");
        num1.setText("");
        num2.setText("");
        num3.setText("");
        num4.setText("");
    }



    //開始新局
    private void initNewGame(){
        //答案讓createAnswer來創造
        answer = createAnswer(4);
        //先清除四個圈圈內的數字跟log內的文字
        num1.setText("");
        num2.setText("");
        num3.setText("");
        num4.setText("");
        log.setText("");

    }
    //這裡是創造答案的方法
    private String createAnswer(int d){
        int[] poker = new int[10];
        for (int i=0; i<poker.length; i++)poker[i]=i;

        for (int i = poker.length-1; i>0; i--) {
            int rand = (int)(Math.random()*(i+1));
            int temp = poker[rand];
            poker[rand] = poker[i];
            poker[i] = temp;
        }

        StringBuffer sb = new StringBuffer();
        for (int i=0; i<d; i++) {
            sb.append(poker[i]);
        }

        return sb.toString();
    }

    //檢查方法
    private String checkAB(String g){
        int A, B; A = B = 0;
        for (int i=0; i<answer.length(); i++) {
            if (answer.charAt(i) == g.charAt(i)) {
                A++;
            }else if(answer.indexOf(g.charAt(i)) != -1) {
                B++;
            }
        }
        return A + "A" + B + "B";

    }


    public void btn1(View view) {
        num1 = findViewById(R.id.num1);
    }


    private Button.OnClickListener btnListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {

        }
    };

}
