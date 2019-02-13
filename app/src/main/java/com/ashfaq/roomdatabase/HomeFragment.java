package com.ashfaq.roomdatabase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements View.OnClickListener {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button saveUser = view.findViewById(R.id.add_user);
        Button displayUser = view.findViewById(R.id.view_user);
        Button deleteUser = view.findViewById(R.id.delete_user);
        Button updateUser = view.findViewById(R.id.update_user);
        saveUser.setOnClickListener(this);
        displayUser.setOnClickListener(this);
        deleteUser.setOnClickListener(this);
        updateUser.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.add_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.view_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ShowUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.delete_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteUser()).addToBackStack(null).commit();
                break;
            case R.id.update_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
