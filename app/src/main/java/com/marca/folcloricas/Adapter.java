package com.marca.folcloricas;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Cancion> implements View.OnClickListener{

        private ArrayList<Cancion> dataSet;
        Context mContext;

        // View lookup cache
        private static class ViewHolder {
            TextView txtName;
            TextView txtType;

        }

        public Adapter(ArrayList<Cancion> data, Context context) {
            super(context, R.layout.lista_canciones, data);
            this.dataSet = data;
            this.mContext=context;

        }

        public void onClick(View v) {

            int position=(Integer) v.getTag();
            Object object= getItem(position);
            Cancion dataModel=(Cancion) object;
            /*
            switch (v.getId())
            {
                case R.id.item_info:
                    Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                            .setAction("No action", null).show();
                    break;
            }
            */
        }

        private int lastPosition = -1;


        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Cancion dataModel = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            ViewHolder viewHolder; // view lookup cache stored in tag

            final View result;

            if (convertView == null) {

                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.lista_canciones, parent, false);
                viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
                viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
                result=convertView;

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
                result=convertView;
            }

            Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
            result.startAnimation(animation);
            lastPosition = position;

            viewHolder.txtName.setText(dataModel.getName());
            viewHolder.txtType.setText(dataModel.getType());
            // Return the completed view to render on screen
            return convertView;
        }
    }


