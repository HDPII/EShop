package lk.example.sensors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer, light, proximity, magnetometer;
    private TextView textAccelerometer, textLight, textProximity, textMagnetometer;
//    private Sensor magnetometer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textAccelerometer = findViewById(R.id.textAccelerometer);
        textLight = findViewById(R.id.textLight);
        textProximity = findViewById(R.id.textProximity);
        textMagnetometer = findViewById(R.id.textMagnetometer);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        Log.i(SensorManager.class.getName(), "SensorManager: " + sensorManager.toString());

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

//        if (accelerometer != null) {
//            sensorManager.registerListener(new SensorEventListener() {
//                @Override
//                public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//                }
//
//                @Override
//                public void onSensorChanged(SensorEvent event) {
//                    String text = String.format("X: %.2f, Y: %.2f, Z: %.2f", event.values[0], event.values[1], event.values[2]);
//                    textAccelerometer.setText(text);
//                }
//            }, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
//
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (light != null) {
            sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (proximity != null) {
            sensorManager.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (magnetometer != null) {
            sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        switch (sensorType){
            case Sensor.TYPE_ACCELEROMETER:
                String text = String.format("X: %.2f, Y: %.2f, Z: %.2f", event.values[0], event.values[1], event.values[2]);
                textAccelerometer.setText(text);
                break;

            case Sensor.TYPE_LIGHT:
                textLight.setText(String.valueOf(event.values[0]));
                break;

            case Sensor.TYPE_PROXIMITY:
                textProximity.setText(String.valueOf(event.values[0]));
                break;

            case Sensor.TYPE_MAGNETIC_FIELD:
                textMagnetometer.setText(String.valueOf(event.values[0]));
                break;
        }
    }
}