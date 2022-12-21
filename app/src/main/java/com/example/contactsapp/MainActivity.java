package com.example.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.SearchView;

import com.example.contactsapp.bl.ContactAdapter;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static RecyclerView rv;
    private SearchView sv;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rvContacts);

        sv = findViewById(R.id.svSearch);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ContactAdapter(this, "contact_data.csv", ""));

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                rv.setAdapter(new ContactAdapter(context, "contact_data.csv", s.toLowerCase(Locale.ROOT)));
                return false;
            }
        });

    }
}