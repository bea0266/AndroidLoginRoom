package com.boot.spring.user.domain

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(user: User)

    @Query("SELECT * FROM User WHERE USER_ID = :userId")
    suspend fun findByUserId(userId: String) : User

    @Query("SELECT * FROM User")
    suspend fun findAll() : List<User>
}