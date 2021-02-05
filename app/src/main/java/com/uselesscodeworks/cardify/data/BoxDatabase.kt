package com.uselesscodeworks.cardify.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uselesscodeworks.cardify.models.Box

@Database(entities = [Box::class], version = 1)
abstract class BoxDatabase : RoomDatabase() {
    abstract fun boxDao(): BoxDao
    companion object{
        private lateinit var instance: BoxDatabase

        fun getInstance(context: Context): BoxDatabase{
            synchronized(this){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    BoxDatabase::class.java,
                    "box_database"
                ).build()
                return instance
            }
        }
    }
}