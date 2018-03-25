package com.eslamwael74.inq.aac.Ui.CookerHome;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.eslamwael74.inq.aac.Data.Model.Cooker;
import com.eslamwael74.inq.aac.Injection.Injectable;
import com.eslamwael74.inq.aac.R;
import com.eslamwael74.inq.aac.Utils.BaseFragment;
import com.eslamwael74.inq.aac.Webservice.Constants.Resource;

import java.util.List;

/**
 * Created by eslamwael74 on 3/21/2018.
 */

public class CookerFragment extends BaseFragment<CookerViewModel> implements LifecycleOwner, Injectable {

    RecyclerView recyclerView;
    Button btn;


    public static CookerFragment newInstance() {
        return new CookerFragment();
    }


    @Override
    public Class<CookerViewModel> getViewModel() {
        return CookerViewModel.class;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_main;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(getLayoutRes(), container, false);

        recyclerView = view.findViewById(R.id.rec);
        btn = view.findViewById(R.id.btn);

        if (savedInstanceState == null)
            viewModel.init("15203519025a9eba9e85beb", "29.9993", "31.1213");


        btn.setOnClickListener(view1 -> viewModel.init("15203519025a9eba9e85beb", "29.9993", "31.1213"));

        return view;
    }

    void init(List<Cooker> cookers) {
        if (cookers != null) {
            CookerAdapter cookerAdapter = new CookerAdapter(cookers, getActivity());
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(cookerAdapter);
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LiveData<Resource<List<Cooker>>> cookerLiveData = viewModel.getCookerLiveData();
        cookerLiveData.observe(this, listResource -> {
            init(listResource.data);
        });

    }

}
