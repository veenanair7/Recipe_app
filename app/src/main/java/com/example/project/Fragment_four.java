package com.example.project;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment_four extends Fragment {

    TextView text3;;

    public View onCreateView(final LayoutInflater inflater, final ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentfour, viewGroup, false);

        text3=(TextView)view.findViewById(R.id.msg5);
        text3.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }
}
