package com.rubinogarcia.xml.hilossqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 19/07/2015.
 */
public class GestorAnchorToDcm {


    private Ayudante abd;
    private SQLiteDatabase bd;

    public GestorAnchorToDcm(Context c) {
        abd = new Ayudante(c);
    }
    public void open() {
        bd = abd.getWritableDatabase();
    }
    public void openRead() {
        bd = abd.getReadableDatabase();
    }
    public void close() {
        abd.close();
    }





    public List<AnchorToDcm> select(String condicion, String[] parametros, String orden) {
        List<AnchorToDcm> lo = new ArrayList<AnchorToDcm>();
        Cursor cursor = bd.query(Contrato.TablaHilos.TABLA, null, condicion, parametros, null, null, orden);
        /*
        String[] campos = {"nombre", "valoracion"};
        String[] parametros = {"Pepe", "6"};
        bd.query("tabla", campos, "nombre = ? and valoracion = ?", parametros, "groupBy", "having", "orderBy");
        //select nombre, valoracion from tabla
        //where nombre = ? and valoracion = ?
        //...
        */
        cursor.moveToFirst();
        AnchorToDcm objeto;
        while (!cursor.isAfterLast()) {
            objeto = getRow(cursor);
            lo.add(objeto);
            cursor.moveToNext();
        }
        cursor.close();
        return lo;
    }

    public ArrayList<AnchorToDcm> select() {
        ArrayList<AnchorToDcm> lo = new ArrayList<AnchorToDcm>();
        Cursor cursor = bd.query(Contrato.TablaHilos.TABLA, null, null, null, null, null, null);
        cursor.moveToFirst();
        AnchorToDcm objeto;
        while (!cursor.isAfterLast()) {
            objeto = getRow(cursor);
            lo.add(objeto);
            cursor.moveToNext();
        }
        cursor.close();
        return lo;
    }

    public static AnchorToDcm getRow(Cursor c) {
        AnchorToDcm objeto = new AnchorToDcm();
        objeto.setAnchor(c.getString(1));
        objeto.setDcm(c.getString(2));
        return objeto;
    }

    /*
    public Jugador getRow(long id) {
        String[] proyeccion = { Contrato.TablaJugador._ID,
                Contrato.TablaJugador.NOMBRE,
                Contrato.TablaJugador.TELEFONO,
                Contrato.TablaJugador.VALORACION,
                Contrato.TablaJugador.FNAC};
        String where = Contrato.TablaJugador._ID + " = ?";
        String[] parametros = new String[] { id+"" };
        String groupby = null;
        String having = null;
        String orderby = Contrato.TablaJugador.NOMBRE + " ASC";
        Cursor c = bd.query(Contrato.TablaJugador.TABLA, proyeccion,
                where, parametros, groupby, having, orderby);
        c.moveToFirst();
        Jugador objeto = getRow(c);
        c.close();
        return objeto;
    }
    */



    public Cursor getCursor(String condicion, String[] parametros, String orden) {
        Cursor cursor = bd.query(Contrato.TablaHilos.TABLA, null, condicion, parametros, null, null, orden);
        return cursor;
    }

    public Cursor getCursor() {
        Cursor cursor = bd.query(Contrato.TablaHilos.TABLA, null, null, null, null, null, null);
        return cursor;
    }

    public AnchorToDcm getRow(String nombre) {
        String[] parametros = new String[] { nombre };
        Cursor c = bd.rawQuery("select * from "+
                Contrato.TablaHilos.TABLA
                + " where " + Contrato.TablaHilos.ANCHOR + " = ?", parametros);
        c.moveToFirst();
        AnchorToDcm objeto = getRow(c);
        c.close();
        return objeto;
    }

    public AnchorToDcm getRow2(String nombre) {
        String[] parametros = new String[] { nombre };
        Cursor c = bd.rawQuery("select * from "+
                Contrato.TablaHilos.TABLA
                + " where " + Contrato.TablaHilos.DMC + " = ?", parametros);
        c.moveToFirst();
        AnchorToDcm objeto = getRow(c);
        c.close();
        return objeto;
    }

}
