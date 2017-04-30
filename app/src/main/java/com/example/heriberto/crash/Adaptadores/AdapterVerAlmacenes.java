package com.example.heriberto.crash.Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Almacenes;

import java.util.ArrayList;

/**
 * Created by heriberto on 9/04/17.
 */

public class AdapterVerAlmacenes extends RecyclerView.Adapter<AdapterVerAlmacenes.ViewHolder> {
    private ArrayList<Almacenes> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    // Proporciona una referencia a las vistas de cada elemento de datos
    // Los elementos de datos complejos pueden necesitar más de una vista por elemento y
    // proporciona acceso a todas las vistas de un elemento de datos en un titular de vista
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView nombreAlmacen;
        TextView telefonoAlmacen;
        TextView direccionAlmacen;
        TextView ciudadAlmacen;
        ImageView imagenAlmacen;
        ViewHolder(View v) {
            super(v);
            nombreAlmacen = (TextView) v.findViewById(R.id.nombreAlmacen);
            telefonoAlmacen = (TextView) v.findViewById(R.id.telefonoAlmacen);
            direccionAlmacen = (TextView) v.findViewById(R.id.direccionAlmacen);
            ciudadAlmacen = (TextView) v.findViewById(R.id.ciudadAlmacen);
            imagenAlmacen = (ImageView) v.findViewById(R.id.imagenAlmacen);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterVerAlmacenes(ArrayList<Almacenes> myDataset) {

        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterVerAlmacenes.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_ver_almacenes, parent, false);
        // set the view's size, margins, paddings and layout parameters


        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nombreAlmacen.setText(mDataset.get(position).getNombre());
        holder.telefonoAlmacen.setText(mDataset.get(position).getTelefono());
        holder.direccionAlmacen.setText(mDataset.get(position).getDireccion());
        holder.ciudadAlmacen.setText(mDataset.get(position).getCiudad());
        holder.imagenAlmacen.setImageResource(mDataset.get(position).getImagenAlmacen());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return mDataset.size();
    }
}
