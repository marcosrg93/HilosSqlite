package com.rubinogarcia.xml.hilossqlite;

    import android.provider.BaseColumns;

    public class Contrato{

        private Contrato (){
        }

        public static abstract  class TablaHilos implements BaseColumns{
            public static final String TABLA = "anchortodmc";
            public static final String ANCHOR = "anchor";
            public static final String DMC = "dmc";
        }

    }

