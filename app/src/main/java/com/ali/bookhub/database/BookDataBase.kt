package com.ali.bookhub.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BookEntity::class], version = 1)
abstract class BookDataBase: RoomDatabase() {

    abstract fun bookDao():BookDao
}