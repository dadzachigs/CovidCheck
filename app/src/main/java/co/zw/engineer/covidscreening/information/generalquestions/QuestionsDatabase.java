package co.zw.engineer.covidscreening.information.generalquestions;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Question.class}, version = 1  , exportSchema = false)
public abstract class QuestionsDatabase extends RoomDatabase {

    public static QuestionsDatabase instance;
    public abstract QuestionsDao questionsDao();


    public static synchronized QuestionsDatabase getDatabase(final Context context){
        if (instance==null){

            instance= Room.databaseBuilder(context.getApplicationContext(),
                    QuestionsDatabase.class, "questions2" )
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
            new PopulateDbAsync(instance).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final QuestionsDao questionsDao;


        public PopulateDbAsync(QuestionsDatabase instance) {

            questionsDao = instance.questionsDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            questionsDao.deleteAll();


            Question question = new Question();
            question.setTitle("5G mobile networks DO NOT spread COVID-19");
            question.setContent("Viruses cannot travel on radio waves/mobile networks. COVID-19 is spreading in\n "
            );


            Question question1 = new Question();
            question1.setTitle("Exposing yourself to the sun or to temperatures higher than 25C degrees \n" +
                    "DOES NOT prevent the coronavirus disease (COVID-19)");

            question1.setContent("You can catch COVID-19, no matter how sunny or hot the weather is.\n " +
                    "Countries with hot weather have reported cases of COVID-19. To protect yourself, \n" +
                    "make sure you clean your hands frequently and thoroughly and avoid touching your \n" +
                    "eyes, mouth, and nose. ");

            Question question2 = new Question();
            question2.setTitle("COVID-19 IS NOT transmitted through houseflies");
            question2.setContent("To date, there is no evidence or information to suggest that the COVID-19 virus\n " +
                    "transmitted through houseflies. The virus that cause COVID-19 spreads primarily through droplets\n" +
                    " generated when an infected person coughs, sneezes or speaks. You can also become infected by \n" +
                    "touching a contaminated surface and then touching your eyes, nose or mouth before washing your\n" +
                    " hands. To protect yourself, keep at least 1-metre distance from others and disinfect frequently-touched\n" +
                    " surfaces. Clean your hands thoroughly and often and avoid touching your eyes, mouth and nose.");

            Question question3 = new Question();
            question3.setTitle("Adding pepper to your soup or other meals DOES NOT prevent or cure COVID-19");
            question3.setContent("Hot peppers in your food, though very tasty, cannot prevent or cure COVID-19.\n\n " +
                    "The best way to protect yourself against the new coronavirus is to keep at least 1 metre away \n" +
                    "from others and to wash your hands frequently and thoroughly. It is also beneficial for your\n" +
                    "general health to maintain a balanced diet, stay well hydrated, exercise regularly and sleep well");

            Question question4 = new Question();
            question4.setTitle("There are currently no drugs licensed for the treatment or prevention of COVID-19\n");
            question4.setContent("While several drug trials are ongoing, there is currently no proof that \n" +
                    "hydroxychloroquine or any other drug can cure or prevent COVID-19. The misuse of hydroxychloroquine\n" +
                    " can cause serious side effects and illness and even lead to death. WHO is coordinating efforts\n" +
                    " to develop and evaluate medicines to treat COVID-19");

            Question question5 = new Question();
            question5.setTitle("COVID-19 virus can be transmitted in areas with hot and humid climates");
            question5.setContent("The best way to protect yourself against COVID-19 is by maintaining physical distance of at\n" +
                    " least 1 metre from others and frequently cleaning your hands. By doing this you eliminate viruses that may \n" +
                    "be on your hands and avoid infection that could occur by then touching your eyes, mouth, and nose");

            questionsDao.insert(question);
            questionsDao.insert(question1);
            questionsDao.insert(question2);
            questionsDao.insert(question3);
            questionsDao.insert(question4);
            questionsDao.insert(question5);

            return null;
        }
    }
}
