package com.ali.bookhub.fragment

import android.content.Context
import android.content.SharedPreferences

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.ali.bookhub.R


class ProfileFragment : Fragment() {

    lateinit var etName:EditText
    lateinit var etEmailId:EditText
    lateinit var etPhoneNumber: EditText
    lateinit var etAddress: EditText
    lateinit var btnSave:Button
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile,container,false)

        sharedPreferences = requireActivity().getSharedPreferences(getString(R.string.preference_file), Context.MODE_PRIVATE)

        etName= view.findViewById(R.id.etName)
        etEmailId=view.findViewById(R.id.etEmailId)
        etPhoneNumber=view.findViewById(R.id.etPhoneNumber)
        etAddress=view.findViewById(R.id.etAddress)
        btnSave=view.findViewById(R.id.btnSave)


//        etName= SharedPreferences
//        etPhoneNumber.text = View.sharedPreferences.getString("mobile_number","person name")
//        etEmailId.text = sharedPreferences.getString("email","person name")
//        etAddress.text = sharedPreferences.getString("address","person name")





        return view
    }
}