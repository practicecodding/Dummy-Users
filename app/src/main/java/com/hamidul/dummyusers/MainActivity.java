package com.hamidul.dummyusers;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.health.connect.datatypes.StepsCadenceRecord;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;
    Toast toast;
    GridView gridView;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        gridView = findViewById(R.id.gridView);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        loadServer();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadServer();
            }
        });

    }//onCreate Bundle==============================================================================

    private void loadServer(){
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://dummyjson.com/users";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressBar.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
                arrayList = new ArrayList<>();
                try {

                    JSONArray jsonArray = response.getJSONArray("users");

                    for (int x=0; x<jsonArray.length();x++){
                        JSONObject jsonObject = jsonArray.getJSONObject(x);

                        String id = jsonObject.getString("id");
                        String firstName = jsonObject.getString("firstName");
                        String lastName = jsonObject.getString("lastName");
                        String maidenName = jsonObject.getString("maidenName");
                        String age = jsonObject.getString("age");
                        String gender = jsonObject.getString("gender");
                        String email = jsonObject.getString("email");
                        String phone = jsonObject.getString("phone");
                        String username = jsonObject.getString("username");
                        String password = jsonObject.getString("password");
                        String birthDate = jsonObject.getString("birthDate");
                        String image = jsonObject.getString("image");
                        String bloodGroup = jsonObject.getString("bloodGroup");
                        String height = jsonObject.getString("height");
                        String weight = jsonObject.getString("weight");
                        String eyeColor = jsonObject.getString("eyeColor");

                        JSONObject objectHair = jsonObject.getJSONObject("hair");
                        String hairColor = objectHair.getString("color");
                        String hairType = objectHair.getString("type");

                        String domain = jsonObject.getString("domain");
                        String ip = jsonObject.getString("ip");

                        JSONObject objectAddress = jsonObject.getJSONObject("address");
                        String address = objectAddress.getString("address")+", "+objectAddress.getString("city");

                        JSONObject objectCoordinates = objectAddress.getJSONObject("coordinates");
                        String location = objectCoordinates.getString("lat")+", "+objectCoordinates.getString("lng");

                        String postalCode = objectAddress.getString("postalCode");
                        String state = objectAddress.getString("state");

                        String macAddress = jsonObject.getString("macAddress");
                        String university = jsonObject.getString("university");

                        JSONObject objectBank = jsonObject.getJSONObject("bank");
                        String cardExpire = objectBank.getString("cardExpire");
                        String cardNumber = objectBank.getString("cardNumber");
                        String cardType = objectBank.getString("cardType");
                        String currency = objectBank.getString("currency");
                        String iban = objectBank.getString("iban");

                        JSONObject objectCompany = jsonObject.getJSONObject("company");
                        JSONObject companyObjectAddress = objectCompany.getJSONObject("address");
                        String companyAddress = companyObjectAddress.getString("address");
                        String companyCity = companyObjectAddress.optString("city");
                        JSONObject companyObjectCoordinates = companyObjectAddress.getJSONObject("coordinates");
                        String companyLocation = companyObjectCoordinates.optString("lat")+", "+companyObjectCoordinates.optString("lng");
                        String companyPostalCode = companyObjectAddress.getString("postalCode");
                        String companyState = companyObjectAddress.getString("state");
                        String companyDepartment = objectCompany.getString("department");
                        String companyName = objectCompany.getString("name");
                        String companyTitle = objectCompany.getString("title");

                        String ein = jsonObject.getString("ein");
                        String ssn = jsonObject.getString("ssn");
                        String userAgent = jsonObject.getString("userAgent");

                        hashMap = new HashMap<>();
                        hashMap.put("id",id );
                        hashMap.put("name",firstName+" "+maidenName+" "+lastName);
                        hashMap.put("email",email);
                        hashMap.put("phone",phone);
                        hashMap.put("gender",gender);
                        hashMap.put("age",age);
                        hashMap.put("username",username);
                        hashMap.put("password",password);
                        hashMap.put("birthDate",birthDate);
                        hashMap.put("image",image);
                        hashMap.put("bloodGroup",bloodGroup);
                        hashMap.put("height",height);
                        hashMap.put("weight",weight);
                        hashMap.put("eyeColor",eyeColor);
                        hashMap.put("hairColor",hairColor);
                        hashMap.put("hairType",hairType);
                        hashMap.put("domain",domain);
                        hashMap.put("ip",ip);
                        hashMap.put("address",address);
                        hashMap.put("location",location);
                        hashMap.put("postalCode",postalCode);
                        hashMap.put("state",state);
                        hashMap.put("macAddress",macAddress);
                        hashMap.put("university",university);
                        hashMap.put("cardExpire",cardExpire);
                        hashMap.put("cardNumber",cardNumber);
                        hashMap.put("cardType",cardType);
                        hashMap.put("currency",currency);
                        hashMap.put("iban",iban);
                        hashMap.put("companyAddress",companyAddress);
                        hashMap.put("companyCity",companyCity);
                        hashMap.put("companyLocation",companyLocation);
                        hashMap.put("companyPostalCode",companyPostalCode);
                        hashMap.put("companyState",companyState);
                        hashMap.put("companyDepartment",companyDepartment);
                        hashMap.put("companyName",companyName);
                        hashMap.put("companyTitle",companyTitle);
                        hashMap.put("ein",ein);
                        hashMap.put("ssn",ssn);
                        hashMap.put("userAgent",userAgent);
                        arrayList.add(hashMap);

//                        textView.append("ID : "+id+"\n\nFirst Name : "+firstName+"\n\nLast Name : "+lastName+"\n\nMaid Name : "+maidenName+"\n\nAge : "+age+"\n\nGender : "+gender+"\n\nEmail : "+email+"\n\nPhone : "+phone+"\n\nUser Name : "+username+"\n\nPassword : "+password+ "\n\nBirth Date : "+birthDate+"\n\nImage : "+image+"\n\nBlood Group : "+bloodGroup+"\n\nHeight : "+height+"\n\nWeight : " +weight +"\n\nEye Color : "+eyeColor+
//                                "\n\nHair : "+color+", "+type+"\n\nDomain : "+domain+"\n\nIP : "+ip+"\n\nAddress : "+address+"\n\nLocation : "+location+
//                                "\n\nPostal Code : "+postalCode+"\n\nState : "+state+"\n\nMac Address : "+macAddress+"\n\nUniversity : "+university+
//                                "\n\nCard Expire : "+cardExpire+"\n\nCard Number : "+cardNumber+"\n\nCard Type : "+cardType+"\n\nCurrency : "+currency+"\n\nIban : "+iban+"\n\nCompany Address : "+companyAddress+", "+companyCity+
//                                "\n\nCompany Location : "+companyLocation+"\n\nCompany PostalCode : "+companyPostalCode+"\n\nCompany State : "+companyState+"\n\nCompany Department : "+companyDepartment+"\n\nCompany Name : "+companyName+"\n\nCompany Title : "+companyTitle+"\n\nEin : "+ein+"\n\nSsn : "+ssn+"\n\nUser Agent : "+userAgent+"\n\n\n\n");

                    }// for loop end

                    MyAdapter myAdapter = new MyAdapter();
                    gridView.setAdapter(myAdapter);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
                toastMessage("Volley Error");
            }
        });
        requestQueue.add(jsonObjectRequest);

    }//loadServer method end

    private void toastMessage (String text){
        if (toast!=null) toast.cancel();
        toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT);
        toast.show();
    }// toastMessage method end

    private class MyAdapter extends BaseAdapter{
        LayoutInflater layoutInflater;
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.item,parent,false);

            ImageView imageView = myView.findViewById(R.id.imageView);
            TextView itemName = myView.findViewById(R.id.itemName);
            TextView itemEmail = myView.findViewById(R.id.itemEmail);
            TextView itemPhone = myView.findViewById(R.id.itemPhone);
            CardView cardView = myView.findViewById(R.id.cardView);

            HashMap<String,String> hashMap1 = arrayList.get(position);
            String id = hashMap1.get("id");
            String name = hashMap1.get("name");
            String email = hashMap1.get("email");
            String phone = hashMap1.get("phone");
            String gender = hashMap1.get("gender");
            String age = hashMap1.get("age");
            String username = hashMap1.get("username");
            String password = hashMap1.get("password");
            String birthDate = hashMap1.get("birthDate");
            String image = hashMap1.get("image");
            String bloodGroup = hashMap1.get("bloodGroup");
            String height = hashMap1.get("height");
            String weight = hashMap1.get("weight");
            String eyeColor = hashMap1.get("eyeColor");
            String hairColor = hashMap1.get("hairColor");
            String hairType = hashMap1.get("hairType");
            String domain = hashMap1.get("domain");
            String ip = hashMap1.get("ip");
            String address = hashMap1.get("address");
            String location = hashMap1.get("location");
            String postalCode = hashMap1.get("postalCode");
            String state = hashMap1.get("state");
            String macAddress = hashMap1.get("macAddress");
            String university = hashMap1.get("university");
            String cardExpire = hashMap1.get("cardExpire");
            String cardNumber = hashMap1.get("cardNumber");
            String cardType = hashMap1.get("cardType");
            String currency = hashMap1.get("currency");
            String iban = hashMap1.get("iban");
            String companyAddress = hashMap1.get("companyAddress");
            String companyCity = hashMap1.get("companyCity");
            String companyLocation = hashMap1.get("companyLocation");
            String companyPostalCode = hashMap1.get("companyPostalCode");
            String companyState = hashMap1.get("companyState");
            String companyDepartment = hashMap1.get("companyDepartment");
            String companyName = hashMap1.get("companyName");
            String companyTitle = hashMap1.get("companyTitle");
            String ein = hashMap1.get("ein");
            String ssn = hashMap1.get("ssn");
            String userAgent = hashMap1.get("userAgent");

            itemName.setText(": "+name);
            itemEmail.setText(": "+email);
            itemPhone.setText(": "+phone);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Details.image = image;
                    Details.id = id;
                    Details.sName = name;
                    Details.email = email;
                    Details.phone = phone;
                    Details.gender = gender;
                    Details.age = age;
                    Details.username = username;
                    Details.password = password;
                    Details.birthDate = birthDate;
                    Details.bloodGroup = bloodGroup;
                    Details.height = height;
                    Details.weight = weight;
                    Details.eyeColor = eyeColor;
                    Details.hairColor = hairColor;
                    Details.hairType = hairType;
                    Details.domain = domain;
                    Details.ip = ip;
                    Details.address = address;
                    Details.location = location;
                    Details.postalCode = postalCode;
                    Details.state = state;
                    Details.macAddress = macAddress;
                    Details.university = university;
                    Details.cardExpire = cardExpire;
                    Details.cardNumber = cardNumber;
                    Details.cardType = cardType;
                    Details.currency = currency;
                    Details.iban = iban;
                    Details.companyAddress = companyAddress;
                    Details.companyCity = companyCity;
                    Details.companyLocation = companyLocation;
                    Details.companyPostalCode = companyPostalCode;
                    Details.companyState = companyState;
                    Details.companyDepartment = companyDepartment;
                    Details.companyName = companyName;
                    Details.companyTitle = companyTitle;
                    Details.ein = ein;
                    Details.ssn = ssn;
                    Details.userAgent = userAgent;

                    startActivity(new Intent(MainActivity.this,Details.class));

                }
            });

            if (gender.contains("female")){
                imageView.setImageResource(R.drawable.female_icon);
            }

            return myView;
        }
    }// MyAdapter method end


}//AppCompatActivity================================================================================
