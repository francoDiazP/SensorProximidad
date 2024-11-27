package com.example.sensorproximidad;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    //Declarar las variables de interfaz de usuario.

    TextView tv;
    LinearLayout ln;
    SensorManager sm;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ln = findViewById(R.id.main);

        tv = findViewById(R.id.tv);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    //Actualizar el TextView con valor actual del sensor de proximidad.
    @Override
    public void onSensorChanged(SensorEvent event) {
        String text = String.valueOf(event.values[0]);
        tv.setText(text);
        float valor = Float.parseFloat(text);
        if(valor == 0){
            ln.setBackgroundColor(Color.GREEN);

        }else{
            ln.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}