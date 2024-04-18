package com.example.coffee;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    int quantityCount = 1;
    double cost = 4.0;
    String addWhip = "No";
    String addChocolate = "No";
    public void onClickSubtract(View view) {
        if (quantityCount - 1 > 0) {
            quantityCount = quantityCount - 1;
        }
        TextView temp = (TextView) findViewById(R.id.quantity);
        temp.setText(String.valueOf(quantityCount));
    }

    public void onClickAdd(View view) {
        quantityCount = quantityCount + 1;
        TextView temp = (TextView) findViewById(R.id.quantity);
        temp.setText(String.valueOf(quantityCount));
    }

    public void calculateCost(View view) {
        CheckBox boxCream = (CheckBox) findViewById(R.id.cream);
        CheckBox boxChocolate = (CheckBox) findViewById(R.id.chocolate);
        boolean isCreamChecked = boxCream.isChecked();
        boolean isChocolateChecked = boxChocolate.isChecked();

        cost = 4.0;

        if (isCreamChecked) {
            cost += 0.50;
            addWhip = "Yes";
        }

        if (isChocolateChecked) {
            cost += 1.0;
            addChocolate = "Yes";
        }
    }

    public void onClickOrder(View view) {
        calculateCost(view);
        double totalCost = cost * quantityCount;

        TextView sum = (TextView) findViewById(R.id.summary);
        sum.setText("Add whipped cream? " + addWhip + "\nAdd chocolate? "
                + addChocolate + "\nQuantity: " + quantityCount + "\nPrice: $" + totalCost
                + "\nThank You!");

    }



}