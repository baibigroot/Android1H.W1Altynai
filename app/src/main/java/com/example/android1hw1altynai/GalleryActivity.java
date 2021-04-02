package com.example.android1hw1altynai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class GalleryActivity extends AppCompatActivity {

    Button btn;
    EditText text;
    ImageView viewGallery;
    String img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        btn = findViewById(R.id.btn3);
        text = findViewById(R.id.edit_text2);
        viewGallery = findViewById(R.id.image_view2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etText = text.getText().toString();
                Intent intent = getIntent();
                intent.putExtra("KEY", etText);
                intent.putExtra("KEY2", img);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        viewGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 5);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 5) {
                //выбрали рисунок из галереи
                Uri ChossefileUri = data.getData();
                if (ChossefileUri != null) {
                    String j = String.valueOf(ChossefileUri);
                    if (j != null) {
                        viewGallery.setImageURI(ChossefileUri);
                        img = j;
                    }
                }
            }
        }
    }
}