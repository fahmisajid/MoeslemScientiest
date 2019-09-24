package com.example.moeslemscientiest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_DESC = "extra_desc";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_PHOTO= "extra_photo";
    public static final String EXTRA_TTL= "extra_ttl";
    public static final String EXTRA_DIED= "extra_died";
    public static final String EXTRA_EXPERT= "extra_expert";
    public static final String EXTRA_KARYA= "extra_karya";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvName = findViewById(R.id.scientistname);
        TextView tvBirth = findViewById(R.id.scientistbirth);
        TextView tvDesc= findViewById(R.id.desc);
        TextView tvDied= findViewById(R.id.scientistdied);
        TextView tvExpert= findViewById(R.id.expert);
        TextView tvKarya= findViewById(R.id.karya);
        ImageView tvPhotoReceived = findViewById(R.id.photo);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String desc = getIntent().getStringExtra(EXTRA_DESC);
        String photo = getIntent().getStringExtra(EXTRA_PHOTO);
        String birth= getIntent().getStringExtra(EXTRA_TTL);
        String died= getIntent().getStringExtra(EXTRA_DIED);
        String expert= getIntent().getStringExtra(EXTRA_EXPERT);
        String karya= getIntent().getStringExtra(EXTRA_KARYA);

        tvName.setText("Nama: "+ name);
        tvBirth.setText("Tempat & Tahun Lahir: "+ birth);
        tvDied.setText("Tempat & Tahun Meninggal: " +died);
        tvExpert.setText("Bidang Ahli: " +expert);
        tvDesc.setText("Deskripsi: \n" +desc);
        tvKarya.setText("Karya: \n" +karya);


        Glide.with(this)
                .load(photo)
                .apply(new RequestOptions().override(55, 55))
                .into(tvPhotoReceived);

    }
}
