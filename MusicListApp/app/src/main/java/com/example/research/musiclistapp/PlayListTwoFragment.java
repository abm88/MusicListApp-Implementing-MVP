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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlayListTwoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlayListTwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayListTwoFragment extends Fragment {


    public PlayListTwoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play_list_two, container, false);


    return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

            Toast.makeText(context, "This PlayListTwoFragment", Toast.LENGTH_SHORT).show();

    }
}
