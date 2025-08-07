package com.example.contactsapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactsapp.repository.ContactRepository
import com.example.contactsapp.room.Contact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(private val repository: ContactRepository): ViewModel() {
    val allContacts = repository.allContacts

    fun add(contact: Contact) = viewModelScope.launch{
        repository.addContact(contact)
    }

    fun delete(contact: Contact) = viewModelScope.launch {
        repository.deleteContact(contact)
    }
}