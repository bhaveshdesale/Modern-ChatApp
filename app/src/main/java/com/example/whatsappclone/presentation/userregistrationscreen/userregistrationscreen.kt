package com.example.whatsappclone.presentation.userregistrationscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.input.TextFieldCharSequence
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappclone.R
import javax.sql.RowSetWriter

@Preview(showSystemUi = true)
@Composable
fun UserRegistrationScreen(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) } //this variable is used for country selection , and it will maintaining its state
    var selectedCountry by remember { mutableStateOf("Japan") }//this is will by default set country as japan as user interact with the country field
    var countryCode by remember { mutableStateOf("+81") }
    var phoneNumber by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Enter your phone number",
            fontSize = 20.sp,
            color = colorResource(id = R.color.dark_green),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.heightIn(24.dp))
        Row(modifier = Modifier) {
            Text(text = "Whatsapp need to verify your phone number")
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "what's ", color = colorResource(id = R.color.dark_green))
        }
        Text(text = "My Number", color = colorResource(R.color.dark_green))
        Spacer(modifier = Modifier.heightIn(16.dp))
        TextButton(onClick = { expanded = true }, modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.width(200.dp)) {
                Text(
                    text = selectedCountry,
                    modifier.align(Alignment.Center),
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    modifier.align(Alignment.CenterEnd),
                    tint = colorResource(id = R.color.light_green)
                )


            }

        }
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 66.dp),
            thickness = 2.dp,
            color = colorResource(R.color.light_green)
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.align(Alignment.CenterHorizontally).width(200.dp).height(150.dp)
        ) {
            listOf("India", "USA", "China", "Canada").forEach { country ->
                DropdownMenuItem(text = { Text(text = country) }, onClick = {
                    selectedCountry = country //country will assign to the selecetCountry
                    expanded =
                        false //dropdown menu will automatically close after selecting the country
                })
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                TextField(
                    value = countryCode,
                    onValueChange = {
                        countryCode = it

                    },
                    modifier = Modifier.width(70.dp),
                    singleLine = true,
                    textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = colorResource(id = R.color.light_green),
                        focusedIndicatorColor = colorResource(id = R.color.light_green)

                    )
                )
                Spacer(modifier = Modifier.widthIn(6.dp))
                TextField(
                    value = phoneNumber,
                    onValueChange = {
                        phoneNumber = it
                    },
                    placeholder = { Text(text = "Phone Number") },
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = colorResource(id = R.color.light_green),
                        focusedIndicatorColor = colorResource(id = R.color.light_green)

                    )
                )
            }
            Spacer(modifier = Modifier.heightIn(16.dp))
            Text(
                text = "Carrier Charges may apply",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
            Spacer(modifier = Modifier.heightIn(26.dp))
            Button(
                onClick = {},
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_green))
            ) {
                Text(text = "Next", fontSize = 16.sp)
            }


        }

    }

}