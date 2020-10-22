package com.example.btlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SingerAdapter extends BaseAdapter {
private Context context;
private int layout;
private List<Singer> singerList;

    public SingerAdapter(Context context, int layout, List<Singer> singerList) {
        this.context = context;
        this.layout = layout;
        this.singerList = singerList;
    }

    @Override
    public int getCount() {
        return singerList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        TextView txtTen = (TextView)view.findViewById(R.id.textviewTen);
        TextView txtMoTa = (TextView)view.findViewById(R.id.textviewMoTa);
        ImageView imgHinh = (ImageView)view.findViewById(R.id.imageviewHinh);
        Singer singer = singerList.get(position);
        txtTen.setText(singer.getTen());
        txtMoTa.setText(singer.getMoTa());
        imgHinh.setImageResource(singer.getHinh());

        return view;
    }
    public void removeItems(List<Singer> items)
    {
        for(Singer item : items)
        {
            singerList.remove(item);
        }
        notifyDataSetChanged();
    }
}
