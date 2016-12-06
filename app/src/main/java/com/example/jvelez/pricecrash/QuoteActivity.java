package com.example.jvelez.pricecrash;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuoteActivity extends AppCompatActivity {

    String[] SPINNERCASAS = {"Seleccione una vehiculo","Mazda2", "Mazda6",
            "Auris", "Verso", "Captur", "Clio"};
    String[] DEFECTO={"---"};
    String[] MODELOSMAZDA2 = {"Seleccione un modelo", "Mazda2 2011", "Mazda2 2012", "Mazda2 2013", "Mazda2 2014", "Mazda2 2015"};
    String[] MODELOSMAZDA6 = {"Seleccione un modelo", "Mazda6 2010", "Mazda6 2011", "Mazda6 2012", "Mazda6 2013"};
    String[] MODELOSAURIS = {"Seleccione un modelo", "Auris 2011", "Auris 2012", "Auris 2013", "Auris 2014"};
    String[] MODELOSVERSO = {"Seleccione un modelo", "Verso 2009", "Verso 2010", "Verso 2011", "Verso 2012", "Verso 2013", "Verso 2014", "Verso 2015"};
    String[] MODELOSCAPTUR = {"Seleccione un modelo", "Captur 2011", "Captur 2012", "Captur 2013", "Captur 2014", "Captur 2015"};
    String[] MODELOSCLIO = {"Seleccione un modelo", "Clio 2010", "Clio 2011", "Clio 2012", "Clio 2013", "Clio 2014", "Clio 2015"};

    private RecyclerView recyclerView;
    private static ArrayList<Pieza>listapiezas= new ArrayList<>();
    private PiezaAdapter adapter;
    private boolean dbSyncronized = false;

    static TextView titulo,valorTotal;
    private Spinner carro, modelos;
    ArrayAdapter<String> arrayAdapterCarros,arrayAdapterModelos;

    DbHelper dataBase = new DbHelper();
    private Map<String, Object> map =  new HashMap<String,Object>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dataBase.configurePersistence();
        dataBase.syncCarsData();

        titulo = (TextView) findViewById(R.id.titulo);
        valorTotal = (TextView) findViewById(R.id.valorTotal);

        carro = (Spinner)findViewById(R.id.Carros);
        modelos = (Spinner)findViewById(R.id.Modelos);

        if (!dbSyncronized){
            arrayAdapterCarros = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,DEFECTO);
            arrayAdapterModelos = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,DEFECTO);
            carro.setAdapter(arrayAdapterCarros);
            modelos.setAdapter(arrayAdapterModelos);
        }

        carro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String firstItem = String.valueOf(carro.getSelectedItem());
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                manageProgressDialog();
                valorTotal.setText("$: "+String.format("%,d",0));

                if (firstItem.equals(String.valueOf(carro.getSelectedItem()))) {
                    // ToDo when first item is selected
                    modelos.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,DEFECTO));
                } else {
                    // Todo when item is selected by the user
                    String carroSelected=carro.getSelectedItem().toString();
                    mostrarModelos(carroSelected);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        modelos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String firstItem = String.valueOf(modelos.getSelectedItem());
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                manageProgressDialog();
                valorTotal.setText("$: "+String.format("%,d",0));

                if (firstItem.equals(String.valueOf(carro.getSelectedItem()))) {
                    // ToDo when first item is selected

                } else {
                    // Todo when item is selected by the user
                    mostrarInformacion(carro.getSelectedItem().toString(),modelos.getSelectedItem().toString());

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        //EventBus myEventBus = EventBus.getDefault();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void mostrarModelos(String carroSelected) {

        arrayAdapterModelos = new ArrayAdapter<String>(QuoteActivity.this,android.R.layout.simple_dropdown_item_1line,dataBase.getModelsList(carro.getSelectedItem()));
        modelos.setAdapter(arrayAdapterModelos);

        //Toast.makeText(this,"metodo mostrar modelos",Toast.LENGTH_SHORT).show();
    }

    public static void calcularValorFinal(){
        int valorf=0;
        for(int i=0;i<listapiezas.size();i++){
            valorf+=listapiezas.get(i).getPrecioFinal();
        }
        valorTotal.setText("$ "+String.format("%,d",valorf));
    }

    public void mostrarInformacion(String carroselected,String modeloselected) {
        recyclerView=(RecyclerView)findViewById(R.id.listasPartes);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(true);
        adapter=new PiezaAdapter(this,listapiezas);
        recyclerView.setAdapter(adapter);
        listapiezas.clear();
        List<String> piezas= dataBase.getPiecesNames(carro.getSelectedItem(),modelos.getSelectedItem());


        for(int i=0;i<piezas.size();i++){
            //String urlimage="http://www.orionlujosysonido.com/images/rines/rin3.jpg";
            String urlimage=dataBase.getAttributeFor(carro.getSelectedItem(),modelos.getSelectedItem(),piezas.get(i),DbHelper.attributes.IMAGEN);
            String nombre = ""+piezas.get(i);
            int precioPintura=Integer.parseInt(dataBase.getAttributeFor(carro.getSelectedItem(),modelos.getSelectedItem(),piezas.get(i),DbHelper.attributes.SOLOPINTURA));
            int precioCompleto=Integer.parseInt(dataBase.getAttributeFor(carro.getSelectedItem(),modelos.getSelectedItem(),piezas.get(i),DbHelper.attributes.PRECIOCOMPLETO));
            listapiezas.add(new Pieza(urlimage,nombre,precioPintura,precioCompleto));
        }
        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quote, menu);
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

            manageProgressDialog();
            saveLoggedStatus();
            finish();
            Intent intent = new Intent(QuoteActivity.this,Login.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void manageProgressDialog() {

        final ProgressDialog progressDialog = new ProgressDialog(QuoteActivity.this,
                R.style.Custom_Progress_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Cargando...");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        progressDialog.dismiss();
                    }
                }, 1500);

    }

    private void saveLoggedStatus() {

        SharedPreferences sharedPreference = getSharedPreferences("infoapp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString("logged", "false");
        editor.commit();

    }

    @Subscribe
    public void onEvent(String dataSyncronized){

        if (!dbSyncronized){
            dbSyncronized = true;

            arrayAdapterCarros = new ArrayAdapter<String>(QuoteActivity.this,android.R.layout.simple_dropdown_item_1line,dataBase.getCarsList());
            carro.setAdapter(arrayAdapterCarros);
            arrayAdapterModelos = new ArrayAdapter<String>(QuoteActivity.this,android.R.layout.simple_dropdown_item_1line,dataBase.getModelsList(carro.getSelectedItem()));
            modelos.setAdapter(arrayAdapterModelos);

        }

    }

}
