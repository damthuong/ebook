package com.example.ebook;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class FragmentChuong extends Fragment {

    ListView lvCacChuong;
    ArrayList<String> arrayCacChuong;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chuong, container, false);

        lvCacChuong = (ListView) view.findViewById(R.id.lv_cac_chuong);
        arrayCacChuong = new ArrayList<>();
        arrayCacChuong.add(getString(R.string.title_1));
        arrayCacChuong.add(getString(R.string.title_2));
        arrayCacChuong.add(getString(R.string.title_3));
        arrayCacChuong.add(getString(R.string.title_4));
        arrayCacChuong.add(getString(R.string.title_5));

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayCacChuong);
        lvCacChuong.setAdapter(adapter);
     //   adapter.notifyDataSetChanged();

        lvCacChuong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), arrayCacChuong.get(i), Toast.LENGTH_SHORT).show();
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    Intent intent = new Intent(getActivity(), ChuongActivity.class);
                    intent.putExtra("title", arrayCacChuong.get(i));
                    startActivity(intent);
                }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    Intent intent = new Intent(getActivity(), NoiDungActivity.class);
                    intent.putExtra("title", arrayCacChuong.get(i));
                    startActivity(intent);
                }
                getActivity().onBackPressed();
            }
        });

        return view;
    }
}
