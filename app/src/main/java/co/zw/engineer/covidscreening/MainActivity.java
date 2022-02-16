package co.zw.engineer.covidscreening;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import co.zw.engineer.covidscreening.help.ContactsTab;
import co.zw.engineer.covidscreening.information.InformationTabView;

public class MainActivity extends AppCompatActivity {

    private CardView screen, info, help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.scan);
        info = findViewById(R.id.infomation);
        help= findViewById(R.id.help);


        screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent me = new Intent(getApplicationContext(), SrveyStart.class);
                startActivity(me);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent me = new Intent(getApplicationContext(), InformationTabView.class);
                startActivity(me);
            }
        });


        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent me = new Intent(getApplicationContext(), ContactsTab.class);
                startActivity(me);
            }
        });
    }


}