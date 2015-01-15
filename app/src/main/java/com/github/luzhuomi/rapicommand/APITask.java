package com.github.luzhuomi.rapicommand;

import android.os.AsyncTask;
import android.util.Log;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Created by luzm on 15/1/15.
 */
class APITask extends AsyncTask<String, Void, Boolean> {

    private Exception exception;


    protected Boolean doInBackground(String... urls) {
        try {
            URL API = new URL(urls[0]);

            BufferedReader in = new BufferedReader(new InputStreamReader(API.openStream()));

            String response = in.readLine();
            return true;

        } catch (Exception e) {
            this.exception = e;
            return false;
        }
    }

    protected void onPostExecute(Boolean b) {

        // TODO: check this.exception
        if (! b) {
            Log.d("Err", this.exception.toString());
        }
    }
}
