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

  ##
  ## Day 04 Progress (2026-02-18)

Today's focus was on the authentication flow, specifically designing and implementing the Sign-In and Sign-Up screens and managing the navigation between them.

### ✨ Features Implemented
* **Authentication UI Design**:
  * Designed a clean and user-friendly `activity_sign_in.xml` layout, including input fields for Email and Password, a "Forgot Password" option, and a primary "Sign In" button.
  * Designed the `activity_sign_up.xml` layout to gather new user details, including Name, Email, Password, and Password confirmation, ensuring consistent styling with the app's theme.
* **Authentication Flow Navigation**:
  * Configured `SignInActivity.java` to navigate to the `SignUpActivity` when the "Sign Up" text/button is clicked.
  * Configured `SignUpActivity.java` to navigate back to the `SignInActivity` when the "Sign In" text/button is clicked.
  * Used `finish()` appropriately to manage the activity back stack during these transitions.
* **Main Menu Integration**:
  * Updated `MainActivity.java` to launch the `SignInActivity` when the user selects the "Login" option from the side navigation drawer.
  * Ensured the side navigation drawer closes automatically after making a selection.

### 📁 Key Files Created/Updated
* `SignInActivity.java` & `activity_sign_in.xml` (New Sign-In screen logic and layout)
* `SignUpActivity.java` & `activity_sign_up.xml` (New Sign-Up screen logic and layout)
* `MainActivity.java` (Updated routing to the Sign-In screen)
* `side_nav_menu.xml` (Confirmed visibility of Login/Logout items based on auth state)

##
## Day 05 Progress (2026-02-19)

Today's development focused on integrating a backend using Firebase to make the authentication flow fully functional, including user registration, login, and data storage.

### ✨ Features Implemented
* **Firebase Integration**: 
  * Successfully connected the application to Firebase.
  * [cite_start]Added dependencies for Firebase BoM, Firebase Authentication, and Firebase Firestore to manage users and database records[cite: 3].
* **User Registration (Sign Up)**:
  * Implemented strict input validation to ensure data integrity (checking for empty fields, valid email formats, minimum password length of 6 characters, and matching passwords).
  * Utilized Firebase Auth (`createUserWithEmailAndPassword`) to securely register new users.
  * Configured Cloud Firestore to automatically save additional user details (UID, Name, Email) into a "users" collection upon successful registration.
* **User Authentication (Sign In)**:
  * Implemented input validation for the login fields.
  * Used Firebase Auth (`signInWithEmailAndPassword`) to authenticate returning users and smoothly redirect them to the `MainActivity` upon a successful login.
* **Data Modeling with Lombok**:
  * Created a `User` model class to handle user data.
  * Integrated the `Lombok` library (`@Data`, `@Builder`, `@AllArgsConstructor`, `@NoArgsConstructor`) to reduce boilerplate code and easily build user objects for Firestore.

### 📁 Key Files Created/Updated
* [cite_start]`build.gradle` (Added Firebase BoM, Auth, Firestore, and Lombok dependencies) [cite: 3]
* `SignUpActivity.java` (Integrated Firebase Auth, Firestore saving logic, and input validations)
* `SignInActivity.java` (Integrated Firebase Auth login logic and input validations)
* `User.java` (New model class utilizing Lombok for Firestore database operations)

##
## Day 06 Progress (2026-02-20)

Today's focus was on finalizing the authentication state integration and building the core product discovery features, specifically fetching and displaying product categories and their respective listings from Firebase Firestore.

### ✨ Features Implemented
* **User Authentication State & Profile Display**:
  * Updated `MainActivity` to fetch and display the logged-in user's data (Name, Email, and Profile Picture via Glide) in the side navigation header.
  * Introduced a custom circular shape style (`@style/Circleimage`) for the profile picture in the navigation header.
  * Navigation menu items (Login, Logout, Profile, Cart, etc.) now dynamically update their visibility based on the user's current authentication status.
* **Category Display**:
  * Created the `Category` model class using Lombok.
  * Developed the `CategoryFragment` to display a grid of product categories fetched dynamically from the Firestore `categories` collection.
  * Added `CategoryAdapter` to manage the `RecyclerView` for categories, alongside a custom `item_category.xml` layout for individual category items.
* **Product Listing**:
  * Created the `Product` model class.
  * Developed the `ListingFragment` to show products dynamically based on the category selected by the user.
  * Added `ListingAdapter` and `item_listing.xml` to manage and display the product list view in a structured grid.
* **UI/UX Enhancements**:
  * Added a custom click animation (`R.anim.click_animation`) to list items (categories and products) to provide interactive visual feedback when a user clicks on them.

### 📁 Key Files Created/Updated
* **UI & Logic Updated**: `MainActivity.java`
* **New Models**: `Category.java`, `Product.java` 
* **New Fragments**: `CategoryFragment.java`, `ListingFragment.java` 
* **New Adapters**: `CategoryAdapter.java`, `ListingAdapter.java` 
* **New Layouts**: `item_category.xml`, `item_listing.xml`, `fragment_category.xml`, `fragment_listing.xml`
* **Updated Layouts**: `side_nav_header.xml`, `side_nav_menu.xml`

##
## Day 07 Progress (2026-02-21)

Today's development focused on enhancing the product discovery experience by implementing a dynamic product listing based on category selection and laying the groundwork for the product details screen.

### ✨ Features Implemented
* **Dynamic Product Listing**:
  * Implemented the `ListingFragment` to query Firebase Firestore and display products that match the specifically selected category ID.
  * Configured Firestore composite indexes to ensure efficient querying and sorting of the product database.
* **Navigation & State Management**:
  * Integrated an `OnBackPressedCallback` in the `ListingFragment` to handle custom back navigation, ensuring users return smoothly to the Category view instead of exiting the application.
  * Fixed a bug in the `CategoryFragment` by updating the target fragment container ID (`R.id.container`), ensuring proper transitions without overlapping the Bottom Navigation Bar.
* **UI & Data Presentation Updates**:
  * Enhanced the visual presentation of individual product cards in `item_listing.xml` (e.g., adjusting the MaterialCardView dimensions and text alignments).
  * Updated the `ListingAdapter` to dynamically format the product price by appending the "LKR" currency prefix.
* **Product Details Initialization**:
  * Created the foundational `ProductDeatailsFragment` and its corresponding layout (`fragment_product_deatails.xml`) to prepare for displaying in-depth product information in the next phase.

### 📁 Key Files Created/Updated
* **New Fragments**: `ProductDeatailsFragment.java`
* **New Layouts**: `fragment_product_deatails.xml`
* **Updated Logic**: `ListingFragment.java` (Added Firestore queries & back-press handling), `CategoryFragment.java` (Fixed navigation routing)
* **Updated Adapters**: `ListingAdapter.java` (Currency formatting)
* **Updated Layouts**: `item_listing.xml` (Card UI adjustments)

##
## Day 08 Progress (2026-02-23)

Today's focus was on implementing the Product Details screen to provide users with comprehensive information about a selected product, including an interactive image gallery.

### ✨ Features Implemented
* **Product Details Screen**:
  * Created the `ProductDeatailsFragment` to dynamically fetch and display detailed product information (title, price, rating, and available quantity) directly from Firebase Firestore using the specific `productId`.
  * Designed a comprehensive UI in `fragment_product_deatails.xml` featuring a clean layout, quantity selector, and persistent "Add to Cart" and "Buy Now" buttons.
* **Swipeable Image Gallery**:
  * Integrated a `ViewPager2` along with a `DotsIndicator` to create a modern, swipeable product image slider.
  * Developed the `ProductSliderAdapter` and `product_slider_item.xml` to load multiple product images efficiently using the Glide library.
* **Navigation & UI State Management**:
  * Updated the `ListingFragment` to detect user clicks on individual products and smoothly navigate to the `ProductDeatailsFragment`, passing the `productId` as an argument.
  * Configured the `ProductDeatailsFragment` to temporarily hide the `BottomNavigationView` (`View.GONE`) upon entering, ensuring a focused full-screen viewing experience, and restore it upon exiting.
* **Model Enhancements**:
  * Updated the `Product` model class to include a `rating` field (`float`), allowing the app to store and display product ratings effectively.

### 📁 Key Files Created/Updated
* **New Fragments**: `ProductDeatailsFragment.java`
* **New Adapters**: `ProductSliderAdapter.java`
* **New Layouts**: `fragment_product_deatails.xml`, `product_slider_item.xml`
* **Updated Logic**: `ListingFragment.java` (Added navigation and click handling to details screen)
* **Updated Models**: `Product.java` (Added `rating` attribute)

##
## Day 09 Progress  (2026-02-24)

Today's development significantly upgraded the user experience on both the Product Details and Home screens, adding dynamic interactions, attribute selections, and cross-product discovery.

### ✨ Features Implemented
* **Enhanced Product Details Screen**:
  * Implemented an interactive quantity selector allowing users to dynamically increase or decrease item counts within the available stock limits using functional plus/minus buttons.
  * Added dynamic rendering for product attributes (such as color and size) using Material `ChipGroup` components, intelligently applying actual visual color codes to the chips when the attribute type is set to "color".
  * Integrated a "Top Selling Products" horizontal scrolling section at the bottom of the details page to improve product discovery, specifically configured to exclude the currently viewed product from this recommended list.
* **Dynamic Home Screen**:
  * Replaced the static placeholder layout on the Home screen with a fully functional "Top Selling Products" section.
  * Fetched product data directly from Firebase Firestore and displayed it smoothly using a horizontally oriented `RecyclerView`.
* **Reusable UI Components**:
  * Created the `SectionAdapter` and corresponding modular layout files (`item_section.xml`, `item_product_recycler.xml`) to easily reuse the horizontal product scrolling views across multiple screens (like Home and Product Details).
* **Data Model Upgrades**:
  * Updated the `Product` model class to include a nested `Attribute` class for handling variations like size and color arrays.
  * Introduced a new `CartItem` model class, complete with Firestore `@Exclude` annotations for document IDs, laying the crucial groundwork for the upcoming shopping cart implementation.

### 📁 Key Files Created/Updated
* **New Models**: `CartItem.java`
* **Updated Models**: `Product.java`
* **New Adapters**: `SectionAdapter.java`
* **Updated Fragments**: `ProductDeatailsFragment.java`, `HomeFragment.java`, `ListingFragment.java`
* **New/Updated Layouts**: `fragment_product_deatails.xml`, `fragment_home.xml`, `item_section.xml`, `item_product_recycler.xml`

##
## Day 10 & 11 Progress (2026-02-25 / 2026-02-26)

Over the last two days, the focus was on implementing the complete e-commerce transaction flow, from adding items to the shopping cart to placing a final order, with robust Firebase Firestore integration.

### ✨ Features Implemented
* **Shopping Cart Management**:
  * Integrated "Add to Cart" functionality on the product details screen, which checks the user's authentication status and saves the selected product, quantity, and specific attributes directly to the user's `cart` subcollection in Firestore.
  * Implemented the `CartFragment` and `CartAdapter` to dynamically fetch and display the user's cart items using an interactive `RecyclerView`.
  * Enabled dynamic cart updates allowing users to increase or decrease item quantities (within available stock limits) or completely remove items, syncing all changes directly to the Firestore database.
  * Added logic to automatically query product prices and calculate the accurate total cart amount in real-time.
* **Checkout & Order Placement Flow**:
  * Developed the `CheckoutFragment` featuring collapsible, structured UI sections for capturing Shipping and Billing details (with an option to use the shipping address as the billing address).
  * Implemented a dynamic order summary that calculates the cart subtotal, adds a fixed shipping cost, and displays the final total amount.
  * Built the final order placement logic that compiles user details, shipping/billing addresses, and all cart items into an `Order` object, securely saving it to the `orders` collection in Firestore.
* **Data Models & UI Assets**:
  * Created the comprehensive `Order` model, including nested `OrderItem` and `Address` classes to neatly structure complex transaction data for Firebase.
  * Utilized the `CartItem` model with `@Exclude` annotations on the document ID to efficiently manage Firestore document references.
  * Added custom vector assets (like delete icons and drop-down arrows) for improved UI interactions within the cart and checkout screens.

### 📁 Key Files Created/Updated
* **New Models**: `Order.java`
* **New Fragments**: `CartFragment.java`, `CheckoutFragment.java`
* **New Adapters**: `CartAdapter.java`
* **Updated Logic**: `ProductDeatailsFragment.java` (Integrated cart saving logic)
* **New Layouts**: `fragment_cart.xml`, `fragment_checkout.xml`, `item_cart.xml`

##
## Day 12 Progress (2026-02-27)

Today's major milestone was the successful integration of a third-party payment gateway and finalizing the complete checkout lifecycle, including order persistence and cart management.

### ✨ Features Implemented
* **PayHere Payment Gateway Integration**:
  * Integrated the PayHere Android SDK to securely process payments within the app.
  * Configured the `InitRequest` to dynamically map the calculated total amount, generated order ID, and user shipping details directly into the PayHere Sandbox environment for testing.
  * Implemented an `ActivityResultLauncher` to actively listen for and handle payment success, cancellation, or failure responses from the PayHere gateway.
* **Order Placement & Database Persistence**:
  * Upon a successful payment response, the app automatically constructs a comprehensive `Order` object containing user details, shipping/billing addresses, structured cart items, and a Firebase `Timestamp`.
  * Successfully pushed the generated order document directly to the Firestore `orders` collection.
* **Post-Payment Lifecycle**:
  * Implemented automated cart clearing: Once an order is successfully placed, the app queries and deletes all items within the user's active `cart` subcollection in Firestore.
  * Added smooth UX transitions to redirect the user back to the `HomeFragment` after a successful checkout.
* **Model Updates**:
  * Upgraded the `Order` model to utilize `com.google.firebase.Timestamp` for the `orderDate` field, ensuring accurate and timezone-independent record keeping.

### 📁 Key Files Created/Updated
* **Updated Logic**: `CheckoutFragment.java` (PayHere SDK integration, order saving, and cart clearing logic)
* **Updated Models**: `Order.java` (Integrated Firebase Timestamp)
* **Updated Layouts**: `fragment_checkout.xml` (Finalized UI bindings for the payment trigger)

##
## Day 13 Progress (2026-03-02)

Today's focus was on handling media assets by integrating Firebase Storage. The primary implementation was enabling dynamic profile picture uploads and configuring the app to serve category and product images directly from cloud storage.

### ✨ Features Implemented
* **Firebase Storage Integration**:
  * Successfully integrated the `firebase-storage` dependency into the project (`build.gradle` and `libs.versions.toml`) to securely store and serve user-generated and app-level media.
  * Updated the `CategoryAdapter` to initialize Firebase Storage, laying the groundwork for fetching dynamic category images directly from the cloud bucket.
* **Profile Picture Upload Flow**:
  * Implemented an `ActivityResultLauncher` in the `MainActivity` to allow users to securely browse and select images from their device's local gallery using `Intent.ACTION_PICK`.
  * Built the upload logic to push the selected image to a dedicated `profile-images/` folder in Firebase Storage, using unique UUIDs to prevent file overwriting.
* **Real-time Database Sync & UI Update**:
  * Upon a successful upload, the app automatically retrieves the download URL and updates the specific user's document in the Firestore `users` collection.
  * Integrated the Glide library to instantly fetch and display the newly uploaded profile picture inside the custom circular `ShapeableImageView` in the side navigation header.
* **App Configuration**:
  * Registered the `MapsActivity` within the `AndroidManifest.xml`, setting up the required configurations for upcoming location and map-based features.

### 📁 Key Files Created/Updated
* **Updated Logic**: `MainActivity.java` (Added gallery intent, Firebase Storage upload, and Firestore sync logic)
* **Updated Adapters**: `CategoryAdapter.java` (Added Firebase Storage instance initialization)
* **Configuration Files**: Updated `build.gradle`, `libs.versions.toml` (Dependencies), and `AndroidManifest.xml` (Activity registration).
