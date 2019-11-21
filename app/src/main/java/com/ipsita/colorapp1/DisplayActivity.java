package com.ipsita.colorapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    private ListView listView;
    private RelativeLayout relativeLayoutOne;
    private ImageView imageView;
    DatabaseReference myRef;
    List<Colors> colorsList;
    Colors color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        listView=findViewById(R.id.recycler_view);
        relativeLayoutOne=findViewById(R.id.relativeLayoutOne);
        imageView=findViewById(R.id.rectimage);

        myRef= FirebaseDatabase.getInstance().getReference();
        colorsList=new ArrayList<>();
    }
    @Override
    protected void onStart() {
        super.onStart();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                colorsList.clear();
                String name,hex;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        name = snapshot.getKey().toString();
                        hex = snapshot.getValue().toString();
                        Colors color = new Colors(name,hex);
                        colorsList.add(color);

                }
                ViewAllAdapter viewAllAdapter = new ViewAllAdapter(DisplayActivity.this, colorsList);
                listView.setAdapter(viewAllAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                Colors color = colorsList.get(itemPosition);
                String hexcolorcode = color.getColorName();
                //int hcc=Integer.parseInt(hexcolorcode);
                Toast.makeText(getApplicationContext(),hexcolorcode, Toast.LENGTH_LONG).show();
                //relativeLayoutOne.setBackgroundColor(hcc);
                //imageView.setBackgroundColor(hcc);
                //Toast.makeText(getApplicationContext(),hcc, Toast.LENGTH_LONG).show();
            }
        });
    }
}
