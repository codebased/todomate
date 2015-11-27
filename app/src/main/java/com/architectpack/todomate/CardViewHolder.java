package com.architectpack.todomate;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by codebased on 10/11/15.
 */
public class CardViewHolder extends RecyclerView.ViewHolder{
    public TextView numberTextView;

    public CardViewHolder(View itemView) {
        super(itemView);
        numberTextView = (TextView) itemView.findViewById(R.id.numberTextView);
    }
}
