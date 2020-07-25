package com.example.umeed;

import org.w3c.dom.Comment;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface UmeedApi {
    String BASE_URL = "http://ramji12.atwebpages.com/";
//
//    @Multipart
//    @POST("/images/upload")
//    Call<WorkData> uploadImage(@Part("image\"; filename=\"myfile.jpg\" ") RequestBody file, @Part("desc") RequestBody desc,@Part("empId") RequestBody empId);

    @POST("message.php")
    Call<WorkData> saveWorkData(@Body WorkData workData);


    @GET("all.php")
    Call<List<WorkData>> getPosts();


    @GET("work/{id}")
    Call<List<WorkData>> getComments(@Path("id") int postId);

}
