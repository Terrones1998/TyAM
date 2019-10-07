package com.example.memegrafia;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ListadoAdapter extends RecyclerView.Adapter<ListadoViewHolder> {
    private Context context;
    private String[] myData;
    private TypedArray imagenes;
    MemeTouchListener listener;

    ListadoAdapter (Context context, String[] myData,TypedArray imagenes, MemeTouchListener listener) {
        this.context = context;
        this.myData = myData;
        this.imagenes = imagenes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListadoViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i) {
        View rowView = LayoutInflater.from (context).inflate (R.layout.fragment_item, viewGroup, false);
        return new ListadoViewHolder (rowView);
    }

    @Override
    public void onBindViewHolder (@NonNull ListadoViewHolder listadoViewHolder, int i) {
        listadoViewHolder.bind (myData[i],imagenes.getResourceId(i,-1));
        listadoViewHolder.itemView.setOnClickListener((view)->{
            if(listener != null) listener.onMemeTouched(i);
        });
    }

    @Override
    public int getItemCount () {
        return myData.length;
    }

}

class ListadoViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    private ImageView imageView;

    ListadoViewHolder (@NonNull View itemView) {
        super (itemView);
        imageView = itemView.findViewById(R.id.imagen);
        textView = itemView.findViewById (R.id.textoImagen);
    }

    public void bind (String text, int imagen) {
        textView.setText (text);
        imageView.setImageResource(imagen);
    }
}