package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var icHome: ImageView
    private lateinit var icFlag: ImageView
    private lateinit var icHelmet: ImageView
    private lateinit var icListar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        icHome = findViewById(R.id.icHome)
        icFlag = findViewById(R.id.icFlag)
        icHelmet = findViewById(R.id.icHelmet)
        icListar = findViewById(R.id.icListar)


        icHome.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, HomeFragment())
                .commit()
        }

        icFlag.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, RacingFragment())
                .commit()
        }

        icHelmet.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, HelmetFragment())
                .commit()
        }

        icListar.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, ListarFragment())
                .commit()
        }
    }
}