package co.zw.engineer.covidscreening;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import co.zw.engineer.covidscreening.selfScreen.questionsFragment.SymptomsFragment;

public class SrveyStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srvey_start);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment= fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment ==null){
            fragment = new SymptomsFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();

        }


    }
}