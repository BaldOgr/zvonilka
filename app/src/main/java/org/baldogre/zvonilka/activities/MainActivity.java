package org.baldogre.zvonilka.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.baldogre.zvonilka.R;
import org.baldogre.zvonilka.adapter.ClientAdapter;
import org.baldogre.zvonilka.entity.Client;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClientAdapter adapter = new ClientAdapter(new ArrayList<Client>(), getApplicationContext());
        listView = (ListView) findViewById(R.id.main_activity_list);
        new GetList(adapter, MainActivity.this, listView).execute();
    }

    private class GetList extends AsyncTask{
        ClientAdapter adapter;
        Context context;
        ProgressDialog dialog;
        ListView listView;


        public GetList(ClientAdapter adapter, Context context, ListView listView) {
            this.adapter = adapter;
            this.context = context;
            this.listView = listView;
        }

        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(context, "Loading..", "Loading...");
        }

        @Override
        protected Object doInBackground(Object[] params) {
            Client client = new Client();
            client.setName("Daniyar");
            client.setPhoneNumber("87011222339");
            client.setNote("Cool guy");
            adapter.addClient(client);
            try {
                Thread.sleep(2000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i("Backendless API", "Done");
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            adapter.notifyDataSetChanged();
            listView.setAdapter(adapter);
            dialog.cancel();
        }
    }
}
