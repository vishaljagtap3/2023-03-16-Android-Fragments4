package com.bitcodetech.fragments4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.*

class FragmentEditor : Fragment(), FragmentForm.OnInfoSubmitListener {

    interface OnInfoUpdateListener {
        fun toUpper(text : String)
        fun toLower(text : String)
    }

    var onInfoUpdateListener : OnInfoUpdateListener? = null

    private lateinit var txtInfo : TextView
    private lateinit var btnLowerCase : Button
    private lateinit var btnUppercase : Button

    var text : String = ""
    set(value) {
        field = value
        txtInfo.setText(text)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_editor, null)

        initViews(view)
        setupListeners()

        return view
    }

    private fun setupListeners() {

        btnLowerCase.setOnClickListener {
            if(onInfoUpdateListener == null) {
                return@setOnClickListener
            }

            onInfoUpdateListener!!.toLower(text.lowercase(Locale.ROOT))
        }

        btnUppercase.setOnClickListener {
            if(onInfoUpdateListener == null) {
                return@setOnClickListener
            }

            onInfoUpdateListener!!.toUpper(text.uppercase(Locale.ROOT))
        }

        //way 1
        /*btnLowerCase.setOnClickListener {
            (activity as MainActivity).transferDataToFragmentForm(
                text.toLowerCase()
            )
        }

        btnUppercase.setOnClickListener {
            (activity as MainActivity).transferDataToFragmentForm(
                text.toUpperCase()
            )
        }*/
    }

    private fun initViews(view : View) {
        txtInfo = view.findViewById(R.id.txtInfo)
        btnLowerCase = view.findViewById(R.id.btnLowerCase)
        btnUppercase = view.findViewById(R.id.btnUpperCase)
    }

    override fun onSubmit(text: String) {
        this.text = text
    }
}







