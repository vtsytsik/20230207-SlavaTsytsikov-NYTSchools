package com.feefasoft.a20230207_slavatsytsikov_nytschools.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.feefasoft.a20230207_slavatsytsikov_nytschools.R;
import com.feefasoft.a20230207_slavatsytsikov_nytschools.model.SchoolDetails;
import com.feefasoft.a20230207_slavatsytsikov_nytschools.view.SchoolScoresActivity;

import java.util.ArrayList;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {

    private Context context;
    ArrayList<SchoolDetails> articleArrayList;

    public SchoolAdapter(Context context, ArrayList<SchoolDetails> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_school_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SchoolDetails schoolDetails = articleArrayList.get(i);
        viewHolder.tvSchoolName.setText(schoolDetails.school_name);
        viewHolder.tvSchoolLocation.setText(schoolDetails.location);
        viewHolder.tvSchoolPhoneNumber.setText("Phone Number " + schoolDetails.phone_number);
        viewHolder.tvEmail.setText("Email: " + schoolDetails.school_email);
        viewHolder.tvWebSite.setText(schoolDetails.website);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SchoolScoresActivity.class);
                intent.putExtra("school_dbn", schoolDetails.dbn);
                view.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvSchoolPhoneNumber;
        private final TextView tvSchoolLocation;
        private final TextView tvSchoolName;
        private final TextView tvEmail;
        private final TextView tvWebSite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvSchoolName = (TextView) itemView.findViewById(R.id.tv_school_name);
            tvSchoolLocation = (TextView) itemView.findViewById(R.id.tv_school_location);
            tvSchoolPhoneNumber = (TextView) itemView.findViewById(R.id.tv_phone_number);
            tvEmail = (TextView) itemView.findViewById(R.id.tv_email);
            tvWebSite = (TextView) itemView.findViewById(R.id.tv_web_site);

        }

    }
}
