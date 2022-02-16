package co.zw.engineer.covidscreening.information.generalquestions;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class QuestionsViewModel extends AndroidViewModel {
    private QuestionRepository questionRepository;

    private LiveData<List<Question>> allQuestions;

    public QuestionsViewModel(@NonNull Application application) {
        super(application);
        questionRepository = new QuestionRepository(application);
        allQuestions = questionRepository.getAllQuestions();
        //questionRepository = new QuestionRepository(application);
        //allQuestions = questionRepository.getAllQuestions();
    }

    public LiveData<List<Question>> getAllQuestions() {
        return allQuestions;
    }

    public void insert(Question question){

        questionRepository.insert(question);
    }
}
