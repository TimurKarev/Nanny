package com.maryjustudio.radionanny.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.maryjustudio.radionanny.R


class SettingsFragment : Fragment() {

    companion object {
        fun newInstance() = SettingsFragment()
    }

    private var model: MainViewModel?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.settings_fragment,container,false)

        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model= ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        val btn=view.findViewById<View>(R.id.settingsFragment_SaveNumber_button) as Button
        val edt=view.findViewById<View>(R.id.settingsFragment_phoneNumber_editText) as EditText

        //listener onClick
        btn.setOnClickListener {view ->
            //set the message to share to another fragment
            model!!.setMsgCommunicator(edt.text.toString())
            //Launch the data receiver fragment
            val myfragment = MainFragment()
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.container, myfragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}