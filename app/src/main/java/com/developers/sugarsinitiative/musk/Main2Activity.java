package com.developers.sugarsinitiative.musk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    String Message;
    double sweet;
    String crt;
    String Genders;
    String Age;
    String Weights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        Bundle extras = getIntent().getExtras();
        crt = extras.getString("crt");
         Genders = extras.getString("Genders");
         Age = extras.getString("Age");
       Weights = extras.getString("Weights");
       sweet = extras.getDouble("i");

        TextView serumCreatinine = (TextView) findViewById(R.id.serumCreatinine);
        serumCreatinine.setText(crt);

        TextView AGE = (TextView) findViewById(R.id.age);
        AGE.setText(Age);

        TextView WEIGHT = (TextView) findViewById(R.id.weight);
        WEIGHT.setText(Weights);

        TextView Gender = (TextView) findViewById(R.id.gender);
        Gender.setText(Genders);

        TextView Gfr = (TextView) findViewById(R.id.Gfr);
        Gfr.setText(String.valueOf(sweet));


    }

    public void MailMessage(View button) {
        if (sweet >= 90) {
            Message = "The " +Genders + " patient aged " +Age+ " years, and weighing " + Weights +" kg, with a serum creatinine value of " +crt +" mg/dl " +
                    "has stage 1 kidney damage with normal and increased GFR, and a gfr value of " + sweet+ " mil/mn";
        } else if (60 <= sweet && sweet <= 89) {

            Message = "The  " +Genders + " patient aged " +Age+ " years, and weighing " + Weights +" kg, with a serum creatinine value of " +crt +" mg/dl " +
                    "has stage 2 kidney damage with mild decrease in GFR, and a GFR Value of " + sweet+ " mil/mn";

        } else if (30 <= sweet && sweet <= 59) {
            Message = "The " +Genders + " patient aged " +Age+ " years, and weighing " + Weights +" kg, with a serum creatinine value of " +crt +" mg/dl " +
                    " has stage 3 kidney damage with moderately lowered GFR, and a GFR Value of " + sweet+ " mil/mn";

        } else if (15 <= sweet && sweet <= 29) {
            Message = "The " +Genders + " patient aged " +Age+ " years, and weighing " + Weights +" kg, with a serum creatinine value of " +crt +" mg/dl " +
                    " has stage 4 kidney damage with severely lowered GFR, and a GFR Value of " + sweet+ " mil/mn";

        } else {
            Message  = "The " +Genders + " patient aged " +Age+ " years, and weighing " + Weights +" kg, with a serum creatinine value of " +crt +" mg/dl " +
                    " has stage 5 Kidney damage(Kidney failure), and a GFR Value of " + sweet + " mil/mn";
        }

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("Message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{});
        i.putExtra(Intent.EXTRA_SUBJECT, "Patient Result");
        i.putExtra(Intent.EXTRA_TEXT, Message);
        try {
            startActivity(Intent.createChooser(i, "send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "none", Toast.LENGTH_SHORT).show();
        }
    }
}
