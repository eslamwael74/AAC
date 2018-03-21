package com.eslamwael74.inq.aac.Ui.CookerHome;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.eslamwael74.inq.aac.R;
import com.eslamwael74.inq.aac.Utils.BaseActivity;

public class MainActivity extends BaseActivity {

    private static final String COOKER_FRAG = "LIST_FRAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    void init() {
        FragmentManager manager = getSupportFragmentManager();
        CookerFragment cookerFragment = (CookerFragment) manager.findFragmentByTag(COOKER_FRAG);

        if (cookerFragment == null) {
            cookerFragment = CookerFragment.newInstance();
        }
        addFragmentToActivity(manager, cookerFragment, R.id.main_frame, COOKER_FRAG);

    }


}

