package co.zw.engineer.covidscreening.information.symptoms;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class SymptomsViewlModel extends AndroidViewModel {

    private SymptomsRepository questionRepository;

    private LiveData<List<SymptomsQsns>> allQuestions;

    public SymptomsViewlModel(@NonNull Application application) {
        super(application);
        questionRepository = new SymptomsRepository(application);
        allQuestions = questionRepository.getAllQuestions();
        //questionRepository = new QuestionRepository(application);
        //allQuestions = questionRepository.getAllQuestions();
    }

    public LiveData<List<SymptomsQsns>> getAllQuestions() {
        return allQuestions;
    }

    public void insert(SymptomsQsns question){

        questionRepository.insert(question);
    }

}
