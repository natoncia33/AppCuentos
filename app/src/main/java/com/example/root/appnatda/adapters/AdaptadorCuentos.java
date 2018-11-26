package com.example.root.appnatda.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.appnatda.R;
import com.example.root.appnatda.clases.CuentoVo;

import java.util.ArrayList;

public class AdaptadorCuentos extends RecyclerView.Adapter<AdaptadorCuentos.CuentosViewHolder> implements View.OnClickListener{

    ArrayList<CuentoVo> listaCuentos;

    private  View.OnClickListener listener;

    public AdaptadorCuentos (ArrayList<CuentoVo>listaCuentos)
    {
        this.listaCuentos=listaCuentos;
    }


    @Override
    public CuentosViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        RecyclerView.LayoutParams layParams = new RecyclerView.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layParams);

        view.setOnClickListener(this);

        return new CuentosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CuentosViewHolder cuentosViewHolder, int position) {

        cuentosViewHolder.txtCuento.setText(listaCuentos.get(position).getCuento());
        cuentosViewHolder.txtContenido.setText(listaCuentos.get(position).getContenido());
        cuentosViewHolder.foto.setImageResource(listaCuentos.get(position).getImagenId());



    }

    @Override
    public int getItemCount()
    {

        return listaCuentos.size();
    }

    public void setOnClickListener(View.OnClickListener listener  )
    {
        this.listener=listener;

    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }

    }


    public class CuentosViewHolder extends RecyclerView.ViewHolder {



            TextView txtCuento, txtContenido;
            ImageView foto;
        public CuentosViewHolder(View itemView) {
            super(itemView);
            txtCuento= (TextView) itemView.findViewById(R.id.idCuento);
            txtContenido=(TextView) itemView.findViewById(R.id.idContenido);
            foto=(ImageView) itemView.findViewById(R.id.idImagen);


        }
    }
}
