package com.example.android_practica9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.android_practica9.adapters.PermisoAdapter;
import com.example.android_practica9.models.Equipo;
import com.example.android_practica9.models.Permiso;
import android.Manifest;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements PermisoAdapter.OnCheckedChangeListener {
    private String[] permissionsToCheck = {
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CALL_PHONE
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List <Permiso> Lista_permisos = new ArrayList<>();
        Lista_permisos.add(new Permiso("Camara",Manifest.permission.CAMERA));
        Lista_permisos.add(new Permiso("Microfono",Manifest.permission.RECORD_AUDIO));
        Lista_permisos.add(new Permiso("Llamada",Manifest.permission.CALL_PHONE));


        PermisoAdapter permisoAdapter= new PermisoAdapter(Lista_permisos);
        RecyclerView recyclerView =findViewById(R.id.Rpermisos);
        recyclerView.setAdapter(permisoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        permisoAdapter.setOnCheckedChangeListener(this);

        if(checkAllPermissionsGranted()){
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
        }
        /*permisoAdapter.setOnCheckedChangeListener(new PermisoAdapter.OnCheckedChangeListener() {
            @Override
            public void OnChecked(int position, Permiso model) {
                if (ContextCompat.checkSelfPermission(MainActivity2.this, model.getPermiso()) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity2.this, new String[]{model.getPermiso()}, 3600);
                }
            }
        });*/
    }


    @Override
    public void OnChecked(int position, Permiso model) {
        if (ContextCompat.checkSelfPermission(MainActivity2.this, model.getPermiso()) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity2.this, new String[]{model.getPermiso()}, 3600);
        }
    }

    private boolean checkAllPermissionsGranted() {
        for (String permission : permissionsToCheck) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 3600) { // Verifica que es el código de solicitud que estás esperando
            if (checkAllPermissionsGranted()) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            } else {
                // Aquí puedes manejar el caso en el que no se hayan concedido todos los permisos.
            }
        }
    }
}