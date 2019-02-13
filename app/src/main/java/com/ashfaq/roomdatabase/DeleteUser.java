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

public class DeleteUser extends Fragment {

    public DeleteUser() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        final EditText userid = view.findViewById(R.id.delete);
        Button deletebutton = view.findViewById(R.id.delete_btn);
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(userid.getText().toString());
                User user = new User();
                user.setId(id);
                MainActivity.myAppDatabase.myDao().deleteUser(user);

                Toast.makeText(getActivity(), "User Deleted Successfully", Toast.LENGTH_LONG).show();
                userid.setText("");
            }
        });
        return view;
    }
}
