 package com.example.justjavaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.MailTo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

 public class MainActivity extends AppCompatActivity {
int numberOfCofee=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("MainActivity", "has sandwich :");
    }
    //from here all the coding start
    public void submitOrder(View view){
        CheckBox whippedCreamCheckBox=findViewById(R.id.checkboxsand);
        boolean hasSandwich=whippedCreamCheckBox.isChecked();
        CheckBox choclateCheckBox=findViewById(R.id.checkboxchoc);
        boolean hasChoclate=choclateCheckBox.isChecked();


        EditText names=findViewById(R.id.nameText);
String name=names.getText().toString();

//       Practicing with intents ,intent is not working

//       Intent intent =new Intent(Intent.ACTION_VIEW);
//       intent.setData(Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
//working intents for maps
//        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
//        startActivity(intent);
//
        String message="Name : "+name+" \n checked state\n sandWich:"+hasSandwich+"\nchoclate:"+hasChoclate+"\nNo of sandwich:"+numberOfCofee+"\n total Price: "+displayCoffeePrice(numberOfCofee,hasChoclate,hasSandwich)+"\n Thank you!";

        //intents for gmail

//
//

                displayMessage(message);
        String addresses="sadi rupandehi";
        String subject="related to intent filter";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:jitendrakohar05@gmail.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
        startActivity(intent);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent); }

    }
    private void display(int numberOfCofee){
        TextView textView2=(TextView) findViewById(R.id.textView1);

            textView2.setText("" + numberOfCofee);


    }
    /*This  method display display the price of the cofee
    * */
 private String displayCoffeePrice(int number,boolean hasSandwich,boolean hasChoclate){
     TextView priceTextView=(TextView) findViewById(R.id.textView3);
     String price="";
     int basePrice = 5;
     if(number>=0) {

         if (hasChoclate) {
             basePrice = basePrice + 1;
         }
         if (hasSandwich) {
             basePrice = basePrice + 2;
         }
         price = NumberFormat.getCurrencyInstance().format(number * basePrice);


     }
     return price;
 }

 //adding the no of coffee in the firstTextview
     public void addCoffees(View view) {
if(numberOfCofee>=100){
    Toast.makeText(getApplicationContext(),"maximum no of coffee reached ",Toast.LENGTH_LONG).show();
    return;
}
            numberOfCofee=numberOfCofee+1;
            display(numberOfCofee);

     }
//Removing the number of coffee from the first textView

     public void removeCoffees(View view) {
     if(numberOfCofee<1){
         Toast.makeText(getApplicationContext(),"you have to add at least 1 cup of coffee", Toast.LENGTH_SHORT).show();
         return;
     }
         --numberOfCofee;
         display(numberOfCofee);

 }
 private void displayMessage(String message){
    TextView priceTextView=(TextView) findViewById(R.id.textView3);
    priceTextView.setText(message+"");
     }

 }