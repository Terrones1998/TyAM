package com.example.memegrafia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.memegrafia.Info_meme;
import com.example.memegrafia.ListadoFragment;
import com.example.memegrafia.R;

public class MainActivity extends AppCompatActivity {
    public final static String clave = "claveMemeInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListadoFragment f = new ListadoFragment();
        f.setMemeTouchListener((index) -> {
            LinearLayout layout = findViewById(R.id.rvListado);
            if (layout != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containerInfo, new ListadoFragment())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
//        getSupportFragmentManager()
//                .beginTransaction().replace (R.id.container, f)
//                .commit ();

            }
        });

    }
}
