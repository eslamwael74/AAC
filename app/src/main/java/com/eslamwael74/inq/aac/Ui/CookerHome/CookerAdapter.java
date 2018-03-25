package com.eslamwael74.inq.aac.Ui.CookerHome;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eslamwael74.inq.aac.Data.Model.Cooker;
import com.eslamwael74.inq.aac.R;
import com.eslamwael74.inq.aac.Ui.CookerDetails.DetailsActivity;

import java.util.List;

/**
 * Created by eslamwael74 on 3/21/2018.
 */

public class CookerAdapter extends RecyclerView.Adapter<CookerAdapter.MyViewHolder> {

    List<Cooker> cookers;
    FragmentActivity fragmentActivity;

    public CookerAdapter(List<Cooker> cookers, FragmentActivity fragmentActivity) {
        this.cookers = cookers;
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(fragmentActivity).
                inflate(R.layout.cooker_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(cookers.get(position).getName());

        holder.tv.setOnClickListener(view -> {
            fragmentActivity.startActivity(DetailsActivity.newIntent(fragmentActivity,cookers.get(position).getId()));
        });
    }

    @Override
    public int getItemCount() {
        return cookers.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        ImageView img;


        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.image);
        }
    }


}
