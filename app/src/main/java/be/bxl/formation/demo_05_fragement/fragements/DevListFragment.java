package be.bxl.formation.demo_05_fragement.fragements;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import be.bxl.formation.demo_05_fragement.R;
import be.bxl.formation.demo_05_fragement.models.DevTechnology;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DevListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DevListFragment extends Fragment {

    private ListView lvTechnologies;

    // Les constantes utiliser lors de la création du fragement
    private static final String ARG_DATA_SET = "data_dev_techno";

    // Les données de mon fragement
    private ArrayList<DevTechnology> devTechnologies;

    public DevListFragment() {
        // Constructeur vide. Ne pas le supprimer, il est necessaire !!!
    }

    // Méthode "proproser" pour créer un Fragement (Les données seront placé dans un bundle)
    public static DevListFragment newInstance(ArrayList<DevTechnology> dataSet) {
        // Création du fragment
        DevListFragment fragment = new DevListFragment();

        // Création d'un bundle avec les données
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_DATA_SET, dataSet);

        // Ajout des données au fragement via ses Arguments
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Recuperation des données de ses Arguments
            devTechnologies = getArguments().getParcelableArrayList(ARG_DATA_SET);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dev_list, container, false);

        // Possibilité de faire des findViewById ici =)
        lvTechnologies = v.findViewById(R.id.lv_frag_list_technologies);

        // Initialisation de l'app
        initializeViewData();

        return v;
    }

    private void initializeViewData() {
        ArrayAdapter<DevTechnology> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                devTechnologies
        );

        lvTechnologies.setAdapter(adapter);

        lvTechnologies.setOnItemClickListener((parent, view, position, id) -> {
            Log.d("TEST_DEV_BXL", "Click");

            DevTechnology technology = devTechnologies.get(position);

            if(event != null) {
                event.onClickItem(technology);
            }
        });
    }

    //region Evenement sur la liste
    @FunctionalInterface
    public interface OnClickItemListener {
        void onClickItem(DevTechnology technology);
    }

    private OnClickItemListener event;

    public void setOnClickItemListener(OnClickItemListener event) {
        this.event = event;
    }
    //endregion
}