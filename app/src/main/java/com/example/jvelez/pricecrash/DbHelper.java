package com.example.jvelez.pricecrash;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by jeffveleze on 11/28/16.
 */
public class DbHelper {


    public enum cars {
        CHEVROLETCOBALT("Chevrolet Cobalt SS", 0),
        HONDACIVIC("Honda Civic SI", 1),
        HYUNDAITIBURON("Hyundai Tiburón", 2),
        MITSUBISHIGALAN("Mitsubishi Galan", 3),
        TOYOTASCION("Toyota Scion tC", 4);

        private String stringValue;
        private int intValue;
        private cars(String toString, int value) {
            stringValue = toString;
            intValue = value;
        }
        @Override
        public String toString() {
            return stringValue;
        }
    }

    public enum models {
        MODELO2011("Modelo 2011", 0),
        MODELO2012("Modelo 2012", 1),
        MODELO2013("Modelo 2013", 2),
        MODELO2014("Modelo 2014", 3),
        MODELO2015("Modelo 2015", 4),
        MODELO2016("Modelo 2016", 5);

        private String stringValue;
        private int intValue;
        private models(String toString, int value) {
            stringValue = toString;
            intValue = value;
        }
        @Override
        public String toString() {
            return stringValue;
        }
    }

    public enum pieces {
        CAPO("Capó", 0),
        FAROLAD("Farola Delantera", 1),
        FAROLAT("Farola Trasera", 2),
        MALETERO("Maletero", 3),
        PARABRISAS("Parabrisas", 4),
        PARACHOQUESD("Parachoques Delantero", 5),
        PARACHOQUEST("Parachoques Trasero", 6),
        PARRILLA("Parrilla", 7),
        PUERTAD("Puerta Delantera", 8),
        PUERTAT("Puerta Trasera", 9),
        RETROVISOR("Retrovisor", 10),
        RIN("Rin", 11);

        private String stringValue;
        private int intValue;
        private pieces(String toString, int value) {
            stringValue = toString;
            intValue = value;
        }
        @Override
        public String toString() {
            return stringValue;
        }
    }

    public enum attributes {
        IMAGEN("Imagen", 0),
        PRECIOCOMPLETO("Precio Completo", 1),
        SOLOPINTURA("Precio Pintura", 2);

        private String stringValue;
        private int intValue;
        private attributes(String toString, int value) {
            stringValue = toString;
            intValue = value;
        }
        @Override
        public String toString() {
            return stringValue;
        }
    }

    final String recursos = "recursos";
    final String autos = "Autos";
    final String imagenes = "imagenes";
    private Map<String, Object> map =  new HashMap<String,Object>();
    private List<String> list = new ArrayList<String>();


    public List<String> getCarsList(){

        list.clear();
        FirebaseDatabase.getInstance().getReference().child(autos).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, Object> tempMap =  new HashMap<String,Object>();
                tempMap = (Map<String, Object>)dataSnapshot.getValue();
                Set<String> tempSet = new HashSet<String>();
                tempSet = tempMap.keySet();
                list.addAll(tempSet);
                Log.d("List",list.toString());

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return list;

    }

    public List<String> getModelsList(Object car){

        list.clear();
        FirebaseDatabase.getInstance().getReference().child(autos).child(car.toString()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, Object> tempMap =  new HashMap<String,Object>();
                tempMap = (Map<String, Object>)dataSnapshot.getValue();
                Set<String> tempSet = new HashSet<String>();
                tempSet = tempMap.keySet();
                list.addAll(tempSet);
                Log.d("List",list.toString());

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return list;
    }

    public boolean loadPiecesInfo(Object car, Object model){

        //map.clear();
        FirebaseDatabase.getInstance().getReference().child(autos).child(car.toString()).child(model.toString()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                map = (Map<String, Object>)dataSnapshot.getValue();
                Log.d("Map",map.toString());

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        if (map!=null){
            return true;
        }else {
            return false;
        }

    }

    public List<String> getPiecesNames(){

        list.clear();
        Set<String> tempSet = new HashSet<String>();
        tempSet = map.keySet();
        list.addAll(tempSet);
        Log.d("List",list.toString());

        return list;
    }

    public String getFullPriceOf(Object piece){

        String str;
        Map<String, Object> tempMap =  new HashMap<String,Object>();
        map.get(piece.toString());
        str = "as";
        //tempMap = (Map<String, Object>) map.get(pieces.CAPO.toString());
        Log.d("Fuck","Fuck");

        return str;
    }

    //dataBase.getCarsList();
    //dataBase.getModelsList(DbHelper.cars.CHEVROLETCOBALT);
    //dataBase.getPiecesNames();
    //dataBase.loadPiecesInfo(DbHelper.cars.CHEVROLETCOBALT, DbHelper.models.MODELO2011);
    //dataBase.getFullPriceOf(DbHelper.pieces.CAPO);




}
