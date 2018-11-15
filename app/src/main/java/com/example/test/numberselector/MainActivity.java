package com.example.test.numberselector;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.tv);
        NumberPicker np = findViewById(R.id.numberPicker);
        NumberPicker np2 = findViewById(R.id.numberPicker2);


        Button button = findViewById(R.id.button);

        np.setMinValue(0);
        np.setMaxValue(1000);
        np.setValue(0);
        np.setWrapSelectorWheel(true);

        final String[] test = {"0","10","20","30","40","50","60","70","80","90","100"};
        np2.setDisplayedValues(test);
        np2.setMinValue(0);
        np2.setMaxValue(test.length-1);
        np2.setWrapSelectorWheel(true);

        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                tv.setText("Selected Number : " + numberPicker.getValue());

                Toast.makeText(MainActivity.this,
                        "selected number " + numberPicker.getValue(), Toast.LENGTH_SHORT)
                .show();

            }
        });

    }

    public void alert(View v){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();
        final ViewGroup nullParent = null;
        View theView = inflater.inflate(R.layout.number_picker, nullParent);

        final NumberPicker PickTonne = theView.findViewById(R.id.nbPickTonne);
        final NumberPicker PickKG = theView.findViewById(R.id.nbPickKG);

        final String[] tabKG = {"0","10","20","30","40","50","60","70","80","90","100"};
        PickKG.setMinValue(0);
        PickKG.setMaxValue(tabKG.length-1);
        PickKG.setDisplayedValues(tabKG);
        PickKG.setWrapSelectorWheel(true);

        PickTonne.setMaxValue(100);
        PickTonne.setMinValue(1);
        PickTonne.setWrapSelectorWheel(true);


        alertDialogBuilder.setTitle("Select the number");
        alertDialogBuilder.setView(theView);
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                final TextView tv = (TextView) findViewById(R.id.tv);
                                String selecPicker = tabKG[PickKG.getValue()];
                                tv.setText("Selected Number : " + PickTonne.getValue() + " t " + selecPicker + " kg.");

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

}
