package com.eslamwael74.inq.aac.Ui.CookerDetails;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.eslamwael74.inq.aac.R;
import com.eslamwael74.inq.aac.Ui.CookerHome.CookerFragment;
import com.eslamwael74.inq.aac.Utils.BaseActivity;

public class DetailsActivity extends BaseActivity {

    private static final String DETAILS_FRAG = "DETAILS_FRAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        init();

    }


    void init() {
        FragmentManager manager = getSupportFragmentManager();
        CookerDetailsFragment cookerDetailsFragment = (CookerDetailsFragment) manager.findFragmentByTag(DETAILS_FRAG);

        if (cookerDetailsFragment == null) {
            cookerDetailsFragment = CookerDetailsFragment.newInstance();
        }
        addFragmentToActivity(manager, cookerDetailsFragment, R.id.details_frame, DETAILS_FRAG);

    }


}

