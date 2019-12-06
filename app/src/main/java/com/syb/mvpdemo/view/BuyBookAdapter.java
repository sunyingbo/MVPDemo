package com.syb.mvpdemo.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.syb.mvpdemo.R;
import com.syb.mvpdemo.bean.BuyBookBean;

import java.util.List;

public class BuyBookAdapter extends BaseAdapter {

    private Context mContext;
    private List<BuyBookBean> mListData;

    public BuyBookAdapter(Context context, List<BuyBookBean> buyBookBeans) {
        mContext = context;
        mListData = buyBookBeans;
    }

    @Override
    public int getCount() {
        return mListData == null ? 0 : mListData.size();
    }

    @Override
    public BuyBookBean getItem(int position) {
        return mListData == null ? null : mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.list_item, null);
            viewHolder = new MyHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MyHolder) convertView.getTag();
        }
        viewHolder.name.setText(getItem(position).getName());
        viewHolder.number.setText(getItem(position).getNumber());
        viewHolder.time.setText(getItem(position).getTime());
        return convertView;
    }

    private class MyHolder {
        TextView name;
        TextView number;
        TextView time;

        public MyHolder(View view) {
            name = view.findViewById(R.id.name);
            number = view.findViewById(R.id.number);
            time = view.findViewById(R.id.time);
        }
    }

}
