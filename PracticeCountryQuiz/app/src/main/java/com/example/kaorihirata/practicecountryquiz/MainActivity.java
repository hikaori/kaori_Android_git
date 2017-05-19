package com.example.kaorihirata.practicecountryquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button mtrueButton;
    public Button mfalseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtrueButton =(Button)findViewById(R.id.true_button); //(Button)を書くことで〇〇をButton typeに変換。（down cast）
        mtrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            }
        });

        mfalseButton = (Button) findViewById(R.id.false_button);
        mfalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//              Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_LONG).show();
                Toast tost= Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_LONG);
                tost.show();
                tost.setGravity(0,0,0);
            }
        });
    }

}
