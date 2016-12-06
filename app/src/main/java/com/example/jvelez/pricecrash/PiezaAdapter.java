package com.example.jvelez.pricecrash;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Jshuin on 24/11/2016.
 */
public class PiezaAdapter extends RecyclerView.Adapter<PiezaAdapter.Myvistaholder> {

    private Context context;
    private ArrayList<Pieza>listapiezas;

    public PiezaAdapter(Context context, ArrayList<Pieza> piezas) {
        this.context = context;
        this.listapiezas = piezas;
    }

    @Override
    public Myvistaholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Myvistaholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_desing,null));
    }

    @Override
    public void onBindViewHolder(Myvistaholder holder, final int position) {

        holder.botonSoloPintura.setText("Pintura: $ "+String.format("%,d",listapiezas.get(position).getPrecioPintura()));
        holder.botonPrecioCompleto.setText("Completo: $ "+String.format("%,d",listapiezas.get(position).getPrecioCompleto()));
        holder.nombrePieza.setText(listapiezas.get(position).getNombre());
        Glide.with(context).load(listapiezas.get(position).getUrlImagen()).into(holder.imagenPieza);


        holder.botonNoAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listapiezas.get(position).setPrecioFinal(0);
                QuoteActivity.calcularValorFinal();
            }
        });

        holder.botonSoloPintura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listapiezas.get(position).setPrecioFinal(listapiezas.get(position).getPrecioPintura());
                QuoteActivity.calcularValorFinal();
            }
        });

        holder.botonPrecioCompleto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listapiezas.get(position).setPrecioFinal(listapiezas.get(position).getPrecioCompleto());
                QuoteActivity.calcularValorFinal();
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return listapiezas.size();
    }

    public class Myvistaholder extends RecyclerView.ViewHolder{

        ImageView imagenPieza;
        TextView nombrePieza;
        RadioGroup seleccionPrecio;
        RadioButton botonNoAgregar, botonSoloPintura, botonPrecioCompleto;
        public Myvistaholder(View itemView) {
            super(itemView);
            imagenPieza=(ImageView)itemView.findViewById(R.id.imagenPieza);
            nombrePieza = (TextView)itemView.findViewById(R.id.nombrePieza);
            seleccionPrecio = (RadioGroup)itemView.findViewById(R.id.seleccionPrecio);
            botonNoAgregar = (RadioButton)itemView.findViewById(R.id.sinPrecio);
            botonSoloPintura = (RadioButton)itemView.findViewById(R.id.soloPintura);
            botonPrecioCompleto = (RadioButton)itemView.findViewById(R.id.precioCompleto);

        }
    }
}
