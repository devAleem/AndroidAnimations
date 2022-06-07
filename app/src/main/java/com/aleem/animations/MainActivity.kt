package com.aleem.animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.tvHello)
       val anim1 = ObjectAnimator.ofFloat(textView,"translationX",100f).apply {
         duration = 500
       }

        val anim2 = ObjectAnimator.ofFloat(textView,"translationX",-100f).apply {
        duration = 1000
        }

        val fadeIn = ObjectAnimator.ofFloat(textView,"alpha",1f,0f).apply {
            duration = 1500
        }

        val fadeOut = ObjectAnimator.ofFloat(textView,"alpha",0f,1f).apply {
            duration = 2000
        }

        val bouncer = AnimatorSet().apply {
            play(anim1).before(anim2)
            play(fadeIn).after(anim2)
        }

        AnimatorSet().apply {
            play(bouncer).before(fadeOut)
            start()
        }

    }
}