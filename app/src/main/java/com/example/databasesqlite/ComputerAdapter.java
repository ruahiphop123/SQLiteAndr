package com.example.databasesqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ComputerAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<InforDataComputer> list;

    public ComputerAdapter(Context context, int layout, List<InforDataComputer> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override

    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView tenMay, hangSX;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.tenMay = (TextView) view.findViewById(R.id.tenComputer);
            holder.hangSX = view.findViewById(R.id.hangSX);
            view.setTag(holder);
        }
        else
            holder = (ViewHolder) view.getTag();

        InforDataComputer data = list.get(i);

        holder.tenMay.setText(data.getTenMay());
        holder.hangSX.setText(data.getHangSX());

        return view;
    }
}
