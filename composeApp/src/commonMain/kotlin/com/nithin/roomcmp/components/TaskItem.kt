package com.nithin.roomcmp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nithin.roomcmp.data.Task
import org.jetbrains.compose.resources.painterResource
import room_cmp.composeapp.generated.resources.Res
import room_cmp.composeapp.generated.resources.delete_24

@Composable
fun TaskItem(
    index : Int,
    modifier: Modifier = Modifier,
    task : Task,
    onDeleteIconClick : (Task) -> Unit
){

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Text(
            text = "$index: ${task.id} : ${task.title} ",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            painter = painterResource(Res.drawable.delete_24),
            modifier = Modifier.size(24.dp).clickable{onDeleteIconClick.invoke(task)},
            contentDescription = "delete icon",

            )

    }


}