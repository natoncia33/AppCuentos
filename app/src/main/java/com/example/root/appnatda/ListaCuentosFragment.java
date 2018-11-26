package com.example.root.appnatda;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.root.appnatda.adapters.AdaptadorCuentos;
import com.example.root.appnatda.clases.CuentoVo;
import com.example.root.appnatda.interfaces.IComunicaFragments;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaCuentosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaCuentosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaCuentosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization paramete00rs, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<CuentoVo> listaCuentos;
    RecyclerView recyclerCuentos;

    Activity activity;
    IComunicaFragments interfaceComunicaFragments;

    public ListaCuentosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaCuentoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaCuentosFragment newInstance(String param1, String param2) {
        ListaCuentosFragment fragment = new ListaCuentosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_lista_cuento, container, false);

        listaCuentos = new ArrayList<>();
        recyclerCuentos= (RecyclerView) vista.findViewById(R.id.recyclerId);
        recyclerCuentos.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        AdaptadorCuentos adapter = new AdaptadorCuentos(listaCuentos);
        recyclerCuentos.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext()," "
                        +listaCuentos.get(recyclerCuentos.getChildAdapterPosition(view))
                        .getCuento(), Toast.LENGTH_SHORT).show();

                interfaceComunicaFragments.enviarCUento(listaCuentos.get(recyclerCuentos.getChildAdapterPosition(view)));
            }

        });
        return vista;
    }

    private void llenarLista() {


        listaCuentos.add(new CuentoVo("Uga la tortuga",getString(R.string.uga),getString(R.string.uga_descripcion_larga), R.drawable.ugalatortuga, R.drawable.ugalatortuga));
        listaCuentos.add(new CuentoVo("El aventura del agua",getString(R.string.aventuraDelAgua_descripcion_corta),getString(R.string.aventuraDelAgue_descripcion_larga), R.drawable.aventuradelagua,R.drawable.aventuradelagua));
        listaCuentos.add(new CuentoVo("Secreto a gritos",getString(R.string.secretoA_descripcion_corta),getString(R.string.secretoA_descripcion_larga), R.drawable.secretoavoces, R.drawable.secretoavoces));
        listaCuentos.add(new CuentoVo("Papel y tinta",getString(R.string.papelytinta_descripcion_corta), getString(R.string.papelytinta_descripcion_larga),R.drawable.papelytinta, R.drawable.papelytinta));



    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            this.activity=(Activity) context;
            interfaceComunicaFragments = (IComunicaFragments) this.activity;

        }

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
