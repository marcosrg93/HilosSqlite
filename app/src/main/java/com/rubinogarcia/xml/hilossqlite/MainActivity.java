package com.rubinogarcia.xml.hilossqlite;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    private GestorAnchorToDcm gj;
    private EditText etMostrar;
    private Adaptador ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gj = new GestorAnchorToDcm(this);
        etMostrar = (EditText)findViewById(R.id.etBuscar);


        final ListView lv = (ListView)findViewById(R.id.lvMostrar);

        gj.open();


        Cursor c = gj.getCursor();

        ad = new Adaptador(this, c);
        lv.setAdapter(ad);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
