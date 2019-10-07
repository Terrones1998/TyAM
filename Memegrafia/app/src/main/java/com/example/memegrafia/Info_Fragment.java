package com.example.memegrafia;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Info_Fragment extends Fragment {
    private int index;
    public void setIndex(int index){
        this.index = index;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate (R.layout.fragment_info_item, container, false);
        InfoViewHolder ivh = new InfoViewHolder(view);
        String[] texto = getResources().getStringArray(R.array.names);
        String[] descripciones = getResources().getStringArray(R.array.descriptions);
        String[] urls = getResources().getStringArray(R.array.urls);
        TypedArray imagenes = getResources().obtainTypedArray(R.array.images);
        ivh.bind(texto[index],imagenes.getResourceId(index,-1),descripciones[index],urls[index]);
        return view;
    }
    class InfoViewHolder{
        private TextView titulo;
        private ImageView imageView;
        private TextView descripcion;
        private TextView url;

        InfoViewHolder (@NonNull View itemView) {
            titulo = itemView.findViewById (R.id.titulo);
            imageView = itemView.findViewById(R.id.imagenInfo);
            descripcion = itemView.findViewById(R.id.descripcion);
            url = itemView.findViewById(R.id.url);
        }

        public void bind (String text, int imagen,String des, String url) {
            titulo.setText (text);
            imageView.setImageResource(imagen);
            descripcion.setText(des);
            this.url.setText(url);

        }
    }
}
