package co.zw.engineer.covidscreening.selfScreen.questionsFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import co.zw.engineer.covidscreening.R;
import co.zw.engineer.covidscreening.Results.ResultDanger;
import co.zw.engineer.covidscreening.Results.ResultExposed;
import co.zw.engineer.covidscreening.Results.ResultNotClear;
import co.zw.engineer.covidscreening.Results.ResultYes;
import co.zw.engineer.covidscreening.model.GlobalValues;
import co.zw.engineer.covidscreening.model.Question;
import co.zw.engineer.covidscreening.model.TestResults;


public class TravelFragment extends Fragment implements View.OnClickListener {
    CheckBox q13,q14,q12;
    int counter =0;
    private TestResults mTestResult = TestResults.NEGATIVE;


    public TravelFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_travel, container, false);
        Button next = view.findViewById(R.id.finish);
        q13 = view.findViewById(R.id.qsn13);
        q14 = view.findViewById(R.id.qsn14);
        q12 = view.findViewById(R.id.qsn12);

        q13.setOnClickListener(this);
        q14.setOnClickListener(this);
        q12.setOnClickListener(this);

        next.setOnClickListener(v -> {

            decision();
        });

        Button back = view.findViewById(R.id.back3);
        back.setOnClickListener(v -> {
            ExposureFragment ex =new ExposureFragment();

            FragmentTransaction fr = getParentFragmentManager().beginTransaction();
            fr.replace(R.id.fragment_container,ex);
            fr.commit();
            uncheckOthers();
        });

        return view;
    }

    private void decision() {
        GlobalValues.TRAVEL_FRAG=counter;

        if (((GlobalValues.SYMPTOMS_FRAG==5)||(GlobalValues.SYMPTOMS_FRAG==7)||(GlobalValues.SYMPTOMS_FRAG==8)||(GlobalValues.SYMPTOMS_FRAG==9)||(GlobalValues.SYMPTOMS_FRAG==10)||(GlobalValues.SYMPTOMS_FRAG==11))
                &&((GlobalValues.EXPOSURE_FRAG==0)||(GlobalValues.EXPOSURE_FRAG==1)||(GlobalValues.EXPOSURE_FRAG==2))
                &&((GlobalValues.TRAVEL_FRAG==0)||(GlobalValues.TRAVEL_FRAG==1)||(GlobalValues.TRAVEL_FRAG==2)||(GlobalValues.TRAVEL_FRAG==3))) {
            mTestResult=TestResults.POSITIVE;
            resultPositive();

        }
        //Log.d("TAG", currentScore+"");
        if (((GlobalValues.SYMPTOMS_FRAG==6)||(GlobalValues.SYMPTOMS_FRAG==2)||(GlobalValues.SYMPTOMS_FRAG==4)||(GlobalValues.SYMPTOMS_FRAG==3))
                &&((GlobalValues.EXPOSURE_FRAG==0)||(GlobalValues.EXPOSURE_FRAG==1)||(GlobalValues.EXPOSURE_FRAG==2))
                &&((GlobalValues.TRAVEL_FRAG==0)||(GlobalValues.TRAVEL_FRAG==1)||(GlobalValues.TRAVEL_FRAG==2)||(GlobalValues.TRAVEL_FRAG==3)))  {
            mTestResult=TestResults.UNCLEAR;
            resultNotClear();
        }

        if (((GlobalValues.SYMPTOMS_FRAG==0)||(GlobalValues.SYMPTOMS_FRAG==1))
                &&((GlobalValues.EXPOSURE_FRAG==1)||(GlobalValues.EXPOSURE_FRAG==2)||(GlobalValues.EXPOSURE_FRAG==3))
                &&((GlobalValues.TRAVEL_FRAG==1)||(GlobalValues.TRAVEL_FRAG==2)))  {
            mTestResult=TestResults.EXPOSED;
            resultExposed();

        }
        if (((GlobalValues.SYMPTOMS_FRAG==0)||(GlobalValues.SYMPTOMS_FRAG==1))
                &&((GlobalValues.EXPOSURE_FRAG==1)||(GlobalValues.EXPOSURE_FRAG==2))
                &&((GlobalValues.TRAVEL_FRAG==0)||(GlobalValues.TRAVEL_FRAG==1)||(GlobalValues.TRAVEL_FRAG==2)||(GlobalValues.TRAVEL_FRAG==3)))  {
            mTestResult=TestResults.EXPOSED;
            resultExposed();

        }
        if (((GlobalValues.SYMPTOMS_FRAG==0)||(GlobalValues.SYMPTOMS_FRAG==1)) &&(GlobalValues.EXPOSURE_FRAG==0) &&(GlobalValues.TRAVEL_FRAG==0))  {
            mTestResult=TestResults.NEGATIVE;
            resultNegative();

        }
    }
    private void resultNotClear() {
        startActivity(new Intent(getContext(), ResultNotClear.class));
    }

    private void resultExposed() {
        startActivity(new Intent(getContext(), ResultExposed.class));
    }
    private void resultNegative() {
        startActivity(new Intent(getContext(), ResultYes.class));
    }
    private void resultPositive() {
        startActivity(new Intent(getContext(), ResultDanger.class));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }


    private void checkAnswer(CheckBox questionCheckbox) {
        String questionValue = questionCheckbox.getText().toString();
        Boolean answer = questionCheckbox.isChecked();
        Question question = new Question();
        question.setQuestion(questionValue);
        question.setAnswer(answer);
        GlobalValues.travelFragmentQuestions.add(question);
    }
    @Override
    public void onClick(View v) {

        addPoints();
        deductPoints();

    }
    private void uncheckOthers() {
        q13.setChecked(false);
        q14.setChecked(false);

    }
    private void addPoints(){


        int qn1 = 0, qn2 = 0 ;
        if (q13.isChecked()){ qn1= 1;uncheckOther();}
        checkAnswer(q13);
        if(q14.isChecked()){ qn2=1; uncheckOther();}
        checkAnswer(q14);

        int total = qn1+ qn2;

        counter=total;
    }
    private void checkOther() {
        q13.setChecked(false);
        q14.setChecked(false);

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

    /*private void sendData() {

        DateTimeFormatter dt = null;


        //Prefs.putString(GlobalValues.USER_EMAIL_KEY, date);


        SessionManagement sessionManagement = new SessionManagement(getActivity());
        int userID = sessionManagement.getSharedPreferences().getInt(GlobalValues.RETURNED_USER_ID,0);
        PcrResults pcrResults =  ApiClient.getClient().create(PcrResults.class);

        SelfScreen selfScreen = ApiClient.getClient().create(SelfScreen.class);
        dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Question> questionList = new ArrayList<>();
        LocalDateTime dateTime = LocalDateTime.now();
        SelfScreenDao selfScreenDao = new SelfScreenDao();

        questionList.addAll(GlobalValues.symptomsFragmentQuestions);
        questionList.addAll(GlobalValues.exposureFragmentQuestions);
        questionList.addAll(GlobalValues.travelFragmentQuestions);
        selfScreenDao.setQuestions(questionList);
        //check is logged in use userid else use 0  selfScreenDao.setUserId(0L);
        selfScreenDao.setUserId(Long.valueOf(userID));

        selfScreenDao.setTestResult(mTestResult);
        selfScreenDao.setTestDate(dt.format(LocalDateTime.now()));
        selfScreenDao.setExpiryDate(dt.format(dateTime.plusDays(3)));
        GlobalValues.selfScreenDao = selfScreenDao;
    }*/

}