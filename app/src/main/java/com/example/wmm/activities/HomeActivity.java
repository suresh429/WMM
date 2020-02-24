package com.example.wmm.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.wmm.R;
import com.example.wmm.fragments.CheckMeasurementFragment;
import com.example.wmm.fragments.MbookEntryFragment;
import com.example.wmm.fragments.MeasurementDisputesFragment;
import com.example.wmm.fragments.PaymentStatusFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;


    final Fragment mbookEntryFragment = new MbookEntryFragment();
    final Fragment checkMeasurementFragment = new CheckMeasurementFragment();
    final Fragment measurementDisputesFragment = new MeasurementDisputesFragment();
    final Fragment paymentStatusFragment = new PaymentStatusFragment();


    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = mbookEntryFragment;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        navView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        transaction = getSupportFragmentManager().beginTransaction();

        fm.beginTransaction().replace(R.id.main_container, paymentStatusFragment, "4").hide(paymentStatusFragment).commit();
        fm.beginTransaction().replace(R.id.main_container, measurementDisputesFragment, "3").hide(measurementDisputesFragment).commit();
        fm.beginTransaction().replace(R.id.main_container, checkMeasurementFragment, "2").hide(checkMeasurementFragment).commit();
        fm.beginTransaction().replace(R.id.main_container, mbookEntryFragment, "1").commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navigation_mbookentry) {
            toolbar.setTitle(getResources().getString(R.string.home));
            fm.beginTransaction().replace(R.id.main_container, mbookEntryFragment, "1").commit();
            transaction.addToBackStack(null);
            active = mbookEntryFragment;
        } else if (id == R.id.navigation_check) {
            toolbar.setTitle(getResources().getString(R.string.check_measurement));
            fm.beginTransaction().replace(R.id.main_container, checkMeasurementFragment, "2").commit();
            transaction.addToBackStack(null);
            active = checkMeasurementFragment;

        } else if (id == R.id.navigation_measurement) {
            toolbar.setTitle(getResources().getString(R.string.measurement_disputes));
            fm.beginTransaction().replace(R.id.main_container, measurementDisputesFragment, "3").commit();
            transaction.addToBackStack(null);
            active = measurementDisputesFragment;

        } else if (id == R.id.navigation_payment) {
            toolbar.setTitle(getResources().getString(R.string.payment_status));
            fm.beginTransaction().replace(R.id.main_container, paymentStatusFragment, "4").commit();
            transaction.addToBackStack(null);
            active = paymentStatusFragment;

        } else if (id == R.id.navigation_logout) {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(HomeActivity.this);
            builder1.setMessage("Sure to Logout?");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {


                          /*  // Set UserLoggedIn in MyAppPrefsManager

                            myAppPrefsManager.setUserLoggedIn(false);
                            myAppPrefsManager.setUserId(null);


                            // Set isLogged_in of ConstantValues
                            ConstantValues.IS_USER_LOGGED_IN = myAppPrefsManager.isUserLoggedIn();
*/

                            // Navigate to Login Activity
                            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(HomeActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show();

                            finish();
                            dialog.cancel();
                        }
                    });

            builder1.setNegativeButton(
                    "N0",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
