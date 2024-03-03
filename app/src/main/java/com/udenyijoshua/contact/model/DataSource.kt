package com.udenyijoshua.contact.model

class DataSource {

    private val contacts = mutableListOf<Contact>(
        Contact(
            "Udenyi Joshua",
            "08115598577",
            "udenyijoshua95@gmail.com"
        ),
        Contact(
            "Felix Ameh",
            "08115598577",
            "udenyijoshua95@gmail.com"
        )
    )

    fun loadContacts(): List<Contact> {
        return contacts.toList()
    }

    fun addContact(contact: Contact) {
        contacts.add(contact)
    }
}