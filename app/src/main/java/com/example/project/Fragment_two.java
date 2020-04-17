package com.example.project;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment_two extends Fragment {

    TextView text1;

    public View onCreateView(final LayoutInflater inflater, final ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenttwo, viewGroup, false);

        text1 = (TextView) view.findViewById(R.id.msg3);
        text1.setMovementMethod(LinkMovementMethod.getInstance());
        return view;
    }
}
