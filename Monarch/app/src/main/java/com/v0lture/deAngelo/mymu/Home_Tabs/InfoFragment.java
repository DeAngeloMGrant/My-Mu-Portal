package com.v0lture.deAngelo.mymu.home_tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.v0lture.deAngelo.mymu.R;

public class InfoFragment extends Fragment {
    //EditText mID;
    public TextView stuName;
   // Button mSearch;

   private  DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference mConditionRef = mRootRef.child("condition");


    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.info_fragment,null);
        View v = inflater.inflate(R.layout.info_fragment,container,false);

        //mID =(EditText) mID.findViewById(R.id.student);
       // stuName =(TextView) stuName.findViewById(R.id.stu_name);
       // mSearch =(Button) mSearch.findViewById(R.id.id_search);
        return v;
    }
    @Override
    public void onStart(){
        super.onStart();
        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String text = dataSnapshot.getValue(String.class);
                    stuName.setText(text);

                }else{
                    Toast.makeText(getActivity(), getString(Integer.parseInt("You are not a student")), Toast.LENGTH_LONG).show();
                }
            }
        //Empty Method Body
            @Override
            public void onCancelled(DatabaseError databaseError) {
        //Empty Method Body

            }
        });
    }
}
