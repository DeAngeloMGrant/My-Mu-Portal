package com.v0lture.deAngelo.mymu.tools_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.v0lture.deAngelo.mymu.R;

public class GPAFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.gpa_fragment,container,false);

        final Spinner spinner = (Spinner) v.findViewById(R.id.spinner1);
        final Spinner spinner2 = (Spinner) v.findViewById(R.id.spinner2);
        final Spinner spinner3 = (Spinner) v.findViewById(R.id.spinner3);
        final Spinner spinner4 = (Spinner) v.findViewById(R.id.spinner4);
        final Spinner spinner5 = (Spinner) v.findViewById(R.id.spinner5);
        final Spinner spinner6 = (Spinner) v.findViewById(R.id.spinner6);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),R.array.letter_grades,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner!= null && spinner.getSelectedItem()!=null){
                    Toast.makeText(getContext(), parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();

                }


            }
            //Empty Method Body
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
            //Empty Method Body

        });
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String name = null;
                if(spinner2 != null && spinner2.getSelectedItem()!=null){
                    Toast.makeText(getContext(), parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();

                }
            }
            //Empty Method Body

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
            //Empty Method Body

        });
        spinner3.setAdapter(adapter);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String name = null;
                if(spinner3 != null && spinner3.getSelectedItem()!=null){
                    Toast.makeText(getContext(), parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();

                }
            }
            //Empty Method Body

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
            //Empty Method Body

        });
        spinner4.setAdapter(adapter);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String name = null;
                if(spinner4 != null && spinner4.getSelectedItem()!=null){
                    Toast.makeText(getContext(), parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();

                }
            }
            //Empty Method Body

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
            //Empty Method Body

        });
        spinner5.setAdapter(adapter);
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String name = null;
                if(spinner5 != null && spinner5.getSelectedItem()!=null){
                    Toast.makeText(getContext(), parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();

                }
            }
            //Empty Method Body

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
            //Empty Method Body

        });
        spinner6.setAdapter(adapter);
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String name = null;
                if(spinner6 != null && spinner6.getSelectedItem()!=null){
                    Toast.makeText(getContext(), parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();

                }
            }
            //Empty Method Body

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
            //Empty Method Body

        });
        return v;
    }
}
