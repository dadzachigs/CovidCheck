package co.zw.engineer.covidscreening.information.generalquestions;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class QuestionRepository {

    private QuestionsDao questionsDao;
    private LiveData<List<Question>> allQuestions;

    public QuestionRepository(Application application){

        QuestionsDatabase database = QuestionsDatabase.getDatabase(application);
        questionsDao = database.questionsDao();
        allQuestions = questionsDao.getAllQuestions();

    }

    public void insert(Question question){

        new InsertQuestionAsyncTask(questionsDao).execute(question);


    }

    public  LiveData<List<Question>> getAllQuestions(){

        return allQuestions;
    }
    private static class InsertQuestionAsyncTask extends AsyncTask<Question, Void,Void> {


        private QuestionsDao mQuestionsDao;

        public InsertQuestionAsyncTask(QuestionsDao questionsDao){

            mQuestionsDao=questionsDao;
        }

        @Override
        protected Void doInBackground(Question... params) {

            mQuestionsDao.insert(params[0]);
            return null;
        }
    }
}
