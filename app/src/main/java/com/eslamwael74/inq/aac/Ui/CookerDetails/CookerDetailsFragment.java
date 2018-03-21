package com.eslamwael74.inq.aac.Ui.CookerDetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eslamwael74.inq.aac.R;

/**
 * Created by eslam on 3/21/2018.
 */

public class CookerDetailsFragment extends Fragment {


    TextView tv;



    public static CookerDetailsFragment newInstance() {
        return new CookerDetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details,container,false);

        tv = view.findViewById(R.id.tv);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
