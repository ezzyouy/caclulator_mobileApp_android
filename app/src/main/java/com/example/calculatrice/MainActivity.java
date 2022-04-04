package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int val1=0;
    private int val2=0;
    private String operation="";
    private boolean isOp1=true;
    private TextView ch_saisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calsul);
        ch_saisi = findViewById(R.id.textView);
    }


    private void afficher() {
        if(!isOp1)
        {
            ch_saisi.setText( String.valueOf(val1) + " "+ operation + " " + String.valueOf(val2)); }
        else
        {
            ch_saisi.setText(String.valueOf(val1)); }
    }


    public void setOperator(View v) {
        switch (v.getId()) {
            case R.id.bu_plus  : operation="+";  break;
            case R.id.bu_moin:  operation="-"; break;
            case R.id.bu_multi:   operation="*";  break;
            case R.id.bu_slash:   operation="/";  break;
            default:
                return; // do nothing if no operator
        }
        isOp1=false;
        afficher();
    }


    public void ajouterChiffre(View v){
        int val = Integer.parseInt(((Button)v).getText().toString());

        if (isOp1) {
            val1 = val1 * 10 + val;
            afficher();
        } else {
            val2 = val2 * 10 + val;
            afficher();
        }
    }


    public void calculer(View view) {
        if(!isOp1){
            switch(operation) {
                case "+" : val1 = val1 + val2; break;
                case "-" : val1 = val1 - val2; break;
                case "*" : val1 = val1 * val2; break;
                case "/" : val1 = val1 / val2; break;
                default : return; // do nothing if no operator
            }
            val2 = 0;
            isOp1 = true;
            afficher();
        }
    }


    public void Reset(View view) {
        val1=0; val2=0; isOp1=true;
        operation="";
        afficher();
    }

}