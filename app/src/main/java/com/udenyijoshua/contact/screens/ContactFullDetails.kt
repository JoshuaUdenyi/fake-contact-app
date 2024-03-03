package com.udenyijoshua.contact.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.udenyijoshua.contact.model.Contact
import com.udenyijoshua.contact.model.DataSource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowDetailsContact(
    //navController: NavHostController,
    contact: Contact
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Details") },
                navigationIcon = {
                    IconButton(onClick = {
                        //navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "Back_Btn"
                        )
                    }
                }
            )
        }
    ) { defaultPadding ->


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(defaultPadding)
        ) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .width(500.dp)
                    .height(300.dp)
                    .background(Color.LightGray)
            ) {

            }
            Card(    modifier = Modifier
                .padding(12.dp) // Add padding to the Card itself
                .fillMaxWidth(),
                colors = CardDefaults.cardColors(Color.LightGray),
            ) {
                Text(
                    text = contact.fullName,
                    color = Color.Black,
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 8.dp) // Add vertical padding to the Column
                        .fillMaxWidth(),
                )
            }

            Card(    modifier = Modifier
                .padding(12.dp) // Add padding to the Card itself
                .fillMaxWidth(),
                colors = CardDefaults.cardColors(Color.LightGray),
            ) {
                Text(
                    text = contact.phoneNumber,
                    color = Color.Black,
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 8.dp) // Add vertical padding to the Column
                        .fillMaxWidth(),
                )
            }

            Card(    modifier = Modifier
                .padding(12.dp) // Add padding to the Card itself
                .fillMaxWidth(),
                colors = CardDefaults.cardColors(Color.LightGray),
            ) {
                Text(
                    text = contact.email,
                    color = Color.Black,
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 8.dp) // Add vertical padding to the Column
                        .fillMaxWidth(),
                )
            }
        }

    }

}

@Preview
@Composable
fun CardPreview() {
    //ShowDetailsContact(contact = contact)
}