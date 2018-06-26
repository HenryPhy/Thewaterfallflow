package com.example.rikao_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView photoRv;
    List<String> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        photoRv =  findViewById(R.id.photo_rv);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        photoRv.setLayoutManager(manager);
        mDatas = Arrays.asList(image.imag);
        PhotoAdapter adapter = new PhotoAdapter(this, mDatas);
        photoRv.setAdapter(adapter);
    }
}
