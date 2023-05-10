package com.amarildo.retrofit;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.amarildo.retrofit.api.RetrofitClient;
import com.amarildo.retrofit.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    final private static String MAIN = "MainActivity";
    ListView postListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postListView = findViewById(R.id.post_list);

        getSuperHeroes();
    }

    private void getSuperHeroes() {
        Call<List<Post>> call = RetrofitClient.getInstance()
                .getMyApi()
                .getAllPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call,
                                   @NonNull Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    List<Post> postList = response.body();
                    assert postList != null;
                    Log.i(MAIN, "Hai trovato " + postList.size() + " elementi.");
                    String[] onePost = new String[postList.size()];
                    for (int i = 0; i < postList.size(); i++) {
                        onePost[i] = postList.get(i).getTitle();
                        Log.i(MAIN, "Post = " + onePost[i]);
                    }
                    postListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, onePost));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call,
                                  @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
