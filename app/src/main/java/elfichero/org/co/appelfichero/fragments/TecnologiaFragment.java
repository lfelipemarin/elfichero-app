package elfichero.org.co.appelfichero.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import elfichero.org.co.appelfichero.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TecnologiaFragment extends Fragment {


    public TecnologiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tecnologia, container, false);
    }


}
