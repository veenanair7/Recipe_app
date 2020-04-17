package com.example.project;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment_one extends Fragment {
    TextView text;



    Button btnurl;
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_, viewGroup, false);

        text  = (TextView) view.findViewById(R.id.msg2);




                text.setMovementMethod(LinkMovementMethod.getInstance());




          //  }
       // });
        return view;
    }
}
