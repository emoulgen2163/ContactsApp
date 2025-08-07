package com.example.contactsapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("contacts_table")
data class Contact(
    @PrimaryKey(true)
    val id: Int = 0,
    val name: String,
    val phone: String
)
