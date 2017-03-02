package com.example.androidibeacontest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.altbeacon.beacon.Beacon;

import java.util.ArrayList;

// https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView
public class BeaconAdapter extends ArrayAdapter<Beacon> {

    private static final String TAG = "BeaconAdapter";

    public BeaconAdapter(Context context, ArrayList<Beacon> beacons) {
        super(context, R.layout.item_beacon, beacons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Beacon beacon = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_beacon, parent, false);
        }

        // Lookup view for data population
        TextView beaconName = (TextView) convertView.findViewById(R.id.beaconName);
        TextView beaconDistance = (TextView) convertView.findViewById(R.id.beaconDistance);

        // Populate the data into the template view using the data object
        beaconName.setText(beacon.getBluetoothName());
        beaconDistance.setText(String.valueOf(beacon.getDistance()));

        Log.i(TAG, "Beacon name: " + beaconName.getText());
        Log.i(TAG, "Beacon distance: " + beaconDistance.getText());

        // Return the completed view to render on screen
        return convertView;
   }
}
