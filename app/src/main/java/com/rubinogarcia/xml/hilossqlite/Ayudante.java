package com.rubinogarcia.xml.hilossqlite;


    import android.content.Context;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;
    import android.util.Log;

    public class Ayudante extends SQLiteOpenHelper {
        public static final String DATABASE_NAME = "conversor.sqlite";
        public static final int DATABASE_VERSION = 1;

        public Ayudante(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql;


            sql = "create table " + Contrato.TablaHilos.TABLA + " (" +
                    Contrato.TablaHilos.ANCHOR + " text, " +
                    Contrato.TablaHilos.DMC + " text " +
                    ")";

            Log.v("Crea tabla de BD", sql);
            db.execSQL(sql);

            String sql1 = "INSERT INTO \"anchortodmc\" VALUES('1','5200');" +
                    "INSERT INTO \"anchortodmc\" VALUES('2','Blanc');" +
                    "INSERT INTO \"anchortodmc\" VALUES('6','353');" +
                    "INSERT INTO \"anchortodmc\" VALUES('8','3824');" +
                    "INSERT INTO \"anchortodmc\" VALUES('52','899');" +
                    "INSERT INTO \"anchortodmc\" VALUES('54','956');" +
                    "INSERT INTO \"anchortodmc\" VALUES('55','604');";

            Log.v("Insert", sql1);
            db.execSQL(sql1);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
            String sql;


            sql = "create table " + Contrato.TablaHilos.TABLA + " (" +
                    Contrato.TablaHilos.ANCHOR + " integer, " +
                    Contrato.TablaHilos.DMC + " text " +
                    ")";



            //Se elimina la version anterior de la tabla
            db.execSQL("DROP TABLE IF EXISTS anchortodcm");

            //Se crea la nueva version de la tabla
            db.execSQL(sql);
        }

    }//Ayudante

