package com.architectpack.todomate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by codebased on 10/11/15.
 */
public class HeaderNumberedAdapter<T> extends RecyclerView.Adapter<CardViewHolder> {

    private static final int ITEM_TYPE_HEADER = 0;
    private static final int ITEM_TYPE_ITEM = 1;
    private final View header;
    private final List<T> items;

    public HeaderNumberedAdapter(View header, List<T> items) {
        this.header = header;
        this.items = items;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_HEADER) return new CardViewHolder(header);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewholder, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        if (isHeader(position)) return;

        holder.numberTextView.setText(position + "");
    }

    public boolean isHeader(int position) {
        return position == 0;
    }

    @Override
    public int getItemCount() {
        return items.size() + 1;
    }
}
