package com.example.umeed;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UmeedApi {
    String BASE_URL = "http://ramji12.atwebpages.com/";

    @Multipart
    @POST("/images/upload")
    Call<WorkData> uploadImage(@Part("image\"; filename=\"myfile.jpg\" ") RequestBody file, @Part("desc") RequestBody desc,@Part("empId") RequestBody empId);
}
