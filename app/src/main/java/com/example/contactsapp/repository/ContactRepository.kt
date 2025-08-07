package com.example.contactsapp.repository

import com.example.contactsapp.room.Contact
import com.example.contactsapp.room.ContactDAO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactRepository @Inject constructor(private val contactDAO: ContactDAO) {

    val allContacts = contactDAO.getAllContacts()

    suspend fun addContact(contact: Contact) = contactDAO.addContact(contact)
    suspend fun deleteContact(contact: Contact) = contactDAO.deleteContact(contact)
}