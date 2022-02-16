package co.zw.engineer.covidscreening.help;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

    int totalTabs;
    String [] tittle ={"Partner Labs", "Other Labs"};
    public TabAdapter (FragmentManager fm, int totalTabs) {
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
                PartnerLabs homeFragment = new PartnerLabs();
                return homeFragment;

            case 1:
                GovtLabs deFragment = new GovtLabs();
                return deFragment;

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
