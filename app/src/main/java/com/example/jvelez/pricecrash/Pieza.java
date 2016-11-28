package com.example.jvelez.pricecrash;

/**
 * Created by Jshuin on 24/11/2016.

 */
public class Pieza {
    private String urlImagen;
    private int precioPintura;
    private int precioCompleto;
    private int precioFinal;

    public Pieza(String urlImagen, int precioPintura, int precioCompleto) {
        this.urlImagen = urlImagen;
        this.precioPintura = precioPintura;
        this.precioCompleto = precioCompleto;
        this.precioFinal=0;

    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public int getPrecioPintura() {
        return precioPintura;
    }

    public void setPrecioPintura(int precioPintura) {
        this.precioPintura = precioPintura;
    }

    public int getPrecioCompleto() {
        return precioCompleto;
    }

    public void setPrecioCompleto(int precioCompleto) {
        this.precioCompleto = precioCompleto;
    }

    public int getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(int precioFinal) {
        this.precioFinal = precioFinal;
    }

}
