package co.edu.konradlorenz.logistikapp.Adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import co.edu.konradlorenz.logistikapp.Fragments.DescargarMarcadorFragment;
import co.edu.konradlorenz.logistikapp.Fragments.InicioFragment;
import co.edu.konradlorenz.logistikapp.Fragments.ListarEstudiantesFragment;
import co.edu.konradlorenz.logistikapp.Fragments.ListarNivelesFragment;

/**
 * Created by KURPC on 24-01-2018.
 */

public class TabsAdapter extends FragmentPagerAdapter {

    int mNoOfTabs;

    public TabsAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                InicioFragment tab1 = new InicioFragment();
                return tab1;
            case 1:
                ListarEstudiantesFragment tab2 = new ListarEstudiantesFragment();
                return tab2;
            case 2:
                ListarNivelesFragment tab3 = new ListarNivelesFragment();
                return tab3;
            case 3:
                DescargarMarcadorFragment tab4 = new DescargarMarcadorFragment();
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
