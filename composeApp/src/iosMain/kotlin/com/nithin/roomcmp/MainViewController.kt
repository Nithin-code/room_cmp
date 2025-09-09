package com.nithin.roomcmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.nithin.roomcmp.data.getDatabaseBuilder

fun MainViewController() = ComposeUIViewController {

    val database = remember {
        getDatabaseBuilder().build()
    }

    App(database)
}