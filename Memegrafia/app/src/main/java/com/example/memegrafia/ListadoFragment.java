package com.example.memegrafia;

import android.content.Context;
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
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListadoFragment extends Fragment {
    MemeTouchListener listener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_listado, container, false);
    }
    public void setMemeTouchListener(MemeTouchListener l){
        listener = l;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentActivity activity = getActivity ();
        if (activity == null) return;

        RecyclerView recyclerView = activity.findViewById (R.id.rvListado);
        if (recyclerView == null) return;

        String[] texto = getResources().getStringArray(R.array.names);
        TypedArray imagenes = getResources().obtainTypedArray(R.array.images);


        recyclerView.setLayoutManager (new GridLayoutManager(getContext (),2, GridLayoutManager.VERTICAL,false));
        recyclerView.setAdapter (new  ListadoAdapter (getContext (), texto,imagenes,listener));
    }
}

