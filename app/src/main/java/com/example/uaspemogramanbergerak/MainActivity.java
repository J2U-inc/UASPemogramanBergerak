package com.example.uaspemogramanbergerak;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View view){// tombol tambah
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }
    public void decrement(View view){// tombol kurang
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }


    public void Submitorder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.edt_name);
        String name=nameEditText.getText().toString();
        Log.v("MainActivity","Nama:"+name);

        CheckBox checkBoxFloat= (CheckBox) findViewById(R.id.checkboxFloat);
        boolean hasBoba=checkBoxFloat.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+hasBoba);

        CheckBox checkBoxBoba= (CheckBox) findViewById(R.id.checkboxBoba);
        boolean hascoklat=checkBoxBoba.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+hascoklat);

        CheckBox checkBoxKeju= (CheckBox) findViewById(R.id.checkboxKeju);
        boolean haskeju=checkBoxKeju.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+haskeju);

        CheckBox checkBoxChocomilk= (CheckBox) findViewById(R.id.checkboxCocomilk);
        boolean haschocomilk=checkBoxChocomilk.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+haschocomilk);

        CheckBox checkBoxBananmilk= (CheckBox) findViewById(R.id.checkboxBananmilk);
        boolean hasbananamilk=checkBoxBananmilk.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+hasbananamilk);

        CheckBox checkBoxStrawberrymilk= (CheckBox) findViewById(R.id.checkboxStrawberrymilk);
        boolean hasstrawberrymilk=checkBoxKeju.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+hasstrawberrymilk);

        int price=calculateprice(haskeju,hasBoba,hascoklat,haschocomilk,hasbananamilk,hasstrawberrymilk);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price,name,hasBoba,hascoklat,haskeju,haschocomilk,hasbananamilk,hasstrawberrymilk);


        displayMessage(pricemessage);

    }
    private int calculateprice(boolean addChoco, boolean addBanana, boolean addStrawberry,
                               boolean addKeju, boolean addBoba, boolean addCoklat){
        int harga=0;

        if(addBoba){
            harga=harga+5000;
        }

        if (addCoklat){
            harga=harga+5000;
        }

        if (addKeju){
            harga=harga+5000;
        }

        if (addChoco){
            harga=harga+10000;
        }

        if (addBanana){
            harga=harga+10000;
        }

        if (addStrawberry){
            harga=harga+10000;
        }

        return quantity * harga;
    }
    private String createOrderSummary(int price, String name, boolean boba, boolean hascoklat, boolean haskeju, boolean hasBoba, boolean addChocolate, boolean addWhippedCream) {//hasil pemesanan
        String pricemessage=" Nama = "+name;
//        pricemessage+="\n Tambahkan Coklat =" +addWhippedCream;
//        pricemessage+="\n Tambahkan Krim =" +addChocolate;
        pricemessage+="\n Jumlah Pemesanan =" +quantity;
        pricemessage+="\n Total = Rp " +price;
        pricemessage+="\n\n Terimakasih !";
        return  pricemessage;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}