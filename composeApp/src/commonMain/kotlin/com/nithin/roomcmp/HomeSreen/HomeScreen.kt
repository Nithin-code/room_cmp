package com.nithin.roomcmp.HomeSreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.nithin.roomcmp.components.Header
import com.nithin.roomcmp.components.TaskItem
import com.nithin.roomcmp.viewmodel.TaskViewModel
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun HomeScreen(
    taskViewModel : TaskViewModel = koinViewModel()
){

    val taskItems by taskViewModel.taskItems.collectAsState()



    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            Header(
                subTitle = "Today, 10'Sep"
            )
        }

        item {
            HorizontalDivider(
                modifier = Modifier,
                thickness = 1.dp,
                color = Color.Gray
            )
        }


        itemsIndexed(taskItems){ index, item->
            TaskItem(
                task = item,
                onDeleteIconClick = { task ->
                    taskViewModel.deleteTask(task)
                },
                index = index,
            )

        }

    }

}