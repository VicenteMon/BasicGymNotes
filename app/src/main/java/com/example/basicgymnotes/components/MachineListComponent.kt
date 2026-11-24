package com.example.basicgymnotes.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import com.example.basicgymnotes.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicgymnotes.entities.Machine
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun MachineListComponent(
    machine: Machine,
    navigateToDetailScreen: (id: Int) -> Unit
)
{
    var isPressed by remember { mutableStateOf(false) }
    Row(
        Modifier.fillMaxWidth()
            .background(if(!isPressed) Color.LightGray else Color.Black).padding(vertical = 15.dp, horizontal = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row (
            Modifier.weight(0.7f),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(R.drawable.pooping),
                contentDescription = null,
                Modifier.size(60.dp).padding(end = 5.dp)
            )
            Text(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                text = machine.name
            )
        }
        Box(
            modifier = Modifier.weight(0.3f).pointerInput(Unit) {
                detectTapGestures (
                    onPress = {
                        isPressed = true
                    },
                    onTap = {
                        isPressed = false
                        navigateToDetailScreen(machine.id)
                    }
                )
            },
            contentAlignment = Alignment.TopEnd
        ){
            Icon(modifier = Modifier.padding(end = 20.dp), imageVector = Icons.Filled.Add, contentDescription = null)
        }
    }

}

@Composable
@Preview
fun MachineListComponentPreview() {
    val machine = Machine(1, "Nombre", "src/image.png")
    MachineListComponent(machine = machine, navigateToDetailScreen = {/*TODO*/})
}