package com.example.project;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class StepTracker extends AppCompatActivity implements SensorEventListener {
    private TextView stepCounterView, stepDetectorView;
    private SensorManager sensorManager;
    private Sensor stepCounterSensor, stepDetectorSensor;
    private boolean isStepCounterSensorPresent, isStepDetectorSensorPresent;
    private int stepCount = 0, stepDetect = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_taken);

        stepCounterView = findViewById(R.id.StepCounter);
        stepCounterView.setText("0");
        stepDetectorView = findViewById(R.id.StepDetector);
        stepDetectorView.setText("0");

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
            stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isStepCounterSensorPresent = true;
        } else {
            stepCounterView.setText(R.string.COUNTER_SENSOR_NOT_PRESENT);
            isStepCounterSensorPresent = false;
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null) {
            stepDetectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
            isStepDetectorSensorPresent = true;
        } else {
            stepDetectorView.setText(R.string.DETECTOR_SENSOR_NOT_PRESENT);
            isStepDetectorSensorPresent = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isStepCounterSensorPresent) {
            sensorManager.registerListener(this, stepCounterSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (isStepDetectorSensorPresent) {
            sensorManager.registerListener(this, stepDetectorSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isStepCounterSensorPresent) {
            sensorManager.unregisterListener(this, stepCounterSensor);
        }
        if (isStepDetectorSensorPresent) {
            sensorManager.unregisterListener(this, stepDetectorSensor);
        }
    }

    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()) {
            case Sensor.TYPE_STEP_COUNTER:
                stepCount = (int) event.values[0];
                break;
            case Sensor.TYPE_STEP_DETECTOR:
                stepDetect++;
                break;
            default:
                return;
        }
        int totalSteps = stepCount + stepDetect;
        stepCounterView.setText(String.format(Locale.getDefault(), getString(R.string.step_counter_format), totalSteps));
        stepDetectorView.setText(String.format(Locale.getDefault(), getString(R.string.step_detector_format), stepDetect));
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // do nothing
    }

    private void updateStepCounters() {
        // Retrieve the total number of steps taken from the system's step tracking feature
        int totalSteps = getStepsTakenToday();

        // Add the steps counted within your app
        totalSteps += stepCount + stepDetect;

        // Update the step counter display
        stepCounterView.setText(String.format(Locale.getDefault(), getString(R.string.step_counter_format), totalSteps));
        stepDetectorView.setText(String.format(Locale.getDefault(), getString(R.string.step_detector_format), stepDetect));
    }


    private void resetStepCounters() {
        stepCount = 0;
        stepDetect = 0;
        updateStepCounters();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(1001);

    }
    private int getStepsTakenToday() {
        // TODO: Implement logic to retrieve steps taken today from database or other source
        return 0; // replace with actual step count
    }

}