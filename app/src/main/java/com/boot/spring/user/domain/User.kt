package com.boot.spring.user.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) var id: Long? = 0,
    @ColumnInfo(name = "USER_ID") val userId: String,
    @ColumnInfo(name = "PASSWORD") val password: String,
    @ColumnInfo(name = "NAME") val name: String,
    @ColumnInfo(name = "ADDRESS") val address: String
) {

}
