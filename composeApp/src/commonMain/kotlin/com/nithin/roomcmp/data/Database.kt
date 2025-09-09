package com.nithin.roomcmp.data

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [Task::class],
    version = 1
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class TaskDatabase : RoomDatabase(){
    abstract fun taskDao() : TaskDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("KotlinNoActualForExpect")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<TaskDatabase>{
    override fun initialize(): TaskDatabase
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<TaskDatabase>
): TaskDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}