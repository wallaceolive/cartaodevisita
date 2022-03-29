package com.dio.businesscard

import android.app.Application
import com.dio.businesscard.data.AppDatabase
import com.dio.businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}