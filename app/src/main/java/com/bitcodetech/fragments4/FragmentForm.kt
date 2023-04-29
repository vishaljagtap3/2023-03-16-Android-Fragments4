package com.bitcodetech.fragments4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FragmentForm : Fragment() {

    interface OnInfoSubmitListener {
        fun onSubmit(text : String)
    }

    var onInfoSubmitListener : OnInfoSubmitListener? = null

    private lateinit var edtInfo : EditText
    private lateinit var btnSubmit : Button

    var text : String = ""
    set(value) {
        field = value
        edtInfo.setText(text)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_form, null)

        initViews(view)
        setupListeners()

        return view
    }

    private fun setupListeners() {

        btnSubmit.setOnClickListener {
            if(onInfoSubmitListener == null) {
                return@setOnClickListener
            }

            onInfoSubmitListener!!.onSubmit(edtInfo.text.toString())
        }

        //way 1
        /*btnSubmit.setOnClickListener {
            (activity as MainActivity).transferDataToFragmentEditor(edtInfo.text.toString())
        }*/
    }

    private fun initViews(view : View) {
        edtInfo = view.findViewById(R.id.edtInfo)
        btnSubmit = view.findViewById(R.id.btnSubmit)
    }

}