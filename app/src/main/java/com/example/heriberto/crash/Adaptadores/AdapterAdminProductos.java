package com.example.heriberto.crash.Adaptadores;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Productos;

import java.util.ArrayList;

/**
 * Created by heriberto on 6/05/17.
 */

public class AdapterAdminProductos extends RecyclerView.Adapter<AdapterAdminProductos.ViewHolder> {
    private ArrayList<Productos> mmDataset;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombreProducto;
        TextView presentacion;
        TextView precio;
        TextView vencimientoOferta;
        TextView productosDisponibles;
        TextView porcentajeDescuento;
        ImageView imagenProducto;

        ViewHolder(View v) {
            super(v);

            nombreProducto = (TextView) v.findViewById(R.id.nombreAdminProducto);
            presentacion = (TextView) v.findViewById(R.id.presentacionAdminProducto);
            precio = (TextView) v.findViewById(R.id.precioAdminProducto);
            vencimientoOferta = (TextView) v.findViewById(R.id.vencimientoAdminOferta);
            productosDisponibles = (TextView) v.findViewById(R.id.productosAdminDisponibles);
            porcentajeDescuento = (TextView) v.findViewById(R.id.porcentajeAdminDescuento);
            imagenProducto = (ImageView) v.findViewById(R.id.imagenAdminProducto);
        }
    }

    public AdapterAdminProductos(ArrayList<Productos> mmyDataset) {

        mmDataset = mmyDataset;
    }

    @Override
    public AdapterAdminProductos.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {

        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_productos_admin, parent, false);


        return new AdapterAdminProductos.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterAdminProductos.ViewHolder holder, int position) {

        holder.nombreProducto.setText(mmDataset.get(position).getNombre());
        holder.presentacion.setText(mmDataset.get(position).getPresentacion());
        holder.precio.setText (mmDataset.get(position).getPrecio()+" pesos");
        holder.vencimientoOferta.setText("Oferta vence en: "+mmDataset.get(position).getVencimiento_oferta()+" dias");
        holder.productosDisponibles.setText(mmDataset.get(position).getImagen());
        holder.porcentajeDescuento.setText(mmDataset.get(position).getPorcentaje_descuento()+"%");
        holder.imagenProducto.setImageURI(Uri.parse(mmDataset.get(position).getImagen()));

    }

    @Override
    public int getItemCount() {

        return mmDataset.size();
    }


}
