package com.bitcodetech.fragments4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    //way 1
    private lateinit var fragmentForm: FragmentForm
    private lateinit var fragmentEditor: FragmentEditor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        fragmentForm = supportFragmentManager.findFragmentById(R.id.fragmentForm) as FragmentForm
        fragmentEditor = supportFragmentManager.findFragmentById(R.id.fragmentEditor) as FragmentEditor

        //way2
        /*fragmentForm.onInfoSubmitListener =
            object : FragmentForm.OnInfoSubmitListener {
                override fun onSubmit(text: String) {
                    fragmentEditor.text = text
                }
            }

        fragmentEditor.onInfoUpdateListener =
            object : FragmentEditor.OnInfoUpdateListener {
                override fun toUpper(text: String) {
                    fragmentForm.text = text
                }

                override fun toLower(text: String) {
                    fragmentForm.text = text
                }
            }*/
    }

    fun transferDataToFragmentForm(text : String) {
        fragmentForm.text = text
    }

    fun transferDataToFragmentEditor(text : String) {
        fragmentEditor.text = text
    }
}