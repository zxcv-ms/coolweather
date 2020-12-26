package com.example.coolweather;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.litepal.LitePal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private JSONObject jsonObject;  //用于API的JSON数据操作的JSONObject成员变量
    private JSONArray jsonArray;    //用于API的JSON数据操作的JSONArray成员变量
    private JSONObject jsonObject2; //用于操作imagecode.json的JSONObject成员变量
    private JSONArray jsonArray2;   //用于操作imagecode.json的JSONArray成员变量
    private String[] arry_data1;    //用于临时保存imagecode.json的天气类型与arry_data2一一对应
    private String[] arry_data2;    //用于临时保存imagecode.json的图片ID与arry_data1一一对应
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LitePal.initialize(this);
        setContentView(R.layout.activity_main);

        try {
            InputStreamReader isr = new InputStreamReader(getAssets().open("imagecode.json"),"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
            jsonObject2 = new JSONObject(stringBuilder.toString());
            jsonArray2 = jsonObject2.getJSONArray("img");
            arry_data1 =new String[jsonArray2.length()];
            arry_data2=new String[jsonArray2.length()];
            for(int i=0;i<jsonArray2.length();i++){
                jsonObject2 = jsonArray2.getJSONObject(i);
                arry_data1[i]=jsonObject2.getString("cond");
                arry_data2[i]=jsonObject2.getString("code");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
