package com.eslamwael74.inq.aac.Ui.CookerDetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.eslamwael74.inq.aac.R;
import com.eslamwael74.inq.aac.Ui.CookerHome.CookerFragment;
import com.eslamwael74.inq.aac.Utils.BaseActivity;


public class DetailsActivity extends BaseActivity {

    private static final String DETAILS_FRAG = "DETAILS_FRAG";
    private static final String COOKER_ID = "cooker_id";

    @Override
    public int getLayoutRes() {
        return R.layout.activity_details;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public static Intent newIntent(Context context, int cookerId) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(COOKER_ID, cookerId);
        return intent;
    }

    void init() {
        FragmentManager manager = getSupportFragmentManager();
        CookerDetailsFragment cookerDetailsFragment = (CookerDetailsFragment) manager.findFragmentByTag(DETAILS_FRAG);

        if (cookerDetailsFragment == null) {
            int cookerId = getIntent().getIntExtra(COOKER_ID,-1);
            cookerDetailsFragment = CookerDetailsFragment.newInstance(cookerId);
        }
        addFragmentToActivity(manager, cookerDetailsFragment, R.id.details_frame, DETAILS_FRAG);

    }


}

