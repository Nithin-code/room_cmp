package com.nithin.roomcmp.di

import com.nithin.roomcmp.data.TaskDao
import com.nithin.roomcmp.data.getRoomDatabase
import com.nithin.roomcmp.viewmodel.TaskViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

expect val platformModule : Module

val dataModule = module {

    single<TaskDao> { getRoomDatabase(get()).taskDao() }
    viewModelOf(::TaskViewModel)

}