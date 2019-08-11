package com.applicatech.instagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText etDescription;
    private Button btnCaptureImage;
    private ImageView ivPostImage;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDescription = findViewById(R.id.etDescription);
        btnCaptureImage = findViewById(R.id.btnCaptureImage);
        ivPostImage = findViewById(R.id.ivPostImage);
        btnSubmit = findViewById(R.id.btnSubmit);
        //QueryPost();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = etDescription.getText().toString();
                ParseUser user = ParseUser.getCurrentUser();
                savePost(description, user);
            }
        });
    }

    private void savePost(String description, ParseUser parseUser) {
        Post post = new Post();
        post.setDescrpition(description);
        post.setUser(parseUser);
        // post.setImage();
        post.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                Log.d(TAG, "Error while saving");
                e.printStackTrace();
                return;
                } Log.d(TAG, "Success!!");
                etDescription.setText("");
            }
        });
    }

    private void QueryPost() {
        ParseQuery<Post> postQuery = new ParseQuery<Post>(Post.class);
        postQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                for (int i = 0; i < posts.size(); i++){
                    Log.d(TAG, "post: "+posts.get(i).getDescription());
                }
            }
        });
    }
}
