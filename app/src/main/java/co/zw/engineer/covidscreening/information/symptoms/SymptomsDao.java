package co.zw.engineer.covidscreening.information.symptoms;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface SymptomsDao {


    @Insert
    void insert(SymptomsQsns symptomsFqa2);

    @Query("DELETE FROM  symptomsFqa2")
    void deleteAll();


    @Query("SELECT * FROM symptomsFqa2" )
    LiveData<List<SymptomsQsns>> getAllQuestions();
}
