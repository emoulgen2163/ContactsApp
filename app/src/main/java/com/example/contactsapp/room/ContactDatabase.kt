package com.example.contactsapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase: RoomDatabase() {

    abstract fun contactDao(): ContactDAO

    companion object{
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context, ContactDatabase::class.java, "contact_db").build()
                INSTANCE = instance
                instance
            }
        }
    }
}