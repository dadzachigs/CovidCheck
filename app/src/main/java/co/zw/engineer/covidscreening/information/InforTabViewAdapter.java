package co.zw.engineer.covidscreening.information;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import co.zw.engineer.covidscreening.information.generalquestions.GeneralFqa;
import co.zw.engineer.covidscreening.information.symptoms.SymptomsQs;
import co.zw.engineer.covidscreening.information.vaccine.VaccineFqa;

public class InforTabViewAdapter extends FragmentPagerAdapter {

    int totalTabs;
    String [] tittle ={"COVID Vaccine", "COVID Symptoms","General COVID FQA"};
    public InforTabViewAdapter (FragmentManager fm, int totalTabs) {
        super(fm);


        this.totalTabs = totalTabs;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tittle[position];
    }


    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                VaccineFqa homeFragment = new VaccineFqa();
                return homeFragment;

            case 1:
                SymptomsQs deFragment = new SymptomsQs();
                return deFragment;
            case 2:
                GeneralFqa sportFragment = new GeneralFqa();
                return sportFragment;

            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
