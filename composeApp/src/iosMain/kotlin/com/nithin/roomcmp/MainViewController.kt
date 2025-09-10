package com.nithin.roomcmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.nithin.roomcmp.data.getDatabaseBuilder
import com.nithin.roomcmp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure =  { initKoin() }
) {


    App()
}