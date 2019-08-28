package com.applicatech.instagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcels;


public class DetailActivity extends AppCompatActivity {
    private TextView tvUsername;
    private ImageView ivPostImage;
    private TextView tvCreatedAt;
    private TextView tvDescription;
    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra("post"));
        tvUsername = findViewById(R.id.tvUsername2);
        ivPostImage = findViewById(R.id.ivPostImage);
        tvCreatedAt = findViewById(R.id.tvCreatedAt);
        tvDescription = findViewById(R.id.tvDescription2);


        tvUsername.setText(post.getUser().getUsername());
        ParseFile image = post.getImage();
        if ( image != null) {
            Glide.with(this).load(image.getUrl()).into(ivPostImage);
        }
        tvDescription.setText(post.getDescription());
        tvCreatedAt.setText(post.getKCreatedAt());
    }

}
