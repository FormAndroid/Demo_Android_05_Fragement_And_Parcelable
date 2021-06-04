package be.bxl.formation.demo_05_fragement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;

import java.io.FileNotFoundException;
import java.io.IOException;

import be.bxl.formation.demo_05_fragement.models.DevTechnology;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DevTechnology js = new DevTechnology(
                1,
                "JavaScript",
                null,
                DevTechnology.TechnoEnum.LANGUAGE,
                R.raw.logo_js);

        Bundle bundle = new Bundle();
        bundle.putParcelable("JS", js);

        DevTechnology recup = bundle.getParcelable("JS");
    }
}