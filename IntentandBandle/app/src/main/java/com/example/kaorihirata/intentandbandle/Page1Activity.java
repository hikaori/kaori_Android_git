package com.example.kaorihirata.intentandbandle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Page1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        // 'final'　because will access from inner class
        final TextView et =(TextView) findViewById(R.id.edit_name_area);
        Button B1 = (Button)findViewById(R.id.b1);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//////////////////  USING 'Intent' VER //////////////////
                //Intent i = new Intent( 'FROM', 'TO')
//                Intent i = new Intent(Page1Activity.this,Page2Activity.class);
//                i.putExtra("ExtraKey",et.getText().toString());
//                startActivity(i);

//////////////////  USING 'Intent' VER //////////////////
                Intent i = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("ExtraKey",et.getText().toString());
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
