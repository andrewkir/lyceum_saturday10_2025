package com.example.lyceum_saturday10_2025.examples

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lyceum_saturday10_2025.ui.theme.Lyceum_saturday10_2025Theme

@Composable
fun Profile() {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Gray)
                    .size(64.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "IP"
                )
            }

            Spacer(Modifier.width(16.dp))

            Text("Ivan Petrov")

            Spacer(Modifier.weight(1f))
        }

        Button(
            onClick = {
                count++
            }
        ) {
            Text("Увеличить счетчик")
        }

        Spacer(Modifier.height(8.dp))

        Text("Текущее значение - $count")

        Spacer(Modifier.height(16.dp))

        var textFieldValue by remember { mutableStateOf("") }
        OutlinedTextField(
            value = textFieldValue,
            onValueChange = { newValue ->
                textFieldValue = newValue
            },
        )

        Spacer(Modifier.height(8.dp))

        Text("Введенный текст - $textFieldValue")
    }
}

@Composable
@Preview(showBackground = true)
private fun PreviewPreview() {
    Column(Modifier.fillMaxSize()) {
        Profile()
    }
}