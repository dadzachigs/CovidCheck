package co.zw.engineer.covidscreening.selfScreen.questionsFragment;

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


public class SymptomsFragment extends Fragment implements View.OnClickListener {

    CheckBox q1,q2,q3,q4,q5,q6,q12;
    int counter =0;

    public SymptomsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_symptoms, container, false);
        Button next = view.findViewById(R.id.next1);

        q1 = view.findViewById(R.id.qsn01);
        q2 = view.findViewById(R.id.qsn02);
        q3 = view.findViewById(R.id.qsn03);
        q4 = view.findViewById(R.id.qsn04);
        q5 = view.findViewById(R.id.qsn05);
        q6 = view.findViewById(R.id.qsn06);
        q12 = view.findViewById(R.id.qsn12);


        q1.setOnClickListener(this);
        q2.setOnClickListener(this);
        q3.setOnClickListener(this);
        q4.setOnClickListener(this);
        q5.setOnClickListener(this);
        q6.setOnClickListener(this);
        q12.setOnClickListener(this);

        next.setOnClickListener(v -> {


            ExposureFragment ex =new ExposureFragment();

            FragmentTransaction fr = getParentFragmentManager().beginTransaction();
            fr.replace(R.id.fragment_container,ex);
            fr.commit();
            GlobalValues.SYMPTOMS_FRAG =counter;
        });

        return view;
    }


    @Override
    public void onClick(View v) {

        addPoints();
        deductPoints();

    }
    private void uncheckOthers() {
        q1.setChecked(false);
        q2.setChecked(false);
        q3.setChecked(false);
        q4.setChecked(false);
        q5.setChecked(false);
        q6.setChecked(false);
    }
    private void checkAnswer(CheckBox questionCheckbox) {
        String questionValue = questionCheckbox.getText().toString();
        Boolean answer = questionCheckbox.isChecked();
        Question question = new Question();
        question.setQuestion(questionValue);
        question.setAnswer(answer);
        GlobalValues.symptomsFragmentQuestions.add(question);
    }

    private void addPoints(){


        int qn1 = 0, qn2 = 0 ,qn3 = 0 ,qn4 = 0,qn5 = 0,qn6 =0;
        if (q1.isChecked()){ qn1= 1;uncheckOther();}
        checkAnswer(q1);
        if(q2.isChecked()){ qn2=1; uncheckOther();}
        checkAnswer(q2);
        if (q3.isChecked()){qn3=1; uncheckOther();}
        checkAnswer(q3);
        if (q4.isChecked()){qn4=1; uncheckOther();}
        checkAnswer(q4);
        if (q5.isChecked()){qn5=6; uncheckOther();}
        checkAnswer(q5);
        if (q6.isChecked()){qn6=1; uncheckOther();}
        checkAnswer(q6);
        int total = qn1+ qn2 + qn3 + qn4 +qn5+qn6;

        counter=total;
    }

    private void deductPoints(){
        int qn12;
        if(q12.isChecked()) {
            qn12=0;
            checkAnswer(q12);
            checkOthers();


            int total =qn12;
            counter = total;
        }

    }
    private void checkOthers() {
        q1.setChecked(false);
        q2.setChecked(false);
        q3.setChecked(false);
        q4.setChecked(false);
        q5.setChecked(false);
        q6.setChecked(false);
        q6.setChecked(false);
    }

    private void uncheckOther() {
        q12.setChecked(false);
    }
}