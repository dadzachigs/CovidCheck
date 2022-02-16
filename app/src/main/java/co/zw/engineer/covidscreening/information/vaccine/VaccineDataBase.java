package co.zw.engineer.covidscreening.information.vaccine;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {VaccineQsns.class}, version = 1, exportSchema = false)
public abstract class VaccineDataBase extends RoomDatabase {

    public static VaccineDataBase instance;
    public abstract VaccineFqaDao questionsDao();


    public static synchronized VaccineDataBase getDatabase(final Context context){
        if (instance ==null){

            instance= Room.databaseBuilder(context.getApplicationContext(),
                    VaccineDataBase.class, "vaccineFqa2" )
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
            new VaccineDataBase.PopulateDbAsync(instance).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final VaccineFqaDao questionsDao;


        public PopulateDbAsync(VaccineDataBase instance) {

            questionsDao = instance.questionsDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            questionsDao.deleteAll();


            VaccineQsns question = new VaccineQsns();
            question.setTitle("What is vaccination?");
            question.setContent("" +
                    "\n" +
                    "Vaccination is a simple, safe, and effective way of protecting people against harmful diseases, before they come into contact with them. It uses your body’s natural defenses to build resistance to specific infections and makes your immune system stronger.\n" +
                    "\n" +
                    "Vaccines train your immune system to create antibodies, just as it does when it’s exposed to a disease. However, because vaccines contain only killed or weakened forms of germs like viruses or bacteria, they do not cause the disease or put you at risk of its complications.\n" +
                    "\n" +
                    "Most vaccines are given by an injection, but some are given orally (by mouth) or sprayed into the nose.\n "
            );


            VaccineQsns question1 = new VaccineQsns();
            question1.setTitle("Why is vaccination important?");

            question1.setContent(

                    "Vaccination is a safe and effective way to prevent disease and save lives – now more than ever. Today there are vaccines available to protect against at least 20 diseases, such as diphtheria, tetanus, pertussis, influenza and measles. Together, these vaccines save the lives of up to 3 million people every year.\n" +
                            "\n" +
                            "When we get vaccinated, we aren’t just protecting ourselves, but also those around us. Some people, like those who are seriously ill, are advised not to get certain vaccines – so they depend on the rest of us to get vaccinated and help reduce the spread of disease. \n" +
                            "\n" +
                            "During the COVID-19 pandemic, vaccination continues to be critically important. The pandemic has caused a decline in the number of children receiving routine immunizations, which could lead to an increase in illness and death from preventable diseases. WHO has urged countries to ensure that essential immunization and health services continue, despite the challenges posed by COVID-19.More information about the importance of vaccines is available here. \n" +
                            "make sure you clean your hands frequently and thoroughly and avoid touching your \n" +
                            "eyes, mouth, and nose. ");

            VaccineQsns question2 = new VaccineQsns();
            question2.setTitle("How does a vaccine work?");
            question2.setContent("Vaccines reduce risks of getting a disease by working with your body’s natural defenses to build protection. When you get a vaccine, your immune system responds.\n" +
                    "\n" +
                    "    it Recognizes the invading germ, such as the virus or bacteria.\n" +
                    "\n" +
                    "    Produces antibodies. Antibodies are proteins produced naturally by the immune system to fight disease.\n" +
                    "\n" +
                    "    Remembers the disease and how to fight it. If you are then exposed to the germ in the future, your immune system can quickly destroy it before you become unwell.\n" +
                    "\n" +
                    "The vaccine is therefore a safe and clever way to produce an immune response in the body, without causing illness.\n" +
                    "\n" +
                    "Our immune systems are designed to remember. Once exposed to one or more doses of a vaccine, we typically remain protected against a disease for years, decades or even a lifetime. This is what makes vaccines so effective. Rather than treating a disease after it occurs, vaccines prevent us in the first instance from getting sick.");

            VaccineQsns question3 = new VaccineQsns();
            question3.setTitle("How do vaccines protect individuals and communities? ");
            question3.setContent("Vaccines work by training and preparing the body’s natural defences – the immune system – to recognize and fight off viruses and bacteria. If the body is exposed to those disease-causing pathogens later, it will be ready to destroy them quickly – which prevents illness.\n" +
                    "\n" +
                    "When a person gets vaccinated against a disease, their risk of infection is also reduced – so they’re also less likely to transmit the virus or bacteria to others. As more people in a community get vaccinated, fewer people remain vulnerable, and there is less possibility for an infected person to pass the pathogen on to another person. Lowering the possibility for a pathogen to circulate in the community protects those who cannot be vaccinated (due to health conditions, like allergies, or their age) from the disease targeted by the vaccine.\n" +
                    "\n" +
                    "'Herd immunity', also known as 'population immunity', is the indirect protection from an infectious disease that happens when immunity develops in a population either through vaccination or through previous infection. Herd immunity does not mean unvaccinated or individuals who have not previously been infected are themselves immune. Instead, herd immunity exists when individuals who are not immune, but live in a community with a high proportion of immunity, have a reduced risk of disease as compared to non-immune individuals living in a community with a small fraction of immunity.\n" +
                    "\n" +
                    "In communities with high immunity, the non-immune people have a lower risk of disease than they otherwise would, but their reduced risk results from the immunity of people in the community in which they are living (i.e. herd immunity) not because they are personally immune. Even after herd immunity is first reached and a reduced risk of disease among unimmunized people is observed, this risk will keep falling if vaccination coverage continues to increase. When vaccine coverage is very high, the risk of disease among those who are non-immune can become similar to those who are truly immune.\n" +
                    "\n" +
                    "WHO supports achieving 'herd immunity' through vaccination, not by allowing a disease to spread through a population, as this would result in unnecessary cases and deaths. \n" +
                    "\n" +
                    "For COVID-19, a new disease causing a global pandemic, many vaccines are in development and some are in the early phase of rollout, having demonstrated safety and efficacy against disease.  The fraction of the population that must be vaccinated against COVID-19 to begin inducing herd immunity is not known.  This is an important area of research and will likely vary according to the community, the vaccine, the populations prioritized for vaccination, and other factors. \n" +
                    "\n" +
                    "Herd immunity is an important attribute of vaccines against polio, rotavirus, pneumococcus, Haemophilus influenzae type B, yellow fever, meningococcus and numerous other vaccine preventable diseases. Yet it is an approach that only works for vaccine-preventable diseases with an element of person-to-person spread. For example, tetanus is caught from bacteria in the environment, not from other people, so those who are unimmunized are not protected from the disease even if most of the rest of the community is vaccinated. ");

            VaccineQsns question4 = new VaccineQsns();
            question4.setTitle("Why should I get vaccinated?");
            question4.setContent("Without vaccines, we are at risk of serious illness and disability from diseases like measles, meningitis, pneumonia, tetanus and polio. Many of these diseases can be life-threatening. WHO estimates that vaccines save between 2 and 3 million lives every year.\n" +
                    "\n" +
                    "Although some diseases may have become uncommon, the germs that cause them continue to circulate in some or all parts of the world. In today’s world, infectious diseases can easily cross borders, and infect anyone who is not protected\n" +
                    "\n" +
                    "Two key reasons to get vaccinated are to protect ourselves and to protect those around us. Because not everyone can be vaccinated – including very young babies, those who are seriously ill or have certain allergies – they depend on others being vaccinated to ensure they are also safe from vaccine-preventable diseases.");

            VaccineQsns question5 = new VaccineQsns();
            question5.setTitle("What diseases do vaccines prevent? ");
            question5.setContent(" Vaccines protect against many different diseases, including:\n"+

                    "Cervical cancer \n"+
                    "\n"+"Cholera\n"+
                    "\n"+"Diphtheria\n"+
                    "\n"+"Hepatitis B\n"+
                    "\n"+"Influenza\n"+
                    "\n"+"Japanese encephalitis\n"+
                    "\n"+"Measles\n"+
                    "\n"+"Meningitis\n"+
                    "\n"+"Mumps\n"+
                    "\n"+"Pertussis\n"+
                    "\n"+"Pneumonia\n"+
                    "\n"+"Polio\n"+
                    "\n"+"Rabies\n"+
                    "\n"+"Rotavirus\n"+
                    "\n"+"Rubella\n"+
                    "\n"+"Tetanus\n"+
                    "\n"+"Typhoid\n"+
                    "\n"+"Varicella\n"+
                    "\n"+"Yellow fever\n"+

                    "\n"+" Some other vaccines are currently under development or being piloted, including those that protect against Ebola or malaria, but are not yet widely available globally.\n"+

                    "\n"+" Not all of these vaccinations may be needed in your country. Some may only be given prior to travel, in areas of risk, or to people in high-risk occupations. Talk to your healthcare worker to find out what vaccinations are needed for you and your family.\n"+


                    "\n"+"Should my daughter get vaccinated against human papillomavirus (HPV)?\n"+

                    "\n"+"Virtually all cervical cancer cases start with a sexually transmitted HPV infection. If given before exposure to the virus, vaccination offers the best protection against this disease. Following vaccination, reductions of up to 90% in HPV infections in teenage girls and young women have been demonstrated by studies conducted in Australia, Belgium, Germany, New Zealand, Sweden, the United Kingdom and the United States of America.\n"+

                    "\n"+"In studies, the HPV vaccine has been shown to be safe and effective. WHO recommends that all girls aged 9–14 years receive 2 doses of the vaccine, alongside cervical cancer screening later in life.");
            VaccineQsns question6 = new VaccineQsns();
            question6.setTitle("When should I get vaccinated (or vaccinate my child)? ");
            question6.setContent("Vaccines protect us throughout life and at different ages, from birth to childhood, as teenagers and into old age. In most countries you will be given a vaccination card that tells you what vaccines you or your child have had and when the next vaccines or booster doses are due. It is important to make sure that all these vaccines are up to date.\n" +
                    "\n" +
                    "If we delay vaccination, we are at risk of getting seriously sick. If we wait until we think we may be exposed to a serious illness – like during a disease outbreak – there may not be enough time for the vaccine to work and to receive all the recommended doses.");
            VaccineQsns question7 = new VaccineQsns();
            question7.setTitle("Who can get vaccinated? ");
            question7.setContent("Nearly everyone can get vaccinated. However, because of some medical conditions, some people should not get certain vaccines, or should wait before getting them. These conditions can include:\n" +
                    "\n" +
                    "    Chronic illnesses or treatments (like chemotherapy) that affect the immune system;\n" +
                    "\n" +
                    "    Severe and life-threatening allergies to vaccine ingredients, which are very rare;\n" +
                    "\n" +
                    "    If you have severe illness and a high fever on the day of vaccination.\n" +
                    "\n" +
                    "These factors often vary for each vaccine. If you’re not sure if you or your child should get a particular vaccine, talk to your health worker. They can help you make an informed choice about vaccination for you or your child.");

            VaccineQsns question8 = new VaccineQsns();
            question8.setTitle("How are vaccines developed and tested? ");
            question8.setContent("The most commonly used vaccines have been around for decades, with millions of people receiving them safely every year. As with all medicines, every vaccine must go through extensive and rigorous testing to ensure it is safe before it can be introduced in a country.\n" +
                    "\n" +
                    "An experimental vaccine is first tested in animals to evaluate its safety and potential to prevent disease. It is then tested in human clinical trials, in three phases:\n" +
                    "\n" +
                    "    In phase I, the vaccine is given to a small number of volunteers to assess its safety, confirm it generates an immune response, and determine the right dosage. \n" +
                    "\n" +
                    "\n" +
                    "    In phase II, the vaccine is usually given hundreds of volunteers, who are closely monitored for any side effects, to further assess its ability to generate an immune response. In this phase, data are also collected whenever possible on disease outcomes, but usually not in large enough numbers to have a clear picture of the effect of the vaccine on disease. Participants in this phase have the same characteristics (such as age and sex) as the people for whom the vaccine is intended. In this phase, some volunteers receive the vaccine and others do not, which allows comparisons to be made and conclusions drawn about the vaccine. \n" +
                    "\n" +
                    "\n" +
                    "    In phase III, the vaccine is given to thousands of volunteers – some of whom receive the investigational vaccine, and some of whom do not, just like in phase II trials. Data from both groups is carefully compared to see if the vaccine is safe and effective against the disease it is designed to protect against. \n" +
                    "\n" +
                    "\n" +
                    "Once the results of clinical trials are available, a series of steps is required, including reviews of efficacy, safety, and manufacturing for regulatory and public health policy approvals, before a vaccine may be introduced into a national immunization programme.\n" +
                    "\n" +
                    "Following the introduction of a vaccine, close monitoring continues to detect any unexpected adverse side effects and further assess effectiveness in the routine use setting among even larger numbers of people to continue assessing how best to use the vaccine for the greatest protective impact.");

            VaccineQsns question9 = new VaccineQsns();
            question9.setTitle("I still have questions about vaccination. What should I do? ");
            question9.setContent("If you have questions about vaccines be sure to talk to your healthcare worker. He or she can provide you with science-based advice about vaccination for you and your family, including the recommended vaccination schedule in your country.\n" +
                    "\n" +
                    "When looking online for information about vaccines, be sure to consult only trustworthy sources. To help you find them, WHO has reviewed and ‘certified’ many websites across the world that provide only information based on reliable scientific evidence and independent reviews by leading technical experts.");

            VaccineQsns question10 = new VaccineQsns();
            question10.setTitle("What is in a vaccine? ");
            question10.setContent("All the ingredients of a vaccine play an important role in ensuring a vaccine is safe and effective. Some of these include:\n" +
                    "\n" +
                    "    The antigen. This is a killed or weakened form of a virus or bacteria, which trains our bodies to recognize and fight the disease if we encounter it in the future.\n" +
                    "\n" +
                    "    Adjuvants, which help to boost our immune response. This means they help vaccines to work better.\n" +
                    "\n" +
                    "    Preservatives, which ensure a vaccine stays effective.\n" +
                    "\n" +
                    "    Stabilisers, which protect the vaccine during storage and transportation.\n" +
                    "\n" +
                    "Vaccine ingredients can look unfamiliar when they are listed on a label. However, many of the components used in vaccines occur naturally in the body, in the environment, and in the foods we eat. All of the ingredients in vaccines – as well as the vaccines themselves - are thoroughly tested and monitored to ensure they are safe.");

            VaccineQsns question11 = new VaccineQsns();
            question11.setTitle("Are vaccines safe? ");
            question11.setContent("Vaccination is safe and side effects from a vaccine are usually minor and temporary, such as a sore arm or mild fever. More serious side effects are possible, but extremely rare.\n" +
                    "\n" +
                    "Any licensed vaccine is rigorously tested across multiple phases of trials before it is approved for use, and regularly reassessed once it is introduced. Scientists are also constantly monitoring information from several sources for any sign that a vaccine may cause health risks.\n" +
                    "\n" +
                    "Remember, you are far more likely to be seriously injured by a vaccine-preventable disease than by a vaccine. For example, tetanus can cause extreme pain, muscle spasms (lockjaw) and blood clots, measles can cause encephalitis (an infection of the brain) and blindness. Many vaccine-preventable diseases can even result in death. The benefits of vaccination greatly outweigh the risks, and many more illnesses and deaths would occur without vaccines.");

            VaccineQsns question12 = new VaccineQsns();
            question12.setTitle("COVID-19 virus can be transmitted in areas with hot and humid climates");
            question12.setContent("COVID-19 virus can be transmitted in areas with hot and humid climates");

            VaccineQsns question13 = new VaccineQsns();
            question13.setTitle("How does WHO help ensure vaccine safety? ");
            question13.setContent("WHO works to ensure that everyone, everywhere is protected by safe and effective vaccines. To do this, we help countries set up rigorous safety systems for vaccines and apply strict international standards to regulate them.\n" +
                    "\n" +
                    "Together with scientists from around the world, WHO experts conduct ongoing monitoring to make sure that vaccines continue to be safe. We also work with partners to help countries investigate and communicate if potential issues of concern arise.\n" +
                    "\n" +
                    "Any unexpected adverse side effects that are reported to WHO are evaluated by an independent group of experts called the Global Advisory Committee on Vaccine Safety. ");


            questionsDao.insert(question);
            questionsDao.insert(question1);
            questionsDao.insert(question2);
            questionsDao.insert(question3);
            questionsDao.insert(question4);
            questionsDao.insert(question5);
            questionsDao.insert(question6);
            questionsDao.insert(question7);
            questionsDao.insert(question8);
            questionsDao.insert(question9);
            questionsDao.insert(question10);
            questionsDao.insert(question11);
            questionsDao.insert(question12);
            questionsDao.insert(question13);

            return null;
        }
    }
}
