package com.example.basicgymnotes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import com.example.basicgymnotes.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicgymnotes.entities.Machine

@Composable
fun MachineListComponent(
    machine: Machine,
    navigateToDetailScreen: (id: Int) -> Unit
)
{
    Row(
        Modifier.fillMaxWidth()
            .background(Color.Gray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row (
            Modifier.background(Color.Red),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(R.drawable.pooping),
                contentDescription = null,
                Modifier.size(60.dp)
            )
            Text(text = machine.name)
        }
        Button(onClick = { navigateToDetailScreen(machine.id) }) {
            Text(text = "Ir a detalle")
        }
    }

}

@Composable
@Preview
fun MachineListComponentPreview() {
    val machine = Machine(1, "Nombre", "src/image.png")
    MachineListComponent(machine = machine, navigateToDetailScreen = {/*TODO*/})
}