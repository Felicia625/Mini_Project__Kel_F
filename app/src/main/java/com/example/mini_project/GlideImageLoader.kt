package com.example.mini_project

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Kelas ini mengimplementasikan interface ImageLoader
 * dengan menggunakan library Glide sebagai loader gambar.
 * Tujuannya agar pemanggilan loadImage lebih fleksibel (bisa diganti library lain nanti).
 */
class GlideImageLoader(private val context: Context) : ImageLoader {

    /**
     * Fungsi untuk memuat gambar dari URL ke dalam ImageView
     *
     * @param imageUrl -> URL gambar yang ingin dimuat
     * @param imageView -> ImageView target untuk menampilkan gambar
     *
     * Glide digunakan untuk:
     * - Mengambil gambar dari internet (atau cache)
     * - Melakukan crop/scale otomatis agar sesuai tampilan
     * - Menangani loading & caching secara efisien
     */
    override fun loadImage(imageUrl: String, imageView: ImageView) {
        Glide.with(context)      // Gunakan context untuk lifecycle-aware Glide
            .load(imageUrl)      // Set URL gambar
            .centerCrop()        // Crop gambar agar mengisi penuh ImageView
            .into(imageView)     // Masukkan gambar ke ImageView target
    }
}
