package com.teste.modelo.planetas;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PlanetFragment extends Fragment {

    private Planet planet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true); // Não destroi o fragment quando rotaciona o dispositivo
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_planet, container, false);

        ImageView imageView = (view.findViewById(R.id.image));
        imageView.setImageResource(planet.getImageID());
        getActivity().setTitle(planet.getName());

        return view;
    }

    public static PlanetFragment newInstance(Planet planet) {
        PlanetFragment fragment = new PlanetFragment();
        fragment.planet = planet;
        return fragment;
    }
}
