package com.example.heriberto.crash.Adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Almacenes;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by heriberto on 9/04/17.
 */

public class AdapterVerAlmacenes extends RecyclerView.Adapter<AdapterVerAlmacenes.ViewHolder> {
    private ArrayList<Almacenes> mDataset;
    private Context context;


    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombreAlmacen;
        TextView telefonoAlmacen;
        TextView direccionAlmacen;
        TextView ciudadAlmacen;
        ImageView imagenAlmacen;
        TextView campoOculto;
        ViewHolder(View v) {
            super(v);
            nombreAlmacen = (TextView) v.findViewById(R.id.nombreAlmacen);
            telefonoAlmacen = (TextView) v.findViewById(R.id.telefonoAlmacen);
            direccionAlmacen = (TextView) v.findViewById(R.id.direccionAlmacen);
            ciudadAlmacen = (TextView) v.findViewById(R.id.ciudadAlmacen);
            imagenAlmacen = (ImageView) v.findViewById(R.id.imagenAlmacen);
            campoOculto = (TextView) v.findViewById(R.id.id_almacenOculto);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterVerAlmacenes(ArrayList<Almacenes> myDataset, Context context) {

        this.context = context;
        mDataset = myDataset;
    }

    @Override
    public AdapterVerAlmacenes.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_ver_almacenes, parent, false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.nombreAlmacen.setText(mDataset.get(position).getNombre());
        holder.telefonoAlmacen.setText(mDataset.get(position).getTelefono());
        holder.direccionAlmacen.setText(mDataset.get(position).getDireccion());
        holder.ciudadAlmacen.setText(mDataset.get(position).getCiudad());
        holder.campoOculto.setText(mDataset.get(position).getId_almacen());
        //holder.imagenAlmacen.setImageResource(mDataset.get(position).getImagenAlmacen());
        Picasso.with(context)
                .load(mDataset.get(position).getImagenAlmacen())
                .into(holder.imagenAlmacen);

    }

    @Override
    public int getItemCount() {

        return mDataset.size();
    }
}
