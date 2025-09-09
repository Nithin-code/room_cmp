package com.nithin.roomcmp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nithin.roomcmp.data.Task
import com.nithin.roomcmp.data.TaskDao
import com.nithin.roomcmp.data.TaskDatabase
import com.nithin.roomcmp.data.getRoomDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel(val taskDao: TaskDao) : ViewModel() {



    val items = listOf(
        Task(
            title = "adhuadhai",
            content = "aiugdaud"
        ),
        Task(
            title = "adhuadhai",
            content = "aiugdaud"
        ),
        Task(
            title = "adhuadhai",
            content = "aiugdaud"
        ),
        Task(
            title = "adhuadhai",
            content = "aiugdaud"
        ),
    )

    val taskItems = taskDao
        .getTasksAsFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )



    fun deleteTask(task: Task) {
        viewModelScope.launch {
             taskDao.deleteTask(task)
        }
    }

    fun insertTask(task: Task){
        viewModelScope.launch {
            taskDao.insert(task)
        }
    }


}