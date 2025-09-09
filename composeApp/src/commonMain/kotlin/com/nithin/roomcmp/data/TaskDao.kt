package com.nithin.roomcmp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(item: Task)

    @Query("SELECT count(*) FROM Task")
    suspend fun count(): Int

    @Query("SELECT * FROM Task")
    fun getTasksAsFlow(): Flow<List<Task>>

    @Delete
    suspend fun deleteTask(task: Task)
}