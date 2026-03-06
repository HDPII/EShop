## Day 15 Progress (2026-03-04)

Today's development shifted focus to exploring Android hardware capabilities, specifically integrating and reading real-time data from various built-in device sensors.

### ✨ Features Implemented
* **Hardware Sensor Integration**:
  * Utilized the Android `SensorManager` to initialize and access physical device sensors.
  * Successfully integrated four specific sensors: **Accelerometer**, **Light**, **Proximity**, and **Magnetometer**.
* **Real-Time Data Tracking**:
  * Implemented the `SensorEventListener` interface to actively listen for and capture continuous data streams from the active sensors.
  * Configured the `onSensorChanged` callback mechanism to dynamically parse and display precise sensor values (e.g., extracting X, Y, and Z axis values for the accelerometer).
* **Lifecycle Management**:
  * Added logic to register sensor listeners explicitly during the `onResume` lifecycle state, ensuring the app reads sensor data efficiently and manages system resources properly.
* **User Interface**:
  * Designed a clear and responsive `ConstraintLayout` to display the live sensor readings, utilizing structured `TextView` elements for each respective sensor.

### 📁 Key Files Created/Updated
* **Activities**: `MainActivity.java` (Sensor manager initialization and event handling logic)
* **Layouts**: `activity_main.xml` (UI components for visualizing real-time sensor data)
