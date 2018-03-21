package com.eslamwael74.inq.aac.Ui.CookerHome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eslamwael74.inq.aac.R;

/**
 * Created by eslam on 3/21/2018.
 */

public class CookerFragment extends Fragment {


    RecyclerView recyclerView;


    public static CookerFragment newInstance() {
        return new CookerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main,container,false);

        recyclerView = view.findViewById(R.id.rec);



        return view;
    }

    void init(){
//        CookerAdapter cookerAdapter = new CookerAdapter(,getActivity())
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
