package com.udenyijoshua.contact.navigation

interface Destination {
    val route:String
}

object Home:Destination{
    override val route = "ContactList"
}
object CreateNewContact:Destination{
    override val route = "CreateNewContact"
}
object ViewContact:Destination{
    override val route = "ShowDetailsContact"
}