# EShop - Android Application

## Day 01 Progress (2026-02-12)

The development of the EShop Android application has started. Day 01 focused on setting up the basic UI structure and integrating essential libraries.

### ✨ Features Implemented
* **Splash Screen**: Created a full-screen `SplashActivity` that displays the app logo, version information, and a progress bar. Implemented a 5-second delay handler that automatically navigates the user to the `MainActivity`.
* **Side Navigation Menu**: Set up a side navigation drawer in the `MainActivity` using `DrawerLayout` and `NavigationView`. Created a custom menu (`side_nav_menu.xml`) with the following navigation options: Home, Profile, Orders, Wishlist, Cart, Message, Settings, Login, and Logout.
* **Image Loading Integration**: Integrated **Glide** and **Picasso** libraries into the project to handle image loading efficiently. Glide is currently being used to render the app logo on the splash screen.

### 🛠️ Tech Stack & Libraries
* **Language**: Java
* **Theme**: [material-theme-builder](https://material-foundation.github.io/material-theme-builder/)
* **UI Components**: AndroidX AppCompat, Material Design, ConstraintLayout
* **Image Loading**:
    * [Glide](https://github.com/bumptech/glide) (v4.16.0)
    * [Picasso](https://square.github.io/picasso/) (v2.8)

### 📁 Key Files Created/Updated
* `SplashActivity.java` & `activity_splash.xml`
* `MainActivity.java` & `activity_main.xml`
* `side_nav_menu.xml` (Navigation drawer menu items)
* `build.gradle` & `libs.versions.toml` (Added Glide and Picasso dependencies)
