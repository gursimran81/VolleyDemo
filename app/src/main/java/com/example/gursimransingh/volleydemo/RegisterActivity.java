package com.example.gursimransingh.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    RequestQueue requestQueue;

    StringRequest request;
    String url = "http://adserver81.pe.hu/VolleyDemo/insert.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Initialize RequestQueue
        requestQueue = Volley.newRequestQueue(this);
    }

    public void clickHandler(View view){

        //String name = eTxtName.getText().toString().trim();

      /*request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
          @Override
          public void onResponse(String response) {
              Toast.makeText(MainActivity.this,"Response: "+response,Toast.LENGTH_LONG).show();
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
              Toast.makeText(MainActivity.this,"Error: "+error,Toast.LENGTH_LONG).show();
          }
      });*/

        
        request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("name","John Watson");
                map.put("email","john@example.com");
                map.put("password","password123");
                return map;
            }
        }
        ;


        requestQueue.add(request); // Execution of Request

    }
}
