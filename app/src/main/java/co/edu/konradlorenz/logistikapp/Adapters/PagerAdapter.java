package co.edu.konradlorenz.logistikapp.Adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import co.edu.konradlorenz.logistikapp.Fragments.DownloadFragment;
import co.edu.konradlorenz.logistikapp.Fragments.HomeFragment;
import co.edu.konradlorenz.logistikapp.Fragments.ListarEstudiantesFragment;
import co.edu.konradlorenz.logistikapp.Fragments.NivelesFragment;

/**
 * Created by KURPC on 24-01-2018.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                HomeFragment tab1 = new HomeFragment();
                return tab1;
            case 1:
                ListarEstudiantesFragment tab2 = new ListarEstudiantesFragment();
                return tab2;
            case 2:
                NivelesFragment tab3 = new NivelesFragment();
                return tab3;
            case 3:
                DownloadFragment tab4 = new DownloadFragment();
                return tab4;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;

    }
}
