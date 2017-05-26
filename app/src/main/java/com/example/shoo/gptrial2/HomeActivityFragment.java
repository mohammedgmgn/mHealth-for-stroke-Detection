package com.example.shoo.gptrial2;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.sql.BatchUpdateException;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {

    BluetoothAdapter bluetoothAdapter;

    public HomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView= inflater.inflate(R.layout.fragment_home, container, false);

        Button check = (Button)rootView.findViewById(R.id.btnCHeck);


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

                if(bluetoothAdapter==null)
                    Toast.makeText(getActivity(), "No bluetooth was found", Toast.LENGTH_SHORT).show();
                else
                {
                    if(!bluetoothAdapter.isEnabled())
                    {
                        Intent enabledIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(enabledIntent,1);

                    }
                }

                Intent i = new Intent(getActivity(),HomeActivityFragment.class);
                getActivity().startService(i);
            }
        });
        return rootView;
    }

}
