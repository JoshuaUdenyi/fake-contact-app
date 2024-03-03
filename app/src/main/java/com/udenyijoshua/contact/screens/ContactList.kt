package com.udenyijoshua.contact.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.udenyijoshua.contact.components.ContactMinimized
import com.udenyijoshua.contact.model.Contact
import com.udenyijoshua.contact.model.DataSource
import androidx.navigation.NavHostController
import com.udenyijoshua.contact.navigation.CreateNewContact
import com.udenyijoshua.contact.navigation.ViewContact


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactList(navController: NavHostController, dataSource: DataSource) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle action icon click */ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Favorites")
                    }
                },
                title = {
                    Text(
                        text = "Contacts",
                        maxLines = 1
                    )
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(CreateNewContact.route)
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
                ListContacts(
                    contactList = dataSource.loadContacts(),
                    navController = navController,
                )
        }
    }
}

@Composable
fun ListContacts(
    navController: NavHostController,
    contactList: List<Contact>,
    modifier: Modifier = Modifier

){
    LazyColumn(modifier = Modifier){
            items(contactList){contact ->
                ContactMinimized(
                    contact = contact,
                    navController = navController,
                )
            }

    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ContactListPreview(){

}
