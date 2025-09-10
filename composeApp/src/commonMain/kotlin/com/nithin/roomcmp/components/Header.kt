package com.nithin.roomcmp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(
    modifier: Modifier = Modifier,
    title : String = "My Tasks",
    subTitle : String
){

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
        ) {

            Text(
                text = title,
                color = Color.Black,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = subTitle,
                fontSize = 16.sp,
                color = Color.Gray
            )

        }

        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "search",
            modifier = Modifier.size(24.dp),
            tint = Color.Black,
        )

        Spacer(
            modifier = Modifier.width(16.dp)
        )

        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = "search",
            modifier = Modifier.size(24.dp),
            tint = Color.Black,
        )

    }

}