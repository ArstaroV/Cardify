package com.uselesscodeworks.cardify.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uselesscodeworks.cardify.models.Box
import com.uselesscodeworks.cardify.models.Vocabulary

@Database(entities = [Box::class, Vocabulary::class], version = 1)
abstract class CardifyDatabase : RoomDatabase() {
    abstract fun boxDao(): BoxDao
    abstract fun vocabelDao(): VocabularyDao
    var selectedBoxId = 0

    companion object {
        private lateinit var instance: CardifyDatabase

        fun getInstance(context: Context?): CardifyDatabase {
            if (!this::instance.isInitialized) {
                synchronized(this) {
                    instance = Room.databaseBuilder(
                        context!!.applicationContext,
                        CardifyDatabase::class.java,
                        "cardify_database"
                    ).build()
                }
            }
            return instance
        }
    }
}
