package com.example.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<ContactModel> contactModelList = generateRandomContacts(); // Generate 10 random contacts

        RecyclerView recyclerView = findViewById(R.id.RecyclerContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ContactAdapter adapter = new ContactAdapter(this, contactModelList);
        recyclerView.setAdapter(adapter);


    }

    private ArrayList<ContactModel> generateRandomContacts() {
        ArrayList<ContactModel> contacts = new ArrayList<>();
        Random random = new Random();

        // Sample data
        String[] names = {"Atharv Dange", "John Doe", "Jane Smith", "Alice Johnson"};
        String[] numbers = {"9890090110", "9890090111", "9890090112", "9890090113"};

        for (int i = 0; i < 10; i++) {
            // Randomly select a name and number
            String name = names[random.nextInt(names.length)];
            String number = numbers[random.nextInt(numbers.length)];

            // Create a ContactModel object and add it to the list
            ContactModel contact = new ContactModel(number, name);
            contacts.add(contact);
        }
        return contacts;
    }
}