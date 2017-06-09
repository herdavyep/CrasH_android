package com.example.heriberto.crash.Adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Promociones;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by heriberto on 8/06/17.
 */

public class AdapterVerPromo extends RecyclerView.Adapter<AdapterVerPromo.ViewHolder> {
    private ArrayList<Promociones> mDataset;
    private Context context;


    static class ViewHolder extends RecyclerView.ViewHolder {


        ImageView imagenAlmacen;
        TextView campoOculto;
        ViewHolder(View v) {
            super(v);

            imagenAlmacen = (ImageView) v.findViewById(R.id.imagenPromoVer);
            campoOculto = (TextView) v.findViewById(R.id.id_almacenOcultoPromo);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterVerPromo(ArrayList<Promociones> myDataset, Context context) {

        this.context = context;
        mDataset = myDataset;
    }

    @Override
    public AdapterVerPromo.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {

        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_ver_promo, parent, false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //holder.imagenAlmacen.setImageResource(mDataset.get(position).getImagenAlmacen());
        holder.campoOculto.setText(mDataset.get(position).getId_almacen());
        Picasso.with(context)
                .load(mDataset.get(position).getImagen())
                .into(holder.imagenAlmacen);

    }

    @Override
    public int getItemCount() {

        return mDataset.size();
    }

}
