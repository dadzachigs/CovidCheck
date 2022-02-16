package co.zw.engineer.covidscreening.information.vaccine;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class VaccineViewModel extends AndroidViewModel {

    private VaccineFqaRepository questionRepository;

    private LiveData<List<VaccineQsns>> allQuestions;

    public VaccineViewModel(@NonNull Application application) {
        super(application);
        questionRepository = new VaccineFqaRepository(application);
        allQuestions = questionRepository.getAllQuestions();
        //questionRepository = new QuestionRepository(application);
        //allQuestions = questionRepository.getAllQuestions();
    }

    public LiveData<List<VaccineQsns>> getAllQuestions() {
        return allQuestions;
    }

    public void insert(VaccineQsns question){

        questionRepository.insert(question);
    }
}
