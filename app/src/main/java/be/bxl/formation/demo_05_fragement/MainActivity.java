package be.bxl.formation.demo_05_fragement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.ArrayList;

import be.bxl.formation.demo_05_fragement.fragements.DevDetailFragment;
import be.bxl.formation.demo_05_fragement.fragements.DevListFragment;
import be.bxl.formation.demo_05_fragement.models.DevTechnology;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region Demo du Pacelable
//        DevTechnology js = new DevTechnology(
//                1,
//                "JavaScript",
//                null,
//                DevTechnology.TechnoEnum.LANGUAGE,
//                R.raw.logo_js);
//
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("JS", js);
//
//        DevTechnology recup = bundle.getParcelable("JS");
        //endregion

        // Création des données (WebAPI, Database, ...)
        ArrayList<DevTechnology> technologies = new ArrayList<>();
        technologies.add(new DevTechnology(1, "Android", null, DevTechnology.TechnoEnum.PLATEFORM, R.raw.logo_android));
        technologies.add(new DevTechnology(2, "React", null, DevTechnology.TechnoEnum.LIBRARY, R.raw.logo_react));
        technologies.add(new DevTechnology(3, "JavaScript", null, DevTechnology.TechnoEnum.LANGUAGE, R.raw.logo_js));
        technologies.add(new DevTechnology(4, "PHP", null, DevTechnology.TechnoEnum.LANGUAGE, R.raw.logo_php));
        technologies.add(new DevTechnology(5, "Angular", null, DevTechnology.TechnoEnum.FRAMEWORK, R.raw.logo_angular));
        technologies.add(new DevTechnology(6, "Java", null, DevTechnology.TechnoEnum.LANGUAGE, R.raw.logo_java));

        // Création d'une nouvelle instance du fragment
        DevListFragment listFragment = DevListFragment.newInstance(technologies);

        // Manipulation des Fragments via le FragmentManager
        FragmentManager fm = getSupportFragmentManager();

        // Définition d'une operation a réaliser via le Manager
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.container_fragment, listFragment);

        // Application de la transaction
        transaction.commit();

        // Ajouter un event a notre fragment de liste
        listFragment.setOnClickItemListener(technology -> openFragDetail(technology));
    }

    private void openFragDetail(DevTechnology technology) {
        DevDetailFragment detailFragment = DevDetailFragment.newInstance(technology);

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction transaction = fm.beginTransaction();

        // Ajout d'une animation
        transaction.setCustomAnimations(
            android.R.anim.slide_in_left,
            android.R.anim.fade_out,
            android.R.anim.fade_in,
            android.R.anim.slide_out_right
        );
        // Plus d'info : https://developer.android.com/guide/fragments/animate

        transaction.replace(R.id.container_fragment, detailFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}