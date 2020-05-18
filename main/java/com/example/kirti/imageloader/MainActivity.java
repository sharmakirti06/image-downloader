package com.example.kirti.imageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    static final String IMAGE_1 = "https://images.pexels.com/photos/1226302/pexels-photo1226302.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";
    static final String IMAGE_2 = "https://images.app.goo.gl/bbUcF2bXvX6zvwacA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton1();
        addListenerOnButton2();
    }

    private void addListenerOnButton1() {
        Button button = (Button) findViewById(R.id.btnChangeImage1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ImageView imageView = (ImageView) findViewById(R.id.imageView1);
                ServiceWorker serviceWorker = new ServiceWorker(imageView);
                serviceWorker.execute(IMAGE_1);

            }

        });
    }

        private void addListenerOnButton2() {
            Button button = (Button) findViewById(R.id.btnChangeImage);
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    ImageView imageView = (ImageView) findViewById(R.id.imageView);
                    ServiceWorker serviceWorker = new ServiceWorker(imageView);
                    serviceWorker.execute(IMAGE_2);
                }

            });
        }
}
