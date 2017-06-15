package com.example.kaorihirata.fragment1page2fragment;

//*reference you tube ▼
// https://www.youtube.com/watch?v=KUNsFhcZNAo


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**1.set Button
 * 2.set OnClickListener
 * // create fragment xml / fragment class
 * 3.set 'FragmentManager' / 'fragmentTransaction'
 *   (connect fragment to the main class)
 *
 */

public class MainActivity extends AppCompatActivity {

    Button B1,B2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B1= (Button) findViewById(R.id.b1);
        B2= (Button) findViewById(R.id.b2);

        // CLICK BUTTON FRAGMENT APPEAR
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // INSTANTIATE FRAGMENT
                Fragment1 f1 = new Fragment1();

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ///**** Fragment ver should be same ver as Fragment Class's ver.
                ft.add(R.id.fr1_id,f1);
                ft.addToBackStack("f1");
                ft.commit();
            }
        });

        // CLICK BUTTON FRAGMENT APPEAR
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // INSTANTIATE FRAGMENT
                Fragment2 f2 = new Fragment2();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ///**** Fragment ver should be same ver as Fragment Class's ver.
                ft.add(R.id.fr2_id,f2);
                ft.addToBackStack("f2");
                ft.commit();
            }
        });
    }
}
