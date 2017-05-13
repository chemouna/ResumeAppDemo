package com.example.resume.resume;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.resume.model.ResumeElement;
import java.util.ArrayList;
import java.util.List;

public class ResumeAdapter extends RecyclerView.Adapter<ResumeElementViewHolder> {

    private List<ResumeElement> items = new ArrayList<>();

    @Override
    public ResumeElementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(ResumeElementViewHolder.getLayoutId(), parent, false);
        return new ResumeElementViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ResumeElementViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    void setItems(List<ResumeElement> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}
