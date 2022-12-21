package com.example.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class openContact extends AppCompatActivity implements View.OnClickListener {
    private TextView tvNumber, tvName, tvLanguage;
    private ImageView ivImage, ivPhone, ivGlobe;
    private Button btFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_contact);

        Intent intent = getIntent();
        String fname = intent.getStringExtra("fname");
        String lname = intent.getStringExtra("lname");
        String language = intent.getStringExtra("lang");
        String pNumber = intent.getStringExtra("phone");
        char gender = intent.getCharExtra("gender", 'M');
        Uri image = Uri.parse(intent.getStringExtra("image"));

        tvName = findViewById(R.id.tvContactName);
        tvNumber = findViewById(R.id.tvNumber);
        tvLanguage = findViewById(R.id.tvLanguage);

        ivImage = findViewById(R.id.ivImg);
        ivPhone = findViewById(R.id.ivPhone);
        ivGlobe = findViewById(R.id.ivGlobe);

        ivGlobe.setImageResource(R.drawable.ic_baseline_ac_unit_24);
        ivPhone.setImageResource(R.drawable.ic_baseline_local_phone_24);

        btFinish = findViewById(R.id.btFinish);
        btFinish.setOnClickListener(this);

        tvName.setText(fname + " " + lname);
        tvNumber.setText(pNumber);
        tvLanguage.setText(language);
        Picasso.get()
                .load(image)
                .into(ivImage);

    }

    @Override
    public void onClick(View view) {
        finish();
    }
}