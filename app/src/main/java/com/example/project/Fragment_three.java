package com.example.project;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment_three extends Fragment {

    TextView text2;;

    public View onCreateView(final LayoutInflater inflater, final ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentthree, viewGroup, false);

        text2 = (TextView) view.findViewById(R.id.msg4);
        text2.setMovementMethod(LinkMovementMethod.getInstance());
        return view;
    }
}


