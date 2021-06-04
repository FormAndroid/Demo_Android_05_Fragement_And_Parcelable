package be.bxl.formation.demo_05_fragement.fragements;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.InputStream;

import be.bxl.formation.demo_05_fragement.R;
import be.bxl.formation.demo_05_fragement.models.DevTechnology;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DevDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DevDetailFragment extends Fragment {

    private TextView tvName, tvDesc, tvType;
    private ImageView imgLogo;
    private LinearLayout layoutDesc;

    private static final String ARG_TECHNO = "element_techno";

    private DevTechnology technology;

    public DevDetailFragment() {
        // Required empty public constructor
    }

    public static DevDetailFragment newInstance(DevTechnology technology) {
        DevDetailFragment fragment = new DevDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_TECHNO, technology);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            technology = getArguments().getParcelable(ARG_TECHNO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dev_detail, container, false);

        // FindViewById
        tvName = v.findViewById(R.id.tv_frag_detail_name);
        layoutDesc = v.findViewById(R.id.layout_frag_detail_display_desc);
        tvDesc = v.findViewById(R.id.tv_frag_detail_desc);
        tvType = v.findViewById(R.id.tv_frag_detail_type);
        imgLogo = v.findViewById(R.id.img_frag_detail_logo);

        // Méthode d'initilisation
        initializeViewData();

        return v;
    }

    private void initializeViewData() {
        tvName.setText(technology.getName());

        if(technology.getDesc() != null) {
            layoutDesc.setVisibility(View.VISIBLE);
            tvDesc.setText(technology.getDesc());
        }
        else {
            layoutDesc.setVisibility(View.GONE);
            tvDesc.setText("");
        }

        tvType.setText(technology.getTechno().name());

        InputStream logoStream = getContext().getResources().openRawResource(technology.getResImg());
        Bitmap logo = BitmapFactory.decodeStream(logoStream);
        imgLogo.setImageBitmap(logo);
    }
}