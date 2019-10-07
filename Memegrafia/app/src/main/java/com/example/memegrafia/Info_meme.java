package com.example.memegrafia;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Info_meme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_info_meme);
        int index = getIntent().getIntExtra(MainActivity.clave,-1);
        Info_Fragment inf = new Info_Fragment();
        inf.setIndex(index);
        getSupportFragmentManager()
                .beginTransaction().replace (R.id.containerInfo, inf)
                .commit ();
    }
}