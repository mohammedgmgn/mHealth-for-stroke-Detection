package com.example.shoo.gptrial2;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import libsvm.svm;

public class LoadDataService extends Service {
    public LoadDataService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override


    public int onStartCommand(Intent intent, int flags, int startId) {

        libsvm.svm_model model = loadModel();
        Toast.makeText(this, String.valueOf(model.nr_class), Toast.LENGTH_SHORT).show();

        //return super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    private File creatFile(InputStream inputStream){
        File f = null;
        try{
            f = new File(getApplicationContext().getFilesDir(), "modelFile");
            f.setWritable(true);
            OutputStream outPut = new FileOutputStream(f);
            byte buffer[] = new byte[1024];
            int length = 0;

            while((length=inputStream.read(buffer)) > 0) {
                outPut.write(buffer,0,length);
            }

            outPut.close();
            inputStream.close();

            return f;
        }catch (IOException e) {
            //Logging exception
            e.printStackTrace();
        }

        return f;
    }

    private  libsvm.svm_model loadModel ()
    {
        libsvm.svm_model model=null;
        InputStream is=null;

        AssetManager am = getApplicationContext().getAssets();

        try {
            is = am.open("modelFile");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File modelFile = creatFile(is);
        String path = modelFile.getAbsolutePath();

        try {
            model = svm.svm_load_model(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  model;
    }

}
