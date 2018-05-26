package org.akshanshgusain.searchview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyrecycleViewAdapter extends RecyclerView.Adapter<MyrecycleViewAdapter.ViewHollder>{
    private ArrayList<Model> arraylist=new ArrayList<>();

    public MyrecycleViewAdapter(ArrayList<Model> arraylist) {
        this.arraylist=arraylist;
    }

    @NonNull
    @Override
    public ViewHollder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row,parent,false);
        ViewHollder vh=new ViewHollder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHollder holder, int position) {
        holder.tView.setText(arraylist.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }

    public class ViewHollder extends RecyclerView.ViewHolder{
        TextView tView;

        public ViewHollder(View itemView) {
            super(itemView);
            tView=itemView.findViewById(R.id.tvName);
        }
    }
    public void setFilter(ArrayList<Model> marraylist){
        arraylist=new ArrayList<>();
        arraylist.addAll(marraylist);
        notifyDataSetChanged();
    }

}
