package com.example.research.musiclistapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;



public class PlayListOneFragment extends Fragment {




    public PlayListOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play_list_one, container, false);
        Button button = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(),"This is test", Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }






    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

            Toast.makeText(context, "This PlayListOne Fragment", Toast.LENGTH_SHORT).show();

    }


}
