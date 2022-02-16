package co.zw.engineer.covidscreening.selfScreen.questionsFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import co.zw.engineer.covidscreening.R;
import co.zw.engineer.covidscreening.model.GlobalValues;
import co.zw.engineer.covidscreening.model.Question;


public class ExposureFragment extends Fragment implements View.OnClickListener{

    CheckBox q9,q10,q11,q12;
    int counter =0;

    public ExposureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_exposure, container, false);
        Button next = view.findViewById(R.id.next2);

        q9 = view.findViewById(R.id.qsn09);
        q10 = view.findViewById(R.id.qsn10);
        q11 = view.findViewById(R.id.qsn11);
        q12 = view.findViewById(R.id.qsn12);

        q9.setOnClickListener(this);
        q10.setOnClickListener(this);
        q11.setOnClickListener(this);
        q12.setOnClickListener(this);

        next.setOnClickListener(v -> {



            TravelFragment ex =new TravelFragment();

            FragmentTransaction fr = getParentFragmentManager().beginTransaction();
            fr.replace(R.id.fragment_container,ex);
            fr.commit();
            GlobalValues.EXPOSURE_FRAG =counter;

        });

        Button back = view.findViewById(R.id.back1);
        back.setOnClickListener(v -> {
            SymptomsFragment ex =new SymptomsFragment();
            uncheckOther();
            FragmentTransaction fr = getParentFragmentManager().beginTransaction();
            fr.replace(R.id.fragment_container,ex);
            fr.commit();
        });

        return view;
    }



    public void updateCounter (int newValue){

        counter = newValue;
    }

    private void checkAnswer(CheckBox questionCheckbox) {
        String questionValue = questionCheckbox.getText().toString();
        Boolean answer = questionCheckbox.isChecked();
        Question question = new Question();
        question.setQuestion(questionValue);
        question.setAnswer(answer);
        GlobalValues.exposureFragmentQuestions.add(question);
    }


    @Override
    public void onClick(View v) {

        addPoints();
        deductPoints();

    }


    private void addPoints(){


        int qn1 = 0, qn2 = 0 ,qn3 = 0;
        if (q9.isChecked()){ qn1= 1;uncheckOther();}
        checkAnswer(q9);
        if(q10.isChecked()){ qn2=1; uncheckOther();}
        checkAnswer(q10);
        if (q11.isChecked()){qn3=1; uncheckOther();}
        checkAnswer(q11);
        int total = qn1+ qn2 + qn3;

        counter=total;
    }
    private void checkOther() {
        q9.setChecked(false);
        q10.setChecked(false);
        q11.setChecked(false);
    }
    private void deductPoints() {
        int qn12;
        if (q12.isChecked()) {
            qn12 = 0;
            checkAnswer(q12);
            checkOther();


            int total = qn12;
            counter = total;
        }

    }
    private void uncheckOther () {
        q12.setChecked(false);
    }
    public void onBackPressed() {
        Intent intent = new Intent(getContext(), SymptomsFragment.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}