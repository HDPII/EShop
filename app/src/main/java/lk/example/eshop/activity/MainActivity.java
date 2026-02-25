package lk.example.eshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import lk.example.eshop.databinding.ActivityMainBinding;
import lk.example.eshop.databinding.SideNavHeaderBinding;
import lk.example.eshop.fragment.CartFragment;
import lk.example.eshop.fragment.CategoryFragment;
import lk.example.eshop.fragment.HomeFragment;
import lk.example.eshop.fragment.MessageFragment;
import lk.example.eshop.fragment.OrdersFragment;
import lk.example.eshop.fragment.ProfileFragment;
import lk.example.eshop.fragment.SettingFragment;
import lk.example.eshop.fragment.WishlistFragment;
import lk.example.eshop.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, NavigationBarView.OnItemSelectedListener {

    private ActivityMainBinding binding;
    private SideNavHeaderBinding sideNavHeaderBinding;
    private DrawerLayout drawerLayout;
    private MaterialToolbar toolbar ;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        View headerView = binding.sideNavigationView.getHeaderView(0);
        sideNavHeaderBinding = SideNavHeaderBinding.bind(headerView);

        sideNavHeaderBinding.headerProfilePic.setImageResource(R.drawable.app_logo);

        EdgeToEdge.enable(this);

        drawerLayout = binding.drawerLayout;
        toolbar = binding.toolbar;
        navigationView = binding.sideNavigationView;
        bottomNavigationView = binding.bottomNavigationView;

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setOnItemSelectedListener(this);

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true){
            @Override
            public void handleOnBackPressed(){
                if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    finish();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainContent), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setOnItemSelectedListener(this);

        if (savedInstanceState == null){
            loadFragment(new HomeFragment());
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){

        int itemId = item.getItemId();

        Menu naMenu = navigationView.getMenu();
        Menu bottomnavMenu = bottomNavigationView.getMenu();

        for (int i = 0; i < naMenu.size(); i++) {
            naMenu.getItem(i).setChecked(false);
        }

        for (int i = 0; i < bottomnavMenu.size(); i++) {
            bottomnavMenu.getItem(i).setChecked(false);
        }

        if (itemId == R.id.side_nav_home || itemId == R.id.bottom_nav_home) {
            loadFragment(new HomeFragment());
//            navigationView.setCheckedItem(R.id.side_nav_home);
            navigationView.getMenu().findItem(R.id.side_nav_home).setChecked(true);
            bottomNavigationView.getMenu().findItem(R.id.bottom_nav_home).setChecked(true);

        }else if (itemId == R.id.side_nav_profile || itemId == R.id.bottom_nav_profile) {
            loadFragment(new ProfileFragment());
//            navigationView.setCheckedItem(R.id.side_nav_profile);
            navigationView.getMenu().findItem(R.id.side_nav_profile).setChecked(true);
            bottomNavigationView.getMenu().findItem(R.id.bottom_nav_profile).setChecked(true);

        } else if (itemId == R.id.side_nav_orders) {
            loadFragment(new OrdersFragment());
//            navigationView.setCheckedItem(R.id.side_nav_orders);
            navigationView.getMenu().findItem(R.id.side_nav_orders).setChecked(true);


        } else if (itemId == R.id.side_nav_wishlist) {
            loadFragment(new WishlistFragment());
            navigationView.getMenu().findItem(R.id.side_nav_wishlist).setChecked(true);


        }else if (itemId == R.id.side_nav_cart || itemId == R.id.bottom_nav_cart) {
            loadFragment(new CartFragment());
            navigationView.getMenu().findItem(R.id.side_nav_cart).setChecked(true);
            bottomNavigationView.getMenu().findItem(R.id.bottom_nav_cart).setChecked(true);

        }else if (itemId == R.id.side_nav_message) {
            loadFragment(new MessageFragment());
            navigationView.getMenu().findItem(R.id.side_nav_message).setChecked(true);

        } else if (itemId == R.id.side_nav_setting) {
            loadFragment(new SettingFragment());
            navigationView.getMenu().findItem(R.id.side_nav_setting).setChecked(true);

        } else if (itemId == R.id.bottom_nav_category) {
            loadFragment(new CategoryFragment());
            bottomNavigationView.getMenu().findItem(R.id.bottom_nav_category).setChecked(true);

        } else if (itemId == R.id.side_nav_login) {

            Intent intent = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(intent);

        } else if (itemId == R.id.side_nav_logout) {

        }

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        return true;

    }

    private void loadFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

    }

}