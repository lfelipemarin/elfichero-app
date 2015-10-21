package elfichero.org.co.appelfichero.fragments;


import android.content.res.Resources;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import elfichero.org.co.appelfichero.ListArrayAdapter;
import elfichero.org.co.appelfichero.ListViewItem;
import elfichero.org.co.appelfichero.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends ListFragment {
    private List<ListViewItem> mItems;        // ListView items list

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize the items list
        mItems = new ArrayList<ListViewItem>();
        Resources resources = getResources();

        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.news1ico), "Noticias1", "Descripcion 1"));
        mItems.add(new ListViewItem(resources.getDrawable(R.drawable.news2ico), "Noticias2", "Descripcion 2"));

        // initialize and set the list adapter
        setListAdapter(new ListArrayAdapter(getActivity(), mItems));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // retrieve theListView item
        ListViewItem item = mItems.get(position);

        if (position == 0) {
            Fragment fragment = null;
            Class fragmentClass;
            fragmentClass = ActualidadFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }


            // Insert the fragment by replacing any existing fragment

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }

        // do something
        Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();
    }
}
