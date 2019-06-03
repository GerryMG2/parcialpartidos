package com.example.mygames

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Partido::class), version = 1)
public abstract class RoomPartido : RoomDatabase() {

    abstract fun getPartidoDao(): PartidoDao

    companion object {
        @Volatile
        private var INSTANCE: RoomPartido? = null

        fun getDatabase(context: Context): RoomPartido {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomPartido::class.java,
                    "Word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}