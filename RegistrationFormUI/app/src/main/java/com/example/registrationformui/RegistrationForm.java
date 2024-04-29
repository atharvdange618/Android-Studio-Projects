package com.example.registrationformui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class RegistrationForm extends AppCompatActivity {

    private EditText edtName;
    private RadioGroup radioGroup;
    private CheckBox checkboxBE, checkboxDiploma, checkboxBtech, terms;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        // Initialize views
        edtName = findViewById(R.id.edtname);
        radioGroup = findViewById(R.id.radio);
        checkboxBE = findViewById(R.id.checkboxBE);
        checkboxDiploma = findViewById(R.id.checkboxDiploma);
        checkboxBtech = findViewById(R.id.checkboxbtech);
        terms = findViewById(R.id.terms);
        spinner = findViewById(R.id.spinner);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnDialog = findViewById(R.id.btnDialog);

        // Populate Spinner with data
        List<String> subjects = new ArrayList<>();
        subjects.add("Mathematics");
        subjects.add("Physics");
        subjects.add("Chemistry");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Handle Button click events
        btnLogin.setOnClickListener(v -> {
            // Retrieve data from EditText
            String name = edtName.getText().toString().trim();

            // Retrieve data from RadioGroup
            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = findViewById(selectedId);
            String gender = radioButton.getText().toString();

            // Retrieve data from CheckBoxes
            StringBuilder qualification = new StringBuilder();
            if (checkboxBE.isChecked()) {
                qualification.append("BE, ");
            }
            if (checkboxDiploma.isChecked()) {
                qualification.append("Diploma, ");
            }
            if (checkboxBtech.isChecked()) {
                qualification.append("B-tech, ");
            }

            // Retrieve data from Spinner
            String selectedSubject = spinner.getSelectedItem().toString();

            // Check if terms checkbox is checked
            boolean agreedToTerms = terms.isChecked();

            // Check if all fields are filled
            if (name.isEmpty() || qualification.toString().isEmpty() || !agreedToTerms) {
                Toast.makeText(RegistrationForm.this, "Please fill all fields and agree to terms", Toast.LENGTH_SHORT).show();
            } else {
                // If all fields are filled, proceed to next activity
                Intent intent = new Intent(RegistrationForm.this, Data.class);
                intent.putExtra("Name", name);
                intent.putExtra("Gender", gender);
                intent.putExtra("Qualification", qualification.toString());
                intent.putExtra("Subject", selectedSubject);
                startActivity(intent);
            }
        });

        // Handle Dialog Button click event
        btnDialog.setOnClickListener(v -> {
            // Show a dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationForm.this);
            builder.setTitle("Dialog Title")
                    .setMessage("This is a dialog message.")
                    .setPositiveButton("OK", (dialog, which) -> {
                        // Handle positive button click (if needed)
                        dialog.dismiss(); // Dismiss the dialog
                    })
                    .setNegativeButton("Cancel", (dialog, which) -> {
                        // Handle negative button click (if needed)
                        dialog.dismiss(); // Dismiss the dialog
                    })
                    .show(); // Show the dialog

        });
    }
}