package com.zack.ok.bankfinder;

import android.os.AsyncTask;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class FetchData1 extends AsyncTask<Void,Void,Void> {
    String data="";
    public String name;
    public EditText editText;
    String dataparsed="";
    String singleparsed="";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url=new URL("http:// 192.168.42.16:8080/api/findByname/+name");
            name=(EditText.AUTOFILL_HINT_NAME);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while (line!=null){
                line=bufferedReader.readLine();
                data=data+line;
            }
            JSONArray JA=new JSONArray(data);
            for(int i=0;i<JA.length();i++){
                JSONObject JO= (JSONObject) JA.get(i);
                singleparsed=
                        "Bank_Name: "+JO.get("Bank_Name")+"\n"+
                                "Bank_Address: "+JO.get("Bank_Address")+"\n"+
                                "Longitude: "+JO.get("Longitude")+"\n"+
                                "Latitude: "+JO.get("Latitude")+"\n";
                dataparsed=dataparsed+singleparsed+"\n";
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
