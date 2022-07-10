package com.example.appbotica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProductDetail extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        String name = getIntent().getStringExtra("NAMEP");
        String price = Long.toString(getIntent().getLongExtra("PRICE",0));
        String dateexpe = getIntent().getStringExtra("DATAEXPIRATION");
        String namebot = getIntent().getStringExtra("NAMEBOTICA");
        String direct = getIntent().getStringExtra("DIRECTION");

        TextView nameTextView = findViewById(R.id.PD_Name);
        TextView priceTextView = findViewById(R.id.PD_Price);
        TextView dateexpTextView = findViewById(R.id.PD_Dateexp);
        TextView nameboTextView = findViewById(R.id.PD_Namebo);
        TextView direcTextView = findViewById(R.id.PD_Direc);

        nameTextView.setText(name);
        priceTextView.setText(price);
        dateexpTextView.setText(dateexpe);
        nameboTextView.setText(namebot);
        direcTextView.setText(direct);

        button = (Button) findViewById(R.id.PD_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GPS();
            }
        });

    }
    public void GPS(){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}