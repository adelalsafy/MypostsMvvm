package com.example.adelalsay.mypostsmvvm.ui.main;

import android.util.Log;

import com.example.adelalsay.mypostsmvvm.data.PostsClient;
import com.example.adelalsay.mypostsmvvm.pojo.PostModel;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
     MutableLiveData<List<PostModel>>postModelMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> posts = new MutableLiveData<>();
    public void getPosts(){
        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postModelMutableLiveData.setValue(response.body());
                Log.e("HFR onResponse ", response.message());

            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                posts.setValue("errr");
                Log.e("HFR onResponse ", t.getMessage());


            }
        });

    }

}
