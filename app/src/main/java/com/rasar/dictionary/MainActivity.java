package com.rasar.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.rasar.dictionary.Adapters.MeaningAdapter;
import com.rasar.dictionary.Adapters.PhoneticAdapter;
import com.rasar.dictionary.Models.ApiResponce;

public class MainActivity extends AppCompatActivity {

    androidx.appcompat.widget.SearchView searchView;
    TextView wordTv;
    RecyclerView phoneticsRecyclerView;
    RecyclerView meaningRecyclerView;
    ProgressDialog progressDialog;
    PhoneticAdapter phoneticAdapter;
    MeaningAdapter meaningAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);

        searchView = findViewById(R.id.searchViewId);
        wordTv = findViewById(R.id.wordTvId);
        phoneticsRecyclerView = findViewById(R.id.phoneticsRecyclerViewId);
        meaningRecyclerView = findViewById(R.id.meaningRecyclerViewId);

        progressDialog.setTitle("Loading...");
        progressDialog.show();
        RequestManager requestManager = new RequestManager(MainActivity.this );
        requestManager.getWordMeaning(listener, "Hello");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching responce for: " + query);
                progressDialog.show();
                RequestManager requestManager = new RequestManager(MainActivity.this );
                requestManager.getWordMeaning(listener, query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private final OnFetchDataListener listener= new OnFetchDataListener() {
        @Override
        public void onFetchData(ApiResponce apiResponce, String message) {
            progressDialog.dismiss();
            if (apiResponce==null){
                Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                return;
            }
            showData(apiResponce);
        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(ApiResponce apiResponce) {
        wordTv.setText("Word: "+apiResponce.getWord());
        phoneticsRecyclerView.setHasFixedSize(true);
        phoneticsRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        phoneticAdapter = new PhoneticAdapter(this, apiResponce.getPhonetics());
        phoneticsRecyclerView.setAdapter(phoneticAdapter);

        meaningRecyclerView.setHasFixedSize(true);
        meaningRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        meaningAdapter = new MeaningAdapter(this, apiResponce.getMeanings());
        meaningRecyclerView.setAdapter(meaningAdapter);
    }
}