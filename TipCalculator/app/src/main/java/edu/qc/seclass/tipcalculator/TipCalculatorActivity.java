package edu.qc.seclass.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TipCalculatorActivity extends AppCompatActivity {

    Button buttonCompute;
    EditText checkAmountValue;
    EditText partySizeValue;
    EditText fifteenPercentTipValue;
    EditText twentyPercentTipValue;
    EditText twentyfivePercentTipValue;
    EditText fifteenPercentTotalValue;
    EditText twentyPercentTotalValue;
    EditText twentyfivePercentTotalValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        buttonCompute = (Button) findViewById(R.id.buttonCompute);
        checkAmountValue = (EditText) findViewById(R.id.checkAmountValue);
        partySizeValue = (EditText) findViewById(R.id.partySizeValue);
        fifteenPercentTipValue = (EditText) findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue = (EditText) findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipValue = (EditText) findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotalValue = (EditText) findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue = (EditText) findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue = (EditText) findViewById(R.id.twentyfivePercentTotalValue);


        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkAmountValue.getText().toString().equals("") || partySizeValue.getText().toString().equals("") || checkAmountValue.getText().toString().equals(".") ){
                    Toast.makeText(TipCalculatorActivity.this,"Please enter Check Amount and Party Size", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    double check = Double.parseDouble(checkAmountValue.getText().toString());
                    int size = Integer.parseInt(partySizeValue.getText().toString());
                    int fifteenTip, twentyTip, twentyfiveTip;
                    int fifteenTotal, twentyTotal, twentyfiveTotal;

                    fifteenTip = (int)Math.round((double)(check * 0.15) / size);
                    fifteenPercentTipValue.setText(String.valueOf(fifteenTip));
                    twentyTip = (int)Math.round((double)(check * 0.20) / size);
                    twentyPercentTipValue.setText(String.valueOf(twentyTip));
                    twentyfiveTip = (int)Math.round((double)(check * 0.25) / size);
                    twentyfivePercentTipValue.setText(String.valueOf(twentyfiveTip));

                    fifteenTotal = (int)Math.round((double)check / size + (check * 0.15 / size));
                    fifteenPercentTotalValue.setText(String.valueOf(fifteenTotal));

                    twentyTotal = (int)Math.round((double)check / size + (check * 0.20 / size));
                    twentyPercentTotalValue.setText(String.valueOf(twentyTotal));

                    twentyfiveTotal = (int)Math.round((double)check / size + (check * 0.25 /size));
                    twentyfivePercentTotalValue.setText(String.valueOf(twentyfiveTotal));


                }
            }
        });



    }
}
