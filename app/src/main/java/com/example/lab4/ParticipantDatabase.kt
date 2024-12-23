package com.example.lab4

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Participant::class], version = 1, exportSchema = false)
abstract class ParticipantDatabase : RoomDatabase() {
    abstract fun participantDao(): ParticipantDao

    //TODO 2: implement the companion object
    companion object {
        @Volatile
        private var INSTANCE: ParticipantDatabase? = null

        fun getInstance(context: android.content.Context): ParticipantDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ParticipantDatabase::class.java,
                    "participant_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}
