package com.architectpack.todomate;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by codebased on 10/11/15.
 */
public class TaskListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleList);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);

        ArrayList<Integer> test = new ArrayList<>();
        View header = LayoutInflater.from(this).inflate(R.layout.header, recyclerView, false);
        test.add(0);
        test.add(1);
        test.add(2);
        final HeaderNumberedAdapter<Integer> adapter = new HeaderNumberedAdapter(header, test);

        recyclerView.setAdapter(adapter);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int position) {
                return adapter.isHeader(position) ? manager.getSpanCount() : 1;
            }
        });
    }
}
