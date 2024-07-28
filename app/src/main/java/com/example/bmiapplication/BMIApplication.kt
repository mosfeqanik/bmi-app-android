package com.example.bmiapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BMIApplication(modifier: Modifier = Modifier) {
    var weight by remember {
        mutableStateOf("")
    }
    var height by remember {
        mutableStateOf("")
    }
    var bmi by remember {
        mutableStateOf("0.0")
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        weightHeightField(
            label = "Enter your weight (in kg)",
            value = weight,
            onValueChange = { weight = it }, keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ))

        weightHeightField(
            label = "Enter your height (in meter)",
            value = height,
            onValueChange = { height = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ))
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Calculate BMI")
        }

    }
}

@Composable
fun BmiResultView(result: String, modifier: Modifier = Modifier) {
    Text(
        text = "your BMI is $result",
        modifier = modifier,
        textAlign = TextAlign.Center,
        fontSize = 20.sp
    )
}

fun calculateBmi(weight: Double, height: Double): String {
    val bmi = weight / (height * height)
    return String.format("%.1f",bmi)
}

@Composable
fun weightHeightField(
    label: String,
    value: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
//    "Enter your weight (in kg)"
    TextField(
        label = {
            Text(text = label)
        },
        keyboardOptions = keyboardOptions,
        value = value, onValueChange = onValueChange, modifier = modifier.padding(4.dp)
    )
}

@Preview
@Composable
fun BMIApplicationPreview() {
    BMIApplication()
}