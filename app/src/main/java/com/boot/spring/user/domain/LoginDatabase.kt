package com.boot.spring.user.domain

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class LoginDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao

    companion object {
        private var instance: LoginDatabase? = null

        @Synchronized
        fun getInstance(context: Context) : LoginDatabase? {
            if(instance == null) {
                synchronized(LoginDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LoginDatabase::class.java,
                        "loginDB"
                    )
                        .build()
                }
            }
            return instance
        }
    }
}