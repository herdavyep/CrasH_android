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
 * Created by heriberto on 29/05/17.
 */

public class AdapterAdminAlmacenes extends RecyclerView.Adapter<AdapterAdminAlmacenes.ViewHolder> {
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
            nombreAlmacen = (TextView) v.findViewById(R.id.nombreAlmacenAdmin);
            telefonoAlmacen = (TextView) v.findViewById(R.id.telefonoAlmacenAdmin);
            direccionAlmacen = (TextView) v.findViewById(R.id.direccionAlmacenAdmin);
            ciudadAlmacen = (TextView) v.findViewById(R.id.ciudadAlmacenAdmin);
            imagenAlmacen = (ImageView) v.findViewById(R.id.imagenAlmacenAdmin);
            campoOculto = (TextView) v.findViewById(R.id.id_almacenOcultoAdmin);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterAdminAlmacenes(ArrayList<Almacenes> myDataset, Context context) {

        this.context = context;
        mDataset = myDataset;
    }

    @Override
    public AdapterAdminAlmacenes.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {

        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_almacenes_admin, parent, false);


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
