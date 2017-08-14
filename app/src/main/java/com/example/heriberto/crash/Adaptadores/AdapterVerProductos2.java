package com.example.heriberto.crash.Adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Productos;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by heriberto on 13/06/17.
 */

public class AdapterVerProductos2 extends RecyclerView.Adapter<AdapterVerProductos2.ViewHolder> {
    private ArrayList<Productos> mmDataset;
    private Context context;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombreProducto;
        TextView presentacion;
        TextView precio;
        TextView productosDisponibles;
        TextView porcentajeDescuento;
        ImageView imagenProducto;

        ViewHolder(View v) {
            super(v);

            nombreProducto = (TextView) v.findViewById(R.id.nombreVerProducto2);
            presentacion = (TextView) v.findViewById(R.id.presentacionVerProducto2);
            precio = (TextView) v.findViewById(R.id.precioVerProducto2);
            productosDisponibles = (TextView) v.findViewById(R.id.productosVerDisponibles2);
            porcentajeDescuento = (TextView) v.findViewById(R.id.porcentajeVerDescuento2);
            imagenProducto = (ImageView) v.findViewById(R.id.imagenVerProducto2);

        }
    }

    public AdapterVerProductos2(ArrayList<Productos> mmyDataset, Context context) {

        this.context = context;
        this.mmDataset = mmyDataset;
    }

    @Override
    public AdapterVerProductos2.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_ver_productos2, parent, false);
        // set the view's size, margins, paddings and layout parameters


        return new AdapterVerProductos2.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterVerProductos2.ViewHolder holder, int position) {

        holder.nombreProducto.setText(mmDataset.get(position).getNombre());
        holder.presentacion.setText(mmDataset.get(position).getPresentacion());
        holder.precio.setText (mmDataset.get(position).getPrecio()+" pesos");
        holder.productosDisponibles.setText(mmDataset.get(position).getProductos_disponibles());
        holder.porcentajeDescuento.setText("-"+mmDataset.get(position).getPorcentaje_descuento()+"%");
        // holder.imagenProducto.setImageURI(Uri.parse(mmDataset.get(position).getImagen()));
        Picasso.with(context)
                .load(mmDataset.get(position).getImagen())
                .into(holder.imagenProducto);

    }

    @Override
    public int getItemCount() {

        return mmDataset.size();
    }
}
