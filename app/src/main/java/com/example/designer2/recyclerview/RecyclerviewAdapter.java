package com.example.designer2.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.CustomViewHolder> {
    private List<People> peopleList;
    private Context context;

    public RecyclerviewAdapter(Context context, List<People> peopleList) {
        this.peopleList = peopleList;
        this.context = context;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view  = layoutInflater.inflate(R.layout.row_item,viewGroup,false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        customViewHolder.name.setText(peopleList.get(i).getName());

        Glide.with(context).load(peopleList.get(i).getImgurl()).into(customViewHolder.img);





    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        public final View v;

        TextView name;
        CircleImageView img;
        RelativeLayout parentLayout;

        CustomViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            name = v.findViewById(R.id.text_view);
            img = v.findViewById(R.id.cicrle_image);
            parentLayout = v.findViewById(R.id.row_item);
        }
    }

}





