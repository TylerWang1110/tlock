package com.tyler.tlock.tlock.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tyler.tlock.tlock.R;
import com.tyler.tlock.tlock.dao.DBUtil;
import com.tyler.tlock.tlock.model.AppInfo;

import java.util.List;

/**
 * @创建者 Tyler.
 * @创建时间 2016/10/6  16:25.
 * @描述 ${TODO}.
 */
public class AppAdapter extends BaseAdapter {
    private final List<AppInfo> mAppInfos;

    public AppAdapter(List<AppInfo> appInfos) {
        this.mAppInfos = appInfos;
    }

    @Override
    public int getCount() {
        return mAppInfos.size();
    }

    @Override
    public AppInfo getItem(int position) {
        return mAppInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        AppInfo item = getItem(position);
        viewHolder.ivAppIcon.setImageDrawable(item.icon);
        viewHolder.tvAppName.setText(item.name);
        boolean isLocked = DBUtil.queryIsLocked(parent.getContext(), item.packageName);
        viewHolder.iv.setImageResource(isLocked ? R.mipmap.btn_l_lock : R.mipmap.btn_l_onlock);
        return convertView;
    }

    private static class ViewHolder {
        ImageView ivAppIcon;
        TextView tvAppName;
        ImageView iv;

        public ViewHolder(View convertView) {
            ivAppIcon = (ImageView) convertView.findViewById(R.id.iv_item_appicon);
            tvAppName = (TextView) convertView.findViewById(R.id.tv_item_appname);
            iv = (ImageView) convertView.findViewById(R.id.iv_item_lock);
        }
    }
}
