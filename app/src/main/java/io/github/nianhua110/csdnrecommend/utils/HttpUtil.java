package io.github.nianhua110.csdnrecommend.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.HttpURLConnection;

import javax.xml.transform.ErrorListener;

/**
 * Created by kankan on 2016/3/20.
 */
public class HttpUtil {

    private static RequestQueue requestQueue ;

    public  static void init(Context context){
        requestQueue = Volley.newRequestQueue(context);
    }

    public  static void sendGet(String  url, Response.Listener<String > listener, Response.ErrorListener errorListener){
        StringRequest stringRequest = new StringRequest(url, listener, errorListener);
        requestQueue.add(stringRequest);
    }
    public static HttpUtil getInstance() {
        if (requestQueue == null) {
            throw new NullPointerException("Call buildRequestQueue method first.");
        }
        //...
        return new HttpUtil();
    }

}
