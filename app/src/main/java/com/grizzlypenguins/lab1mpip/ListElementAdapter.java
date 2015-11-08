package com.grizzlypenguins.lab1mpip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Darko on 08.11.2015.
 */
public class ListElementAdapter extends BaseAdapter {
    ArrayList<ListInput> myList = new ArrayList<ListInput>();
    LayoutInflater inflater;
    Context context;

    public ListElementAdapter(Context context, ArrayList<ListInput> myList) {
        this.myList = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    public void update(ListInput s)
    {
        myList.add(s);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public ListInput getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_layout, parent, false);
            mViewHolder = new MyViewHolder(convertView,position);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        ListInput currentListData = getItem(position);
        mViewHolder.text.setText(currentListData.text);
        mViewHolder.time.setText(currentListData.time);
        return convertView;


    }

    private class MyViewHolder {
        TextView text, time;
        int num=0;
        public MyViewHolder(View item,int n) {
            num = n;
            text = (TextView) item.findViewById(R.id.Text);
            time = (TextView) item.findViewById(R.id.Time);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                SecondActivity temp = (SecondActivity)context;
                    temp.remove_row(num);
                }
            });
        }
    }
}
