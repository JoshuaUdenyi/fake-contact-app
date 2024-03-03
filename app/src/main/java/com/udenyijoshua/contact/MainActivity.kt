package com.udenyijoshua.contact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.udenyijoshua.contact.model.Contact
import com.udenyijoshua.contact.model.DataSource
import com.udenyijoshua.contact.navigation.CreateNewContact
import com.udenyijoshua.contact.navigation.Home
import com.udenyijoshua.contact.navigation.ViewContact
import com.udenyijoshua.contact.screens.ContactList
import com.udenyijoshua.contact.screens.CreateNewContact
import com.udenyijoshua.contact.screens.ShowDetailsContact
import com.udenyijoshua.contact.ui.theme.ContactTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

private val dataSource = DataSource()
@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Home.route
    ){
        composable(Home.route){
            ContactList(navController, dataSource = dataSource)
        }
        composable(CreateNewContact.route){
            CreateNewContact(navController = navController, dataSource = dataSource)
        }
        composable("${ViewContact.route}/{fullName}"){ it -> // Handle route with parameter
            val fullName = it.arguments?.getString("fullName") // Retrieve the parameter
            val contact = dataSource.loadContacts().find { it.fullName == fullName } // Find the contact using the parameter
            if (contact != null) {
                ShowDetailsContact(contact)
            } else {
                // Handle error or show a placeholder
            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ContactTheme {

    }
}