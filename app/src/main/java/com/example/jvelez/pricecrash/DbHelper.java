package com.example.jvelez.pricecrash;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.greenrobot.eventbus.EventBus;

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

    final String autos = "Autos";
    public static boolean calledAlready = false;
    private Map<String, Object> map =  new HashMap<String,Object>();


    public void configurePersistence(){
        if (!calledAlready){
            calledAlready=true;
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
    }

    public Map<String,Object> syncCarsData(){

        map.clear();
        FirebaseDatabase.getInstance().getReference().child(autos).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                map = (Map<String, Object>)dataSnapshot.getValue();
                Log.d("Map",map.toString());
                EventBus.getDefault().post(dataBaseSyncronized());

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return map;
    }

    public String dataBaseSyncronized(){

        String dataSyncronized = "true";
        return dataSyncronized;
    }


    public List<String> getCarsList(){

        Set<String> tempSet = new HashSet<String>();
        tempSet = map.keySet();
        List<String> lista = new ArrayList<String>();
        lista.addAll(tempSet);
        Log.d("List",lista.toString());

        return lista;
    }

    public List<String> getModelsList(Object car){

        Map<String, Object> tempMap =  new HashMap<String,Object>();
        tempMap = (Map<String, Object>) map.get(car.toString());
        Set<String> tempSet = new HashSet<String>();
        tempSet = tempMap.keySet();
        List<String> lista = new ArrayList<String>();
        lista.addAll(tempSet);
        Log.d("List",lista.toString());

        return lista;
    }

    public List<String> getPiecesNames(Object car, Object model){

        List<String> lista = new ArrayList<String>();
        Map<String, Object> tempMap1 =  new HashMap<String,Object>();
        Map<String, Object> tempMap2 =  new HashMap<String,Object>();
        tempMap1 = (Map<String, Object>) map.get(car.toString());
        tempMap2 = (Map<String, Object>) tempMap1.get(model.toString());

        Set<String> tempSet = new HashSet<String>();
        tempSet = tempMap2.keySet();
        lista.addAll(tempSet);
        Log.d("List",lista.toString());

        return lista;
    }

    public String getAttributeFor(Object car, Object model, Object piece, Object attribute){

        String str = "";
        Map<String, Object> tempMap1 =  new HashMap<String,Object>();
        Map<String, Object> tempMap2 =  new HashMap<String,Object>();
        Map<String, Object> tempMap3 =  new HashMap<String,Object>();
        tempMap1 = (Map<String, Object>) map.get(car.toString());
        tempMap2 = (Map<String, Object>) tempMap1.get(model.toString());
        tempMap3 = (Map<String, Object>) tempMap2.get(piece.toString());

        str = tempMap3.get(attribute.toString()).toString();
        Log.d("List",str.toString());

        return str;
    }


}

//dataBase.configurePersistence();
//dataBase.syncCarsData();

//dataBase.getCarsList();
//dataBase.getModelsList(DbHelper.cars.CHEVROLETCOBALT);
//dataBase.getPiecesNames(DbHelper.cars.CHEVROLETCOBALT,DbHelper.models.MODELO2011);
//dataBase.getAttributeFor(DbHelper.cars.HYUNDAITIBURON,DbHelper.models.MODELO2013,DbHelper.pieces.MALETERO,DbHelper.attributes.SOLOPINTURA);