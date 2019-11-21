package com.ipsita.colorapp1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText,colorEditText;
    private Button uploadButton,viewAllButton;

    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.nameEditText);
        colorEditText = findViewById(R.id.colorEditText);
        uploadButton = findViewById(R.id.uploadBtn);
        viewAllButton=findViewById(R.id.viewAllBtn);

        viewAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next=new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(next);
            }
        });

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startUploading();
            }
        });
    }

    private void startUploading() {
        String colorName = nameEditText.getText().toString().trim();
        String hexCode = colorEditText.getText().toString().trim();
        if (!TextUtils.isEmpty(colorName) && !TextUtils.isEmpty(hexCode)) {
            myRef.child(colorName).setValue(hexCode);
            Toast.makeText(getApplicationContext(),"Uploaded",Toast.LENGTH_LONG).show();
            //hexCode = myRefChild.getKey().toString().trim();
        }
    }
}
