package co.zw.engineer.covidscreening.model;

import java.util.ArrayList;
import java.util.List;

public class GlobalValues {
    public static final String PROVINCES_ACTIVE_CASES = "ACTIVE CASES BY PROVINCE";
    public static final String PROVINCES_TOTAL_TESTS = "TOTAL TEST IN A PROVINCE";
    public static int  EXPOSURE_FRAG=0;
    public static int  SYMPTOMS_FRAG=0;
    public static int  TRAVEL_FRAG=0;
    public static List<Question> symptomsFragmentQuestions = new ArrayList<>();
    public static List<Question> travelFragmentQuestions = new ArrayList<>();
    public static List<Question> exposureFragmentQuestions = new ArrayList<>();
   // public static SelfScreenDao selfScreenDao = new SelfScreenDao();
    public static  String USER_SURNAME_KEY =" ";
    public static  String USER_NAME_KEY = "";
    public static  String SELF_SCREEN_TEST_DATE_KEY= "SELF_SCREEN_TEST_DATE_KEY";
    public static  boolean USER_IS_LOGED_IN_KEY = true;
    public static  String PROVINCES= "PROVINCES";
    public static  String USER_NAME = "Darlington";
    public static  String USER_EMAIL = "USER_EMAIL";
    public static  String USER_TYPE = "USER_TYPE";
    public static  String PHONE_NUMBER = "PHONE_NUMBER";
    public static  String RETURNED_USER_ID="RETURNED_USER_ID";
    public static  String USER_TOKEN="USER_TOKEN";
    public static  String USER_NATID="USER_NATID";
    public static  int SWITCH = 0;
    public static  String SHARED_PREF_NAME = "APP_SESSION";
    public static String USER_PHONE_NUMBER;
    public static int  DEATHS=8;
    public static int  RECOVERIES=0;
    public static int  CASES=0;



}
