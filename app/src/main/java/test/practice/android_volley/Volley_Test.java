package test.practice.android_volley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
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

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import test.practice.R;
import test.practice.android_parser.ParseManager;
import test.practice.android_volley.model.MainObjectResponse;

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
        findViewById(R.id.but_volley_catch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pDialog.show();
                //Like below you can check for a cached response of an URL before making a network call.
                checkCatchedResponse();

                requestPrioritisation();
            }
        });

        findViewById(R.id.but_volley).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pDialog.show();

                objectRequest();
                //arrayRequest();
                //stringRequest();
                //addingPostParameters();
                //addingRequestHeader();
                //makingImageRequest();

            }
        });

    }

    private void requestPrioritisation() {

        /*
        * If you are making multiple request at the same time, you can prioritize the requests those you want be executed first.
        * The priory can be Normal, Low, Immediate and High.
        * */

        final Request.Priority priority = Request.Priority.HIGH;

        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d("Response  :", response.toString());
                txt_result.setText(response.toString());
                pDialog.dismiss();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error  : ", "Error: " + error.getMessage());
                pDialog.dismiss();
            }
        }) {
            @Override
            public Priority getPriority() {
                return priority;
            }

        };
    }

    private void setTextView(String data)
    {
        if(txt_result.getText().length() > 1)
        {
            txt_result.setText(txt_result.getText().toString() + "\n" + data);
        }else {
            txt_result.setText(data);
        }

    }

    private void checkCatchedResponse() {

        /*
        *
        * 1) Loading request from cache :
        * Like below you can check for a cached response of an URL before making a network call.
        * */

        /*Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(url);
        if(entry != null){
            try {
                String data = new String(entry.data, "UTF-8");
                txt_result.setText(data.toString());
                // handle data, like converting it to xml, json, bitmap etc.,
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        else{
        // Cached response doesn't exists. Make network call here
         }*/


         /*
         * 2) Invalidate cache :
         * Invalidate means we are invalidating the cached data instead of deleting it. Volley will still uses the cached object
         * until the new data received from server. Once it receives the response from the server it will override the older cached
         * response.
         * */

        //AppController.getInstance().getRequestQueue().getCache().invalidate(url, true);


        /*
        * 3) Turning off cache :
        * If you want disable the cache for a particular url, you can use setShouldCache() method as below.
        * */

        // lets suppose we have string request :
        //StringRequest stringReq = new StringRequest(....);

        // disable cache
        //stringReq.setShouldCache(false);


        /*
        * 4) Deleting cache for particular URL :
        * Use remove() to delete cache of an URL.
        * */
        //AppController.getInstance().getRequestQueue().getCache().remove(url);


        /*
        * 5) Deleting all the cache :
        * Followoing will delete the cache for all the URLs.
        * */

        AppController.getInstance().getRequestQueue().getCache().clear();



        /*
        *
        * 6) Missing! Making XML request
        * As of now volley doesn’t provided any native classes to make XML requests, but this can be achieved by building a
        * custom xml wrapper class by utilizing volley’s customization capabilities. The part of writing xml parser using
        * volley will be covered in upcoming tutorial.
        * */



        pDialog.dismiss();

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

                        MainObjectResponse utosearchresultHome = ParseManager.getInstance().fromJSON(response, MainObjectResponse.class);

                        setTextView(utosearchresultHome.getEmail()+"\n"+utosearchresultHome.getName());
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
