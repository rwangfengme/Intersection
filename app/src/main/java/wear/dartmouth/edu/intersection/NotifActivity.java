package wear.dartmouth.edu.intersection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.wearable.activity.WearableActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by _ReacTor on 16/2/25.
 */
public class NotifActivity extends WearableActivity{
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);

        Timer t = new Timer();
        //Set the schedule function and rate
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //Called each time when 1000 milliseconds (1 second) (the period parameter)
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://intersectionserver-1232.appspot.com/has_matched/de13e234554";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                if(response.equals("yes")){
                                    doVibration();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }}, 5000, 5000);
    }

    private void doVibration(){
        Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        long[] pattern = {0, 500, 500};
        vb.vibrate(pattern, 5);
    }
}
