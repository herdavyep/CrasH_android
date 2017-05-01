package com.example.heriberto.crash.Adaptadores;

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
 * Created by heriberto on 30/04/17.
 */

public class AdapterVerProductos extends RecyclerView.Adapter<AdapterVerProductos.ViewHolder> {
    private ArrayList<Productos> mmDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    // Proporciona una referencia a las vistas de cada elemento de datos
    // Los elementos de datos complejos pueden necesitar más de una vista por elemento y
    // proporciona acceso a todas las vistas de un elemento de datos en un titular de vista
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView nombreProducto;
        TextView presentacion;
        TextView precio;
        TextView vencimientoOferta;
        TextView productosDisponibles;
        TextView porcentajeDescuento;
        ImageView imagenProducto;

        ViewHolder(View v) {
            super(v);

            nombreProducto = (TextView) v.findViewById(R.id.nombreVerProducto);
            presentacion = (TextView) v.findViewById(R.id.presentacionVerProducto);
            precio = (TextView) v.findViewById(R.id.precioVerProducto);
            vencimientoOferta = (TextView) v.findViewById(R.id.vencimientoVerOferta);
            productosDisponibles = (TextView) v.findViewById(R.id.productosVerDisponibles);
            porcentajeDescuento = (TextView) v.findViewById(R.id.porcentajeVerDescuento);
            imagenProducto = (ImageView) v.findViewById(R.id.imagenVerProducto);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterVerProductos(ArrayList<Productos> mmyDataset) {

        mmDataset = mmyDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterVerProductos.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_ver_productos, parent, false);
        // set the view's size, margins, paddings and layout parameters


        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(AdapterVerProductos.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nombreProducto.setText(mmDataset.get(position).getNombre());
        holder.presentacion.setText(mmDataset.get(position).getPresentacion());
        holder.precio.setText (mmDataset.get(position).getPrecio()+" pesos");
        holder.vencimientoOferta.setText("Oferta vence en: "+mmDataset.get(position).getVencimiento_oferta()+" dias");
        holder.productosDisponibles.setText(mmDataset.get(position).getProductos_disponibles());
        holder.porcentajeDescuento.setText(mmDataset.get(position).getPorcentaje_descuento()+"%");
        holder.imagenProducto.setImageResource(mmDataset.get(position).getImagenProducto());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return mmDataset.size();
    }
}

