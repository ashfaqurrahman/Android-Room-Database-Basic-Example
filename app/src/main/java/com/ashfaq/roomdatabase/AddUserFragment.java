package com.ashfaq.roomdatabase;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserFragment extends Fragment {

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        //final EditText userId = view.findViewById(R.id.user_id);
        final EditText userName = view.findViewById(R.id.user_name);
        Button btnSave = view.findViewById(R.id.save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int userid = getId();
                String username = userName.getText().toString();

                User user = new User();
                //user.setId(userid);
                user.setName(username);

                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(), "User Added Successfully",Toast.LENGTH_LONG).show();
                //userId.setText("");
                userName.setText("");
            }
        });

        return view;
    }
}
