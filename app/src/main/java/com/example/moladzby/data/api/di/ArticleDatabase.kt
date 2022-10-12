package com.example.moladzby.data.api.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock

abstract class ArticleDatabase: RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object{
        @Volatile
        private var instance: ArticleDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
        instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) : ArticleDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_database"
            ).build()
        }
    }
}