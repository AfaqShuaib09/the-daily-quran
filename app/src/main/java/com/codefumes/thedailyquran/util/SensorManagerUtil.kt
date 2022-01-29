package com.codefumes.thedailyquran.util

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import androidx.compose.runtime.MutableState

class SensorManagerUtil(context: Context, currentDegreeState: MutableState<Float>): SensorEventListener {

    var currentDegrees: MutableState<Float> = currentDegreeState;
    var sensorManager: SensorManager = context.getSystemService(SENSOR_SERVICE) as SensorManager;
    var sensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

    init {
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST)
    }
    override fun onSensorChanged(event: SensorEvent?) {
        Log.d("Qiblah", "Current Degrees: $currentDegrees");
        val degree = Math.round(event!!.values[0])
        currentDegrees.value = (-degree).toFloat()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("Not yet implemented")
    }

    fun getRotation(): Float {
        return currentDegrees.value;
    }

}