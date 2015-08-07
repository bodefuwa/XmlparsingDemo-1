package com.satish.xmlparsingdemo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{
    private ListView listView;
    private ArrayList<ListData> listdata;
    CustomAdapter adapter;
    private ProgressDialog progressDialog;
    private String TAG=MainActivity.class.getSimpleName();
    private static String URL = "http://api.androidhive.info/pizza/?format=xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.list_view);

        listdata=new ArrayList<>();

        progressDialog = new ProgressDialog(this);

        adapter=new CustomAdapter(listdata, this);

        listView.setAdapter(adapter);

        new XmlGet().execute();
    }
    public class XmlGet extends AsyncTask<Void, Void, Void> {

            @Override
            protected void onPreExecute() {
                // Before starting background task
                // Show Progress Dialog etc,.
               progressDialog.setMessage("Please wait...");
               progressDialog.show();

            }


        protected Void doInBackground(Void... unused) {

            Log.e(TAG, "doInBackground");

            XMLParser parser = new XMLParser();

            String xml = parser.getXmlFromUrl(URL);

            Document doc = parser.getDomElement(xml); // getting DOM element

            NodeList nl = doc.getElementsByTagName("item");

            for(int i = 0; i < nl.getLength(); i++){

                Element e = (Element) nl.item(i);

                String name = parser.getValue(e, "name");
                String description=parser.getValue(e, "description");
                String id=parser.getValue(e, "id");
                String cost=parser.getValue(e,"cost");
                Log.e(TAG, "Name: " + description);

                ListData data = new ListData();
                data.setName(name);
                data.setDescription(description);
                data.setId(id);
                data.setCost(cost);
                listdata.add(data);
            }



            return null;
        }


        protected void onPostExecute(Void unused) {
            // On completing background task
            // closing progress dialog etc,.
            adapter.notifyDataSetChanged();

            progressDialog.dismiss();
        }
    }

}
