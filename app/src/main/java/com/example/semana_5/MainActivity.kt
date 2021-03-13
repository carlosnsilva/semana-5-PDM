package com.example.semana_5

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var tImagem : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tImagem = findViewById(R.id.telaImagem)
        this.tImagem.setOnClickListener({click(it)})
    }

    private fun click( view: View){
        var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (intent.resolveActivity(packageManager) != null){
            startActivityForResult(intent, 1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK){
            var imagemFoto: Bitmap? = data?.getParcelableExtra("data")
            this.tImagem.setImageBitmap(imagemFoto)
        }
    }

}