package com.nithin.roomcmp.di

import androidx.room.RoomDatabase
import com.nithin.roomcmp.data.TaskDatabase
import com.nithin.roomcmp.data.getDatabaseBuilder
import com.nithin.roomcmp.data.getRoomDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<RoomDatabase.Builder<TaskDatabase>> { getDatabaseBuilder() }
}