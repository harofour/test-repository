package com.test.app.permission

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContentProviderCompat.requireContext
import com.test.app.permission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest.setOnClickListener {
            Log.e("TIL", "${shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)}")
            Log.e("TIL", "${shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)}")
            Log.e("TIL", "${shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)}")
            requestPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }
}