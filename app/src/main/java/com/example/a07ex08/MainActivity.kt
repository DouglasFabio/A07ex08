package com.example.a07ex08

import android.graphics.Bitmap
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import java.util.Date

class MainActivity : AppCompatActivity() {

    lateinit var btnCapturar: Button
    lateinit var imgFoto: ImageView
    lateinit var txtDataHora: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCapturar = findViewById(R.id.btnCapturar)
        imgFoto = findViewById(R.id.imgFoto)
        txtDataHora = findViewById(R.id.txtDataHora)

    }

    val register = registerForActivityResult(ActivityResultContracts.TakePicturePreview())
    {
        image: Bitmap? ->
            imgFoto.setImageBitmap(image)
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val currentDateandTime: String = sdf.format(Date())
            txtDataHora.text = currentDateandTime
    }

    fun capturarFoto(view: View){
        register.launch(null)
    }
}