package co.zw.engineer.covidscreening.information.symptoms;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SymptomsRepository {


    private SymptomsDao symptomsDao;
    private LiveData<List<SymptomsQsns>> allQuestions;

    public SymptomsRepository(Application application){

        SymptomsDataBase database = SymptomsDataBase.getDatabase(application);
        symptomsDao = database.questionsDao();
        allQuestions = symptomsDao.getAllQuestions();

    }

    public void insert(SymptomsQsns question){

        new SymptomsRepository.InsertQuestionAsyncTask(symptomsDao).execute(question);


    }

    public  LiveData<List<SymptomsQsns>> getAllQuestions(){

        return allQuestions;
    }
    private static class InsertQuestionAsyncTask extends AsyncTask<SymptomsQsns, Void,Void> {


        private SymptomsDao mQuestionsDao;

        public InsertQuestionAsyncTask(SymptomsDao questionsDao){

            mQuestionsDao=questionsDao;
        }

        @Override
        protected Void doInBackground(SymptomsQsns... params) {

            mQuestionsDao.insert(params[0]);
            return null;
        }
    }

}
