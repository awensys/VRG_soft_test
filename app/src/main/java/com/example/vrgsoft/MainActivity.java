package com.example.vrgsoft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vrgsoft.nyt.NYT;
import com.example.vrgsoft.nyt.NYT_Api;
import com.example.vrgsoft.nyt.Result;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity implements RVAdapter.RecyclerViewClickListener, RVAdapter.RecyclerViewLongClickListener, View.OnClickListener {

    public static final String TITLE = "TITLE";
    public static final String URL = "URL";
    public static final String DETAIL = "DETAIL";
    public static final String UPDATE = "UPDATE";
    public static final String SECTION = "SECTION";
    ViewPager viewPager;
    NYT_Api nyt_api;
    PagerAdapter pagerAdapter;
    ArrayList<Result> shared;
    ArrayList<Result> viewed;
    ArrayList<Result> emailed;
    Button btnRefresh;
    DataBaseHandler dataBaseHandler;
    private static MainActivity inst;

    public static MainActivity getInstance() {
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
        dataBaseHandler = new DataBaseHandler(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);
        shared = new ArrayList<>();
        viewed = new ArrayList<>();
        emailed = new ArrayList<>();
        btnRefresh = findViewById(R.id.btn_activity_main);
        btnRefresh.setOnClickListener(this);
        ObjectMapper mapper = new ObjectMapper()
                .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/mostpopular/v2/")
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();
        nyt_api = retrofit.create(NYT_Api.class);
        update();

    }

    public void update() {

        nyt_api.getEmailed().enqueue(new Callback<NYT>() {
            @Override
            public void onResponse(Call<NYT> call, Response<NYT> response) {
                emailed = (ArrayList<Result>) response.body().getResults();
                pagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NYT> call, Throwable t) {
                t.printStackTrace();
            }
        });
        nyt_api.getShared().enqueue(new Callback<NYT>() {
            @Override
            public void onResponse(Call<NYT> call, Response<NYT> response) {
                shared = (ArrayList<Result>) response.body().getResults();
                pagerAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<NYT> call, Throwable t) {
            }
        });
        nyt_api.getViewed().enqueue(new Callback<NYT>() {
            @Override
            public void onResponse(Call<NYT> call, Response<NYT> response) {
                viewed = (ArrayList<Result>) response.body().getResults();
                pagerAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<NYT> call, Throwable t) {
            }
        });
    }

    @Override
    public void onLongClick(Result result, int id) {

        boolean temp = true;

        if (dataBaseHandler.getAllResults().size() == 0) {
            dataBaseHandler.add(result);
            pagerAdapter.notifyDataSetChanged();
            temp=false;
            Toast.makeText(inst, "add to favourites", Toast.LENGTH_SHORT).show();
        } else if (dataBaseHandler.getAllResults().size() > 0) {
            for (int i = 0; i < dataBaseHandler.getAllResults().size(); i++) {
                if (dataBaseHandler.getAllResults().get(i).getTitle().contains(result.getTitle())) {
                    dataBaseHandler.remove(result.getTitle());
                    pagerAdapter.notifyDataSetChanged();
                    temp=false;
                    Toast.makeText(inst, "remove from favourites", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        }
        if(temp){
            dataBaseHandler.add(result);
            pagerAdapter.notifyDataSetChanged();
            Toast.makeText(inst, "add to favourites", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(Result result) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(TITLE, result.getTitle());
        intent.putExtra(URL, result.getMedia().get(0).getMediaMetadata().get(2).getUrl());
        intent.putExtra(DETAIL, result.getAbstract());
        intent.putExtra(UPDATE, result.getUpdated());
        intent.putExtra(SECTION, result.getSection());
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        update();
        pagerAdapter.notifyDataSetChanged();
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {

        @Override
        public int getItemPosition(@NonNull Object object) {
            return POSITION_NONE;
        }

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return PageFragment.newInstance(shared);
            } else if (position == 1) {
                return PageFragment.newInstance(viewed);
            } else if (position == 2) {
                return PageFragment.newInstance(emailed);
            } else if (position == 3) {
                return PageFragment.newInstance(dataBaseHandler.getAllResults());
            } else return new PageFragment();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return "Most shared";
            } else if (position == 1) {
                return "Most viewed";
            } else if (position == 2) {
                return "Most emailed";
            } else if (position == 3) {
                return "Favourites";
            } else return "";
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
