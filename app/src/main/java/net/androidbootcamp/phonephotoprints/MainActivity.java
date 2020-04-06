package net.androidbootcamp.phonephotoprints;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double fourBySixRate = .19;
    double fiveBySevenRate = .49;
    double eightByTenRate = .79;
    int numPrintsEntered;
    double orderCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText numPrints = (EditText)findViewById(R.id.txtNumPrints);
        final RadioButton fourBySix = (RadioButton)findViewById(R.id.rad4x6);
        final RadioButton fiveBySeven = (RadioButton)findViewById(R.id.rad5x7);
        final RadioButton eightByTen = (RadioButton)findViewById(R.id.rad8x10);
        final TextView result = (TextView)findViewById(R.id.txtResult);
        Button order = (Button)findViewById(R.id.btnOrder);

        order.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numPrintsEntered = Integer.parseInt(numPrints.getText().toString());
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                if(numPrintsEntered <= 50) {
                    if(fourBySix.isChecked()) {
                        orderCost = numPrintsEntered * fourBySixRate;
                        result.setText("The order cost is " + currency.format(orderCost));
                    }
                    if(fiveBySeven.isChecked()) {
                        orderCost = numPrintsEntered * fiveBySevenRate;
                        result.setText("The order cost is " + currency.format(orderCost));
                    }
                    if(eightByTen.isChecked()){
                        orderCost = numPrintsEntered * eightByTenRate;
                        result.setText("The order cost is " + currency.format(orderCost));
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Number of Prints must be 50 or less", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
