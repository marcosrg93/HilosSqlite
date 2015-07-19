package com.rubinogarcia.xml.hilossqlite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by marco on 19/07/2015.
 */
public class Adaptador extends CursorAdapter {

    public Adaptador(Context context, Cursor c) {
        super(context, c, true);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater i = LayoutInflater.from(parent.getContext());
        View v = i.inflate(R.layout.detalle, parent, false);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv1;
        tv1 = (TextView)view.findViewById(R.id.tvMostrar);


        AnchorToDcm j = GestorAnchorToDcm.getRow(cursor);
        tv1.setText(j.getAnchor());
        tv1.setText(j.getDcm());
    }

}
