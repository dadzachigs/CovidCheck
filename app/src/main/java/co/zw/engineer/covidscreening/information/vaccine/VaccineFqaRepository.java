package co.zw.engineer.covidscreening.information.vaccine;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class VaccineFqaRepository {


    private VaccineFqaDao vaccineQsnsDao;
    private LiveData<List<VaccineQsns>> allQuestions;

    public VaccineFqaRepository(Application application){

        VaccineDataBase database = VaccineDataBase.getDatabase(application);
        vaccineQsnsDao = database.questionsDao();
        allQuestions = vaccineQsnsDao.getAllQuestions();

    }

    public void insert(VaccineQsns question){

        new VaccineFqaRepository.InsertQuestionAsyncTask(vaccineQsnsDao).execute(question);


    }

    public  LiveData<List<VaccineQsns>> getAllQuestions(){

        return allQuestions;
    }
    private static class InsertQuestionAsyncTask extends AsyncTask<VaccineQsns, Void,Void> {


        private VaccineFqaDao mQuestionsDao;

        public InsertQuestionAsyncTask(VaccineFqaDao questionsDao){

            mQuestionsDao=questionsDao;
        }

        @Override
        protected Void doInBackground(VaccineQsns... params) {

            mQuestionsDao.insert(params[0]);
            return null;
        }
    }
}
