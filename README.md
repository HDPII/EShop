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

##
## Day 02 Progress (2026-02-14)

Today's development focused on completing the navigation components and structuring the main user interface.

### ✨ Features Implemented
* **Side Navigation Drawer**: 
  * Successfully implemented the side navigation menu using `NavigationView` and `DrawerLayout`.
  * Created a custom header (`side_nav_header.xml`) displaying the user's profile image, name, and email address.
  * Added relevant vector icons to all menu items (Home, Profile, Orders, Wishlist, Cart, Message, Settings, Login, and Logout) in `side_nav_menu.xml`.
* **Bottom Navigation Bar**: 
  * Designed and integrated a `BottomNavigationView` into the main layout for quick access to primary sections of the app.
* **Main Screen UI Enhancements**:
  * Structured `activity_main.xml` to seamlessly house both the side navigation drawer and the bottom navigation bar.
  * Added a `MaterialToolbar` with a custom-styled search bar (`EditText`) at the top of the main screen.
  * Set up a `FragmentContainerView` to handle future fragment transactions between the navigation bars.

### 📁 Key Files Created/Updated
* `activity_main.xml` (Structured with DrawerLayout, Bottom Navigation, Search Bar, and Toolbar)
* `side_nav_header.xml` (New custom header for the side menu)
* `side_nav_menu.xml` (Updated with menu item icons)

##
## Day 03 Progress (2026-02-17)

Today's focus was on bringing the navigation UI to life by implementing Fragment transactions and synchronizing the navigation components.

### ✨ Features Implemented
* **Fragment Integration**: 
  * Created individual Fragments and their corresponding layout files for all main application screens (`HomeFragment`, `CategoryFragment`, `CartFragment`, `ProfileFragment`, `OrdersFragment`, `WishlistFragment`, `MessageFragment`, and `SettingFragment`).
  * Implemented `FragmentManager` and `FragmentTransaction` within `MainActivity` to dynamically swap these fragments inside the `FragmentContainerView` when a user navigates.
* **Navigation Synchronization**: 
  * Developed logic to synchronize the active state between the Side Navigation Drawer and the Bottom Navigation Bar. 
  * If a user selects "Cart" on the bottom bar, the "Cart" item in the side drawer automatically highlights, ensuring a consistent user experience.
* **Theme-Aware Selection States**: 
  * Configured the navigation menus (`checkableBehavior`) and color states so that the selected menu items correctly highlight according to the app's theme colors.
* **Default Screen Routing**: 
  * Set up `HomeFragment` to load automatically as the default screen when the application launches.

### 📁 Key Files Created/Updated
* `MainActivity.java` (Added `OnNavigationItemSelectedListener`, Fragment routing, and menu state synchronization logic)
* Created new Fragment Classes & Layouts:
  * `HomeFragment.java` / `fragment_home.xml`
  * `CartFragment.java` / `fragment_cart.xml`
  * `ProfileFragment.java` / `fragment_profile.xml`
  * `CategoryFragment.java` / `fragment_category.xml`
  * *...and other respective fragments.*
* `side_nav_menu.xml` & `bottom_nav_menu.xml` (Updated IDs and checkable attributes for state syncing)
