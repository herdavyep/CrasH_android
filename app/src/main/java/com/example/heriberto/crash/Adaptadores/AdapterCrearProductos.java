package com.example.heriberto.crash.Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Productos;

import java.util.ArrayList;

/**
 * Created by heriberto on 11/04/17.
 */

public class AdapterCrearProductos extends RecyclerView.Adapter<AdapterCrearProductos.ViewHolder> {
    private ArrayList<Productos> mDataset;

    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        EditText nombreproducto;
        EditText precioProducto;
        EditText presentacionProducto;
        EditText vencimientoOferta;
        EditText productosDisponibles;
        EditText idAlmacen;
        EditText porcentajeDescuento;
        ImageView imagenProducto;

        ViewHolder(View v) {
            super(v);
            nombreproducto = (EditText) v.findViewById(R.id.nombreProducto);
            precioProducto = (EditText) v.findViewById(R.id.precioProducto);
            presentacionProducto = (EditText) v.findViewById(R.id.presentacionProducto);
            vencimientoOferta = (EditText) v.findViewById(R.id.vencimientoOferta);
            productosDisponibles = (EditText) v.findViewById(R.id.productosDisponibles);
            idAlmacen = (EditText) v.findViewById(R.id.idAlmacen);
            porcentajeDescuento = (EditText) v.findViewById(R.id.porcentajeDescuento);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterCrearProductos(ArrayList<Productos> myDataset) {

        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterCrearProductos.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_crear_producto, parent, false);
        // set the view's size, margins, paddings and layout parameters


        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nombreproducto.setText(mDataset.get(position).getNombre());
        holder.precioProducto.setText((int) mDataset.get(position).getPrecio());
        holder.presentacionProducto.setText(mDataset.get(position).getPresentacion());
        holder.productosDisponibles.setText(mDataset.get(position).getProductos_disponibles());
        holder.vencimientoOferta.setText(mDataset.get(position).getVencimiento_oferta());
        holder.porcentajeDescuento.setText(mDataset.get(position).getPorcentaje_descuento());
        holder.idAlmacen.setText(mDataset.get(position).getId_producto());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return mDataset.size();
    }
}
