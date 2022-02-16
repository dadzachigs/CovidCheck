package co.zw.engineer.covidscreening.information.generalquestions;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface QuestionsDao {
    @Insert
    void insert(Question question2);

    @Query("DELETE FROM  questions2")
    void deleteAll();


    @Query("SELECT * FROM questions2" )
    LiveData<List<Question>> getAllQuestions();

}
