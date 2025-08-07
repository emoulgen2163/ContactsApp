package com.example.contactsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsapp.databinding.ActivityMainBinding
import com.example.contactsapp.room.Contact
import com.example.contactsapp.util.ContactAdapter
import com.example.contactsapp.viewModel.ContactViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<ContactViewModel>()
    private lateinit var contactAdapter: ContactAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        contactAdapter = ContactAdapter {
            viewModel.delete(it)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = contactAdapter

        viewModel.allContacts.observe(this, Observer{
            contactAdapter.submitList(it)
        })

        binding.addButton.setOnClickListener {
            if (binding.nameEditText.text.isNotEmpty() && binding.phoneEditText.text.isNotEmpty()) {
                val contact = Contact(name = binding.nameEditText.text.toString(), phone = binding.phoneEditText.text.toString())
                viewModel.add(contact)

                binding.nameEditText.setText("")
                binding.phoneEditText.setText("")
            }
        }

    }
}