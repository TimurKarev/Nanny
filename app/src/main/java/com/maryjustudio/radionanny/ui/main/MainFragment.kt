package com.maryjustudio.radionanny.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import com.maryjustudio.radionanny.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val btn=view.findViewById<View>(R.id.btnBack) as Button
        val txt=view.findViewById<View>(R.id.mainFragment_phoneNumber_textView) as TextView
        val btn=view.findViewById<View>(R.id.mainFragment_settings_button) as Button

        val model=ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        model.message.observe(this, object : Observer<Any> {
            override fun onChanged(o: Any?) {
                txt.text = o!!.toString()
            }
        })
        btn.setOnClickListener { view ->
            //write some code here
            val myfragment = SettingsFragment()
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.container, myfragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

}
