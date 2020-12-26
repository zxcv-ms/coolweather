package com.example.coolweather;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONObject;



public class WeatherFragment extends Fragment {
    JSONObject jsonObject;
    JSONArray jsonArray;
    private int[] imgs={
            R.drawable.a0,R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,
            R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11,
            R.drawable.a12,R.drawable.a13,R.drawable.a14,R.drawable.a15,R.drawable.a16,R.drawable.a17,
            R.drawable.a18,R.drawable.a19,R.drawable.a20,R.drawable.a21,R.drawable.a22,R.drawable.a23,
            R.drawable.a24,R.drawable.a25,R.drawable.a26,R.drawable.a27,R.drawable.a28,R.drawable.a29,
            R.drawable.a30,R.drawable.a31,R.drawable.a32,R.drawable.a33,R.drawable.a34,R.drawable.a35,
            R.drawable.a36,R.drawable.a37,R.drawable.a38,R.drawable.a99
    };
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //layout转View对象
        View view = inflater.inflate(R.layout.now,container,false);
        //绑定数据
        //天气JSON数据解析并将不同的页面的天气信息保存到String weatherInfo里
        //通过Bundle传递

        String weatherInfo = getArguments().getString("weatherInfo");

        //将数据分割
        String[] Info = weatherInfo.split(",");


        //根据天气选择对应的图片
        int code=Integer.parseInt(Info[7]);
        ImageView fiv = view.findViewById(R.id.fimageView);
        if(code!=99)
            fiv.setImageResource(imgs[code]);
        return view;
    }
}
