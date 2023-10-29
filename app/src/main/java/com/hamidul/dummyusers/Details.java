package com.hamidul.dummyusers;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {
    TextView textView;
    public static String id = "";
    public static String sName = "";
    public static String email = "";
    public static String phone = "";
    public static String gender = "";
    public static String age = "";
    public static String username = "";
    public static String password = "";
    public static String birthDate = "";
    public static String image = "";
    public static String bloodGroup = "";
    public static String height = "";
    public static String weight = "";
    public static String eyeColor = "";
    public static String hairColor = "";
    public static String hairType = "";
    public static String domain = "";
    public static String ip = "";
    public static String address = "";
    public static String location = "";
    public static String postalCode = "";
    public static String state = "";
    public static String macAddress = "";
    public static String university = "";
    public static String cardExpire = "";
    public static String cardNumber = "";
    public static String cardType = "";
    public static String currency = "";
    public static String iban = "";
    public static String companyAddress = "";
    public static String companyCity = "";
    public static String companyLocation = "";
    public static String companyPostalCode = "";
    public static String companyState = "";
    public static String companyDepartment = "";
    public static String companyName = "";
    public static String companyTitle = "";
    public static String ein = "";
    public static String ssn = "";
    public static String userAgent = "";
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

        Picasso.get().
                load(image)
                .into(imageView);

        textView.append("ID : "+id+"\n\nName : "+sName+"\n\nAge : "+age+"\n\nGender : "+gender+"\n\nEmail : "+email+"\n\nPhone : "+phone+"\n\nUser Name : "+username+"\n\nPassword : "+password+ "\n\nBirth Date : "+birthDate+"\n\nBlood Group : "+bloodGroup+"\n\nHeight : "+height+"\n\nWeight : " +weight +"\n\nEye Color : "+eyeColor+
                "\n\nHair Color: "+hairColor+"\n\nHair Type : "+hairType+"\n\nDomain : "+domain+"\n\nIP : "+ip+"\n\nAddress : "+address+"\n\nLocation : "+location+
                "\n\nPostal Code : "+postalCode+"\n\nState : "+state+"\n\nMac Address : "+macAddress+"\n\nUniversity : "+university+
                "\n\nCard Expire : "+cardExpire+"\n\nCard Number : "+cardNumber+"\n\nCard Type : "+cardType+"\n\nCurrency : "+currency+"\n\nIban : "+iban+"\n\n****Company Details****\n\nCompany Address : "+companyAddress+", "+companyCity+
                "\n\nCompany Location : "+companyLocation+"\n\nCompany PostalCode : "+companyPostalCode+"\n\nCompany State : "+companyState+"\n\nCompany Department : "+companyDepartment+"\n\nCompany Name : "+companyName+"\n\nCompany Title : "+companyTitle+"\n\nEin : "+ein+"\n\nSsn : "+ssn+"\n\nUser Agent : "+userAgent+"\n\n");


    }
}