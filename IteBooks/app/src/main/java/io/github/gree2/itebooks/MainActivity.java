package io.github.gree2.itebooks;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import io.github.gree2.itebooks.app.AppController;
import io.github.gree2.itebooks.app.Const;
import io.github.gree2.itebooks.model.Search;
import io.realm.Realm;


public class MainActivity extends ActionBarActivity {

    private static String TAG = MainActivity.class.getSimpleName();

    private Button button;
    private TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // findView
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.text_view);
        // click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSearch();
            }
        });
    }

    private void doSearch(){

        final Context context = this;
        final TextView tv = textView;
        // request data
        final StringRequest request = new StringRequest(Request.Method.GET, Const.URL_SEARCH + "android",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {

                        Realm realm = Realm.getInstance(context);
                        realm.beginTransaction();
                        Search search = realm.createObjectFromJson(Search.class, response);
                        Log.d(TAG, search.getError());
                        Log.d(TAG, String.valueOf(search.getTime()));
                        Log.d(TAG, search.getTotal());
                        Log.d(TAG, String.valueOf(search.getPage()));
                        realm.commitTransaction();
                        tv.post(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText(response);
                            }
                        });

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                    }
                });
        Log.d(TAG, request.getUrl());

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(request);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
