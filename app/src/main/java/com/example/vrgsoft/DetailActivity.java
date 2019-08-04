package com.example.vrgsoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vrgsoft.nyt.Result;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;


public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView title, date, detail, section;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        title = findViewById(R.id.tv_title_detail_activity);
        date = findViewById(R.id.tv_update_date_detail_activity);
        detail = findViewById(R.id.tv_abstract_detail_activity);
        section = findViewById(R.id.tv_section_detail_activity);
        imageView = findViewById(R.id.iv_detail_activity);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Picasso.get().load(intent.getStringExtra(MainActivity.URL)).resize(width, height / 3).into(imageView);

        title.setText(intent.getStringExtra(MainActivity.TITLE));
        date.setText("Updated: "+intent.getStringExtra(MainActivity.UPDATE));
        detail.setText(intent.getStringExtra(MainActivity.DETAIL));
        section.setText("Section: "+intent.getStringExtra(MainActivity.TITLE));
    }
}
