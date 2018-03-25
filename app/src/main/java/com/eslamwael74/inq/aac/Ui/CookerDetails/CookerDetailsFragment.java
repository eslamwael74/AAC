package com.eslamwael74.inq.aac.Ui.CookerDetails;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eslamwael74.inq.aac.Data.Model.Cooker;
import com.eslamwael74.inq.aac.R;
import com.eslamwael74.inq.aac.Utils.BaseFragment;
import com.eslamwael74.inq.aac.Webservice.Constants.Resource;

/**
 * Created by eslamwael74 on 3/21/2018.
 */

public class CookerDetailsFragment extends BaseFragment<CookerDetailsViewModel> {

    TextView tv;

    private static final String COOKER_ID = "cooker_id";

    private int cookerId;


    public static CookerDetailsFragment newInstance(int cookerId) {
        CookerDetailsFragment cookerDetailsFragment = new CookerDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(COOKER_ID, cookerId);
        cookerDetailsFragment.setArguments(bundle);
        return cookerDetailsFragment;
    }


    @Override
    public Class<CookerDetailsViewModel> getViewModel() {
        return CookerDetailsViewModel.class;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_details;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutRes(), container, false);
        tv = view.findViewById(R.id.tv);
        cookerId = getArguments().getInt(COOKER_ID);


        return view;
    }

    void init(String name) {
        tv.setText(name);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LiveData<Cooker> cookerLiveData = viewModel.getCooker(cookerId);
        cookerLiveData.observe(this, cookerResource -> {
            init(cookerResource.getName());
        });
    }


}
