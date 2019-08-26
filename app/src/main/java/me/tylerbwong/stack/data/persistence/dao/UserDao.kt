package me.tylerbwong.stack.data.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import me.tylerbwong.stack.data.persistence.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(users: List<UserEntity>)

    @Query("SELECT * FROM user WHERE userId = :userId")
    suspend fun get(userId: Int): UserEntity

    @Query("SELECT * FROM user WHERE accountId = :accountId")
    suspend fun getCurrentUser(accountId: Int): UserEntity
}
