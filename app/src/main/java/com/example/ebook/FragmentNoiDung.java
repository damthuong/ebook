package com.example.ebook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentNoiDung extends Fragment {

    TextView tvTieude, tvNoidung;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noidung, container, false);

        tvTieude = (TextView) view.findViewById(R.id.textViewTieuDe);
        tvNoidung = (TextView) view.findViewById(R.id.tvNoidung);

        String title = getActivity().getIntent().getStringExtra("title");
        tvTieude.setText(title);
        String temp = tvTieude.getText().toString();

        if(temp.equals(getString(R.string.title_1))){
            tvNoidung.setText(getString(R.string.truyen_1));
        }else if(temp.equals(getString(R.string.title_2))){
            tvNoidung.setText(getString(R.string.truyen_2));
        }else if(temp.equals(getString(R.string.title_3))){
            tvNoidung.setText(getString(R.string.truyen_3));
        }else if(temp.equals(getString(R.string.title_4))){
            tvNoidung.setText(getString(R.string.truyen_4));
        }else if(temp.equals(getString(R.string.title_5))){
            tvNoidung.setText(getString(R.string.truyen_5));
        }else{
            tvNoidung.setText(temp);
        }


        return view;
    }

}
