package com.example.lyceum_saturday10_2025

import android.app.Application
import androidx.room.Room
import com.example.lyceum_saturday10_2025.db.GoodsDatabase

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            GoodsDatabase::class.java,
            "goods-db"
        )
            .allowMainThreadQueries()
            .build()
    }


    companion object {
        var db: GoodsDatabase? = null

        fun getDatabase(): GoodsDatabase? {
            return db
        }
    }
}