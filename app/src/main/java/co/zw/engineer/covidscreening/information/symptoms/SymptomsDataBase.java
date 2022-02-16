package co.zw.engineer.covidscreening.information.symptoms;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {SymptomsQsns.class}, version = 1 , exportSchema = false)

public abstract  class SymptomsDataBase extends RoomDatabase {
    public static SymptomsDataBase instance;
    public abstract SymptomsDao questionsDao();

    public static synchronized SymptomsDataBase getDatabase(final Context context){
        if (instance==null){

            instance= Room.databaseBuilder(context.getApplicationContext(),
                    SymptomsDataBase.class, "symptomsFqa2" )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();

        }

        return instance;
    }
    private static  RoomDatabase.Callback roomCallback = new RoomDatabase.Callback () {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new SymptomsDataBase.PopulateDbAsync(instance).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final SymptomsDao questionsDao;


        public PopulateDbAsync(SymptomsDataBase instance) {

            questionsDao = instance.questionsDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            questionsDao.deleteAll();


            SymptomsQsns question = new SymptomsQsns();
            question.setTitle("What are the COVID-19 Symptoms");
            question.setContent("COVID-19 affects different people in different ways. Most infected people will develop mild to moderate illness and recover without hospitalization.\n" +
                    "\n" +
                    "Most common symptoms:\n" +
                    "\n" +
                    "    fever.\n" +
                    "    dry cough.\n" +
                    "    tiredness.\n" +
                    "\n" +
                    "Less common symptoms:\n" +
                    "\n" +
                    "    aches and pains.\n" +
                    "    sore throat.\n" +
                    "    diarrhoea.\n" +
                    "    conjunctivitis.\n" +
                    "    headache.\n" +
                    "    loss of taste or smell.\n" +
                    "    a rash on skin, or discolouration of fingers or toes.\n" +
                    "\n" +
                    "Serious symptoms:\n" +
                    "\n" +
                    "    difficulty breathing or shortness of breath.\n" +
                    "    chest pain or pressure.\n" +
                    "    loss of speech or movement.\n" +
                    "\n" +
                    "Seek immediate medical attention if you have serious symptoms.  Always call before visiting your doctor or health facility. \n" +
                    "\n" +
                    "People with mild symptoms who are otherwise healthy should manage their symptoms at home. \n" +
                    "\n" +
                    "On average it takes 5–6 days from when someone is infected with the virus for symptoms to show, however it can take up to 14 days. ");


            questionsDao.insert(question);


            return null;
        }
    }
}
