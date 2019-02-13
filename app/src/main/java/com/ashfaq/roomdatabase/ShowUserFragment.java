package com.ashfaq.roomdatabase;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ShowUserFragment extends Fragment {

    public ShowUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_user, container, false);

        TextView userinfo = view.findViewById(R.id.display_user);

        List<User> users = MainActivity.myAppDatabase.myDao().getUsers();

        String info = "";

        for (User user :users)
        {
            int id = user.getId();
            String name = user.getName();

            info = info+"\n\n"+"ID: "+id+"\nName: "+name;
            userinfo.setText(info);
        }
        return view;
    }
}
