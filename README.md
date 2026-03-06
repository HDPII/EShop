##
## Day 14 Progress (2026-03-03)

## Map API Integration Progress

This phase focused on implementing a robust map interface using the Google Maps SDK and calculating routes using the Google Maps Directions API.

### ✨ Features Implemented
* **Google Maps Initialization**:
  * Configured the interactive map UI using `FragmentContainerView` and a specific map ID for modern cloud-based map styling.
  * Implemented the `OnMapReadyCallback` to initialize the map, enabling zoom controls and the compass.
* **Real-Time Location Tracking**:
  * Integrated `FusedLocationProviderClient` and configured a `LocationRequest` with high accuracy to track the user's live location.
  * Handled Android runtime permissions (`ACCESS_FINE_LOCATION`) securely before enabling the "My Location" layer on the map.
* **Interactive Map Markers**:
  * Added an `onMapLongClickListener` allowing users to long-press anywhere on the map to drop a dynamic destination marker.
* **Directions API Integration**:
  * Built a `DirectionApi` interface using Retrofit to communicate with the Google Maps Directions API (`/maps/api/directions/json`).
  * Configured the app to automatically trigger an API call to fetch route data between the user's `currentLocation` and the newly dropped marker's coordinates.
* **Network & Dependency Configuration**:
  * Added essential libraries including Google Play Services for Maps and Location, Retrofit, OkHttp (via BOM), and Gson Converter to handle API requests and JSON parsing.

### 📁 Key Files Created/Updated
* **Activities**: `MapsActivity.java` (Map rendering, location updates, and marker logic)
* **Services**: `DirectionApi.java` (Retrofit interface for routing)
* **Layouts**: `activity_maps.xml` (Map fragment container)
* **Configuration**: `build.gradle`, `libs.versions.toml` (Added SDKs and Networking dependencies)
