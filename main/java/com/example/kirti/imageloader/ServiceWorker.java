package com.example.kirti.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;

public class ServiceWorker extends AsyncTask<String, Void, Bitmap>{
    private OkHttpClient okHttpClient = new OkHttpClient();
    private ImageView view;

    public ServiceWorker(ImageView view) {
        this.view = view;
    }

    @Override
    protected Bitmap doInBackground(String... param) {
        return fetchImageAndSet(param[0]);
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        this.view.setImageBitmap(result);
    }

    private Bitmap fetchImageAndSet(String url) {
            Bitmap bitmap = getBitmapFromURL(url);
            return bitmap;
    }

    private Bitmap getBitmapFromURL(String strURL) {
        try {
            URL url = new URL(strURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
