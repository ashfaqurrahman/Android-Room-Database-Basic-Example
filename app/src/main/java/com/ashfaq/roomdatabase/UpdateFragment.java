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

public class UpdateFragment extends Fragment {

    public UpdateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);
        final EditText userid = view.findViewById(R.id.user_id);
        final EditText username = view.findViewById(R.id.user_name);
        Button update = view.findViewById(R.id.save);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(userid.getText().toString());
                String name = username.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(name);

                MainActivity.myAppDatabase.myDao().updateUser(user);
                Toast.makeText(getActivity(), "User Data Updated Successfully", Toast.LENGTH_LONG).show();

                userid.setText("");
                username.setText("");
            }
        });
        return view;
    }
}
