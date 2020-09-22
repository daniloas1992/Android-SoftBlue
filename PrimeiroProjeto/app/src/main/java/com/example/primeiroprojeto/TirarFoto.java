package com.example.primeiroprojeto;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class TirarFoto extends AppCompatActivity {

    private static final int ID_REQUEST_CAMERA = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tirar_foto);

        if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

            if(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                Toast.makeText(this, "Necessário liberar permissão de acesso à câmera!", Toast.LENGTH_SHORT).show();
            }else{
                requestPermissions(new String[]{Manifest.permission.CAMERA},ID_REQUEST_CAMERA);
            }
        }else{
            Toast.makeText(this, "Acesso à câmera liberado!", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == ID_REQUEST_CAMERA) {
            if (permissions.length > 0 && permissions[0].equals(Manifest.permission.CAMERA) && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                CameraManager cm = (CameraManager) getSystemService(CAMERA_SERVICE);

                try {
                    String[] idsCameras = cm.getCameraIdList();
                    cm.openCamera(idsCameras[0], new CameraDevice.StateCallback() {
                        @Override
                        public void onOpened(CameraDevice camera) {
                            camera.close();
                        }

                        @Override
                        public void onDisconnected(CameraDevice camera) {
                            camera.close();
                        }

                        @Override
                        public void onError(CameraDevice camera, int error) {
                            camera.close();
                        }
                    }, null);


                } catch (CameraAccessException e) {

                }
            }
        } else{
            Toast.makeText(this, "Acesso à câmera negado!", Toast.LENGTH_SHORT).show();
        }
    }
}
