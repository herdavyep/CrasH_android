package com.example.heriberto.crash.Adaptadores;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Productos;
import com.example.heriberto.crash.vistas.CrearProductoActivity;
import com.example.heriberto.crash.vistas.ProductosAdminActivity;
import com.example.heriberto.crash.vistas.verProductos;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.heriberto.crash.R.id.cancel;
import static com.example.heriberto.crash.R.id.imagenProducto;
import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by heriberto on 30/04/17.
 */

public class AdapterVerProductos extends RecyclerView.Adapter<AdapterVerProductos.ViewHolder> {
    private ArrayList<Productos> mmDataset;
    private Context context;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombreProducto;
        TextView presentacion;
        TextView precio;
        TextView cantidadPorCliente;
        TextView productosDisponibles;
        TextView porcentajeDescuento;
        ImageView imagenProducto;

        ViewHolder(View v) {
            super(v);

            nombreProducto = (TextView) v.findViewById(R.id.nombreVerProducto);
            presentacion = (TextView) v.findViewById(R.id.presentacionVerProducto);
            precio = (TextView) v.findViewById(R.id.precioVerProducto);
            cantidadPorCliente = (TextView) v.findViewById(R.id.cantidadPorCliente);
            productosDisponibles = (TextView) v.findViewById(R.id.productosVerDisponibles);

            imagenProducto = (ImageView) v.findViewById(R.id.imagenVerProducto);


        }
    }

    public AdapterVerProductos(ArrayList<Productos> mmyDataset, Context context) {

        this.context = context;
        this.mmDataset = mmyDataset;
    }

    @Override
    public AdapterVerProductos.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_ver_productos, parent, false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterVerProductos.ViewHolder holder, int position) {

        holder.nombreProducto.setText(mmDataset.get(position).getNombre());
        holder.presentacion.setText(mmDataset.get(position).getPresentacion());

        String numero = (mmDataset.get(position).getPrecio());

        if (numero.equals("")){

            holder.precio.setText (mmDataset.get(position).getPorcentaje_descuento()+"%");


        }else{

            holder.precio.setText ("$ "+mmDataset.get(position).getPrecio());

        }


        holder.cantidadPorCliente.setText("max "+mmDataset.get(position).getUnidadesxcliente()+" x cliente");
        holder.productosDisponibles.setText("Unid Disp. "+mmDataset.get(position).getProductos_disponibles());
       // holder.imagenProducto.setImageURI(Uri.parse(mmDataset.get(position).getImagen()));

        Picasso.with(context)
                .load(mmDataset.get(position).getImagen())
                .into(holder.imagenProducto);

    }

    @Override
    public int getItemCount() {

        return mmDataset.size();
    }

    public static boolean validar(String validar){

        return (validar.equals(""))? true:false;
    }
}

