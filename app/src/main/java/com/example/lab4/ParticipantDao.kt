package com.example.lab4

import androidx.room.*

@Dao
interface ParticipantDao {

//TODO 1: implement the functions for inserting, deleting and getting all participants
@Insert
suspend fun insertParticipant(participant: Participant)

    @Delete
    suspend fun deleteParticipant(participant: Participant)

    @Query("SELECT * FROM participants")
    suspend fun getAllParticipants(): List<Participant>
}