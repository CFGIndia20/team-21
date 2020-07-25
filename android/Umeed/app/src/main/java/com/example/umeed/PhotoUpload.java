package com.example.umeed;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import retrofit2.Callback;
import okhttp3.RequestBody;
import retrofit2.Call;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoUpload extends AppCompatActivity {
    String picturePath;
    private ImageView imageView;
    EditText desc;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_upload);
        imageView = (ImageView) findViewById(R.id.my_work);
        desc = findViewById(R.id.work_desc);

    }

    private void selectImage(Context context) {
        final CharSequence[] options = { "Choose from Gallery","Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose your profile picture");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                 if (options[item].equals("Choose from Gallery")) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto , 1);

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            switch (requestCode) {
                case 1:
                    if (resultCode == RESULT_OK && data != null) {
                        Uri selectedImage = data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        if (selectedImage != null) {
                            Cursor cursor = getContentResolver().query(selectedImage,
                                    filePathColumn, null, null, null);
                            if (cursor != null) {
                                cursor.moveToFirst();

                                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                                 picturePath = cursor.getString(columnIndex);
                                File file = new File(picturePath);
                                Log.d("Picture Path", file.getPath());
                                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                                cursor.close();
                            }
                        }

                    }
                    break;
            }
        }
    }

    public void selectImage(View view) {
        selectImage(this);
    }

    public void sendToServer(View view) {
        String description = desc.getText().toString();

        //take empId
        uploadFile(description,"1");
    }

    private void uploadFile(String desc,String empId) {

        Bitmap bm = BitmapFactory.decodeFile(picturePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); // bm is the bitmap object
        byte[] byteArrayImage = baos.toByteArray();


        String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);

        WorkData wrkData = new WorkData(desc,empId,encodedImage);
        Log.d("Created","Object");
        //creating a file
//        File file = new File(picturePath);
//
//        //creating request body for file
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        RequestBody descBody = RequestBody.create(MediaType.parse("text/plain"), desc);
//        RequestBody empInt = RequestBody.create(MediaType.parse("text/plain"), Integer.toString(empId));

        //The gson builder
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        //creating retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UmeedApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //creating our api
        UmeedApi api = retrofit.create(UmeedApi.class);

        //creating a call and calling the upload image method
        Call<WorkData> call = api.saveWorkData(wrkData);
        Log.d("Called","Api");

        //finally performing the call
        call.enqueue(new Callback<WorkData>() {
            @Override
            public void onResponse(Call<WorkData> call, Response<WorkData> response) {

                if (!response.isSuccessful()) {
                    Log.d("Error: ", String.valueOf(response.code()));
                    return;
                }
                    Toast.makeText(getApplicationContext(), "Data and File Uploaded Successfully...", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<WorkData> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        Log.d("End","End");




    }


}