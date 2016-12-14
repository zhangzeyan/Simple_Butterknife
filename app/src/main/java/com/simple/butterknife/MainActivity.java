package com.simple.butterknife;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindArray;
import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.simple.butterknife.R.array.city;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.appNameTv)
    TextView appNameTv;

    @BindViews({R.id.nameTv, R.id.ageTv, R.id.sexTv})
    List<TextView> listTv;

    @BindString(R.string.app_name)
    String app_name;

    @BindArray(city)
    String[] citys;

    @BindBitmap(R.mipmap.ic_launcher)
    Bitmap bitmap;

    @BindView(R.id.textImg)
    ImageView textImg;

    @BindColor(R.color.colorAccent)
    int color;

    @BindView(R.id.cityLv)
    ListView cityLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        appNameTv.setText(app_name);

        listTv.get(0).setText("张三");
        listTv.get(1).setText("12");
        listTv.get(2).setText("男");

        listTv.get(0).setTextColor(color);


        textImg.setImageBitmap(bitmap);


        cityLv.setAdapter(new MyAdapter(this,citys));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.nameTv, R.id.ageTv, R.id.sexTv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nameTv:
                Toast.makeText(this, listTv.get(0).getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.ageTv:
                Toast.makeText(this, listTv.get(1).getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.sexTv:
                Toast.makeText(this, listTv.get(2).getText(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
