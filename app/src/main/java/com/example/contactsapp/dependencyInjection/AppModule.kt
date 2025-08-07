package com.example.contactsapp.dependencyInjection

import android.content.Context
import com.example.contactsapp.room.ContactDAO
import com.example.contactsapp.room.ContactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ContactDatabase = ContactDatabase.getDatabase(context)

    @Provides
    @Singleton
    fun provideDao(contactDatabase: ContactDatabase): ContactDAO = contactDatabase.contactDao()
}