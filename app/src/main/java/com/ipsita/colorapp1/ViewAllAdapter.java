package com.ipsita.colorapp1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ViewAllAdapter extends ArrayAdapter<Colors>{
    private Activity context;
    private List<Colors> colorsList;

    public ViewAllAdapter(Activity context, List<Colors> colorsList){
        super(context,R.layout.recycler_view,colorsList);
        this.context=context;
        this.colorsList=colorsList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listView = inflater.inflate(R.layout.recycler_view, null, false);

        TextView colorName=listView.findViewById(R.id.colorName);
        TextView hexCode=listView.findViewById(R.id.hexCode);

        Colors color=colorsList.get(position);
        colorName.setText(color.getColorName());
        hexCode.setText(color.getHexCode());

        return listView;
    }
}
