package com.satish.xmlparsingdemo;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by satish on 30/6/15.
 */
public class CustomAdapter extends BaseAdapter {
    private ArrayList<ListData> listData;
    private Activity activity;
    LayoutInflater inflater;

    private static  String TAG = CustomAdapter.class.getSimpleName();

    public CustomAdapter(ArrayList<ListData> listData, Activity activity) {
        this.listData = listData;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(inflater==null){
            inflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
            view=inflater.inflate(R.layout.list_view,null);
        TextView id = (TextView) view.findViewById(R.id.id);
        TextView name=(TextView)view.findViewById(R.id.name);
        TextView description=(TextView)view.findViewById(R.id.description);
        TextView cost=(TextView)view.findViewById(R.id.cost);
        ListData item=listData.get(position);

        Log.e(TAG, "id: " + id);
        id.setText(item.getId());
        name.setText("" + item.getName());
        description.setText(item.getDescription());
        cost.setText("RS." + item.getCost());
        return view;
    }
}
