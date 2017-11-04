package test.practice.android_volley;

import android.app.ProgressDialog;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import test.practice.R;

/**
 * Created by parasmani.sharma on 04/11/2017.
 */

public class Volley_Test extends AppCompatActivity {

    /*
    * Reference : https://www.androidhive.info/2014/05/android-working-with-volley-library-1/
    *
    * */

    private ProgressDialog pDialog;
    private String url = "https://api.androidhive.info/volley/person_object.json";
    private String urlarray = "https://api.androidhive.info/volley/person_array.json";
    private String urlString = "https://api.androidhive.info/volley/string_response.html";
    private String urlImg = "https://www.optiontown.com/images/passes/FPo_Home_Slide_IV.jpg";
    private NetworkImageView netwrk_img;
    private TextView txt_result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_test);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");


        netwrk_img = (NetworkImageView) findViewById(R.id.netwrk_img_view);
        txt_result = (TextView) findViewById(R.id.txt_result);
        findViewById(R.id.but_volley).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pDialog.show();

                objectRequest();
                //arrayRequest();
                //stringRequest();
                //addingPostParameters();
                //addingRequestHeader();
                makingImageRequest();

            }
        });

    }

    private void makingImageRequest() {

        ImageLoader imageLoader = AppController.getInstance().getImageLoader();

        netwrk_img.setImageUrl(urlImg, imageLoader);


        // If you are using normal ImageView
        /*imageLoader.get(urlImg, new ImageLoader.ImageListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Response", "Image Load Error: " + error.getMessage());
            }

            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean arg1) {
                if (response.getBitmap() != null) {
                    // load image into imageview
                    //imageView.setImageBitmap(response.getBitmap());
                }
            }
        });*/


    }

    private void addingRequestHeader() {

        String tag_json_obj = "json_obj_req";

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response : ", response.toString());
                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error : ", "Error: " + error.getMessage());
                pDialog.hide();
            }
        }) {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("apiKey", "xxxxxxxxxxxxxxx");
                return headers;
            }

        };

        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

    private void addingPostParameters() {

        String tag_json_obj = "json_obj_req";

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response : ", response.toString());
                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error : ", "Error: " + error.getMessage());
                pDialog.hide();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "Androidhive");
                params.put("email", "abc@androidhive.info");
                params.put("password", "password123");

                return params;
            }

        };

        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

    private void stringRequest() {

        String  tag_string_req = "string_req";

        StringRequest strReq = new StringRequest(Request.Method.GET,
                urlString, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d("Response : ", response.toString());
                pDialog.hide();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error : ", "Error: " + error.getMessage());
                pDialog.hide();
            }
        });

        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);

    }

    private void arrayRequest() {

        String tag_json_arry = "json_array_req";

        JsonArrayRequest req = new JsonArrayRequest(urlarray,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Response : ", response.toString());
                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error : ", "Error: " + error.getMessage());
                pDialog.hide();
            }
        });

        AppController.getInstance().addToRequestQueue(req, tag_json_arry);

    }

    private void objectRequest() {

        String tag_json_obj = "json_obj_req";

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response ", response.toString());
                        txt_result.setText(response.toString());
                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("", "Error: " + error.getMessage());
                // hide the progress dialog
                pDialog.hide();
            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

    }
}
