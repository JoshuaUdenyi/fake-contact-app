package com.udenyijoshua.contact.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.udenyijoshua.contact.model.Contact
import com.udenyijoshua.contact.model.DataSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNewContact(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    dataSource: DataSource
){

    var fullNameState by rememberSaveable {
        mutableStateOf("")
    }

    var phoneNumberState by rememberSaveable {
        mutableStateOf("")
    }

    var emailState by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Create New Contact") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "Back_Btn"
                        )
                    }
                },
                actions = {
                    TextButton(onClick = {
                        if (fullNameState.isNotEmpty() && phoneNumberState.isNotEmpty() && emailState.isNotEmpty()) {
                            val newContact = Contact(
                                fullName = fullNameState,
                                phoneNumber = phoneNumberState,
                                email = emailState
                            )
                            // Add the new contact to the data source
                            dataSource.addContact(newContact)

                            // Clear the text fields after saving
                            fullNameState = ""
                            phoneNumberState = ""
                            emailState = ""

                            // Navigate back to the previous screen
                            navController.popBackStack()
                        } else {
                            // Show a message to the user indicating that all fields are required
                            // (you can implement this as per your UI design)
                        }
                    }) {
                        Text(text = "Save")
                    }
                }
            )
        }
    ) {defaultPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(defaultPadding)
        ) {
            //Fullname
            OutlinedTextField(
                value = fullNameState,
                onValueChange = { fullNameState = it },
                label = { Text(text = "Full Name") }
            )
            
            // Phone Number
            OutlinedTextField(
                value = phoneNumberState,
                onValueChange = { phoneNumberState = it},
                label = { Text(text = "Phone Number") }
            )

            // Email
            OutlinedTextField(
                value = emailState,
                onValueChange = { emailState = it },
                label = { Text(text = "Email") }
            )

        }

    }
}

//Make Sure your app shares thesame data

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CNCPreview(){

}