package co.zw.engineer.covidscreening.information.vaccine;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface VaccineFqaDao {



    @Insert
    void insert(VaccineQsns vaccineFqa2);

    @Query("DELETE FROM  vaccineFqa2")
    void deleteAll();


    @Query("SELECT * FROM vaccineFqa2" )
    LiveData<List<VaccineQsns>> getAllQuestions();
}
