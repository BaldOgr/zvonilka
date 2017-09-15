package org.baldogre.zvonilka.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.baldogre.zvonilka.activities.CallActivity;
import org.baldogre.zvonilka.R;
import org.baldogre.zvonilka.entity.Client;
import org.baldogre.zvonilka.entity.Resources;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniyar on 26.07.17.
 */

public class ClientAdapter extends BaseAdapter {
    List<Client> clients;
    Context context;

    public ClientAdapter(List<Client> clients, Context context) {
        if(clients == null) {
            clients = new ArrayList<>();
        }
        this.clients = clients;
        this.context = context;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return clients.size();
    }

    @Override
    public Client getItem(int position) {
        return clients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("ListView: ", "Client #" + position);
        View view = convertView;

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.client_view_object, null);
        }
        final Client client = getItem(position);
        StringBuilder sb = new StringBuilder();
        TextView textView = (TextView) view.findViewById(R.id.client_view_info);
        sb.append(client.getName()).append("\n").append(client.getNote()).append("\n");
        textView.setText(sb.toString());
        ImageButton button = (ImageButton) view.findViewById(R.id.client_view_call);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CallActivity.class);
                intent.putExtra(Resources.PHONE_NUMBER_KEY, client.getPhoneNumber());
                intent.putExtra(Resources.OBJECT_ID, client.getObjectId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, client.getName() + "\n" + client.getNote(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return clients.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void addClients(List<Client> clients) {
        this.clients.addAll(clients);
    }
}
