package com.simple.butterknife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by zhangzeyan on 16/12/14.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private String[] citys;

    public MyAdapter(Context context,String[] citys) {
        this.context = context;
        this.citys = citys;
    }

    @Override
    public int getCount() {
        return citys.length;
    }

    @Override
    public Object getItem(int i) {
        return citys[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_list_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textview.setText(citys[position]);
        return convertView;
    }

    static class ViewHolder{

        @BindView(R.id.cityTv)
        public TextView textview;

        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }


}
