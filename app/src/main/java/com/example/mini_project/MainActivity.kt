package com.example.mini_project

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.appbar.MaterialToolbar

/**
 * MainActivity adalah Activity utama aplikasi.
 * Di sini kita setup Navigation Component agar fragment-fragment bisa dinavigasikan
 * dan toolbar dapat berfungsi sebagai ActionBar dengan integrasi NavController.
 */
class MainActivity : AppCompatActivity() {

    // NavController untuk mengatur navigasi antar fragment
    private lateinit var navController: NavController

    // Konfigurasi untuk AppBar (toolbar) agar tahu fragment mana yang dianggap sebagai top-level
    private lateinit var appBarConfiguration: AppBarConfiguration

    /**
     * Fungsi lifecycle onCreate dipanggil saat activity pertama kali dibuat.
     * - Setup layout utama
     * - Setup NavController
     * - Konfigurasi AppBar
     * - Menjadikan MaterialToolbar sebagai ActionBar
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Menyediakan layout edge-to-edge (fit system windows)
        setContentView(R.layout.activity_main)

        // Ambil NavHostFragment dari layout untuk mendapatkan NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        // AppBarConfiguration menentukan fragment mana yang menjadi "root"
        // sehingga tombol "Up" (←) tidak muncul di fragment tersebut.
        appBarConfiguration = AppBarConfiguration(setOf(R.id.pokemonListFragment))

        // Ambil MaterialToolbar dari layout dan jadikan sebagai ActionBar
        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Hubungkan ActionBar dengan NavController agar:
        // - Judul toolbar otomatis berubah sesuai fragment
        // - Tombol "Up" bisa bekerja
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    /**
     * Fungsi ini dipanggil saat user menekan tombol "Up" (←) di toolbar.
     * Akan mencoba menavigasikan ke fragment sebelumnya menggunakan NavController.
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
