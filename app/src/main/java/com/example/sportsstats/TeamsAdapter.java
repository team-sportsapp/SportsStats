/*
package com.example.sportsstats;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TeamsAdapter extends ArrayAdapter<String> {

    String [] tNames;
    int [] tLogos;
    Context mContext;

    public TeamsAdapter(Context context, String[] team, int[] logos) {
        super(context, R.layout.listview_teams);

        this.tLogos = logos;
        this.tNames = team;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return tNames.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_teams, parent, false);
            mViewHolder.mLogo = (ImageView) convertView.findViewById(R.id.logoImageView);
            mViewHolder.mTeam = (TextView) convertView.findViewById(R.id.teamTextView);
            convertView.setTag(mViewHolder);
        }
        else{
            mViewHolder = (ViewHolder)convertView.getTag();
        }
            mViewHolder.mLogo.setImageResource(tLogos[position]);
            mViewHolder.mTeam.setText(tNames[position]);

        return convertView;
    }

    static class ViewHolder{
        ImageView mLogo;
        TextView mTeam;
    }
}
*/