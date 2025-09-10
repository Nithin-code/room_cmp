package com.nithin.roomcmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nithin.roomcmp.HomeSreen.HomeScreen
import com.nithin.roomcmp.components.TaskItem
import com.nithin.roomcmp.data.Task
import com.nithin.roomcmp.data.TaskDatabase
import com.nithin.roomcmp.viewmodel.TaskViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.compose_multiplatform
import kotlin.collections.addAll

@Composable
@Preview
fun App(
    taskViewModel: TaskViewModel = koinViewModel()
) {

    RecomposeCounter("App")




    MaterialTheme {

        LaunchedEffect(Unit){
            taskViewModel.items.forEach { task ->
                taskViewModel.insertTask(task)
            }
        }

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFF3F4F6)),
            floatingActionButton = {
                Surface(
                    modifier = Modifier,
                    shape = CircleShape,
                    color = Color.Black
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        modifier = Modifier
                            .padding(16.dp)
                            .size(24.dp),
                        tint = Color.White
                    )
                }
            }
        ) { paddingValues ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding()
                    )
                    .padding(horizontal = 24.dp)
            ){

                HomeScreen()

            }

        }


    }
}

@Composable
fun RecomposeCounter(tag: String) {
    var count by remember { mutableStateOf(0) }

    SideEffect {
        count++
        println("RecomposeTracker $tag recomposed $count times")
    }
}