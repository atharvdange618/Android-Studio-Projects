package com.example.loginpage_example;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loginpage_example.adapters.CustomActAdapter;
import com.example.loginpage_example.adapters.CustomSpinnerAdapter;
import com.example.loginpage_example.models.SpinnerItemModel;
import com.example.loginpage_example.models.UserSignUpDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    boolean isAllFieldsChecked = false;
    private String[] country = {"india", "russia", "usa", "china", "australia"};
    private EditText etName, etEmail, etContact, etPassword;
    private AutoCompleteTextView actState;
    private RadioGroup rgGender;
    private Spinner spCountry;
    private Button signUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initResources();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    private void initResources() {
        mAuth = FirebaseAuth.getInstance();
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etContact = findViewById(R.id.et_contact);
        etPassword = findViewById(R.id.et_password);
        rgGender = findViewById(R.id.rg_gender);
        spCountry = findViewById(R.id.sp_country);
        List<SpinnerItemModel> dataList = new ArrayList<>();

        for (String con : country) {
            SpinnerItemModel itemModel = new SpinnerItemModel(con.toUpperCase(Locale.ROOT), getResources().getIdentifier(con, "drawable", getPackageName()));
            dataList.add(itemModel);
        }
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, R.layout.spinner_dropdown_item, dataList);
        spCountry.setAdapter(adapter);


        String[] states = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar",
                "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh",
                "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh",
                "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha",
                "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
                "Uttarakhand", "Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands",
                "Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Lakshadweep",
                "Puducherry"};
        actState = findViewById(R.id.act_state);

        List<String> stateList = Arrays.asList(states);
        CustomActAdapter customActAdapter = new CustomActAdapter(this, R.layout.act_dropdown_item, stateList);
        actState.setThreshold(1);
        actState.setAdapter(customActAdapter);


        signUp = findViewById(R.id.btn_signup);
        signUp.setOnClickListener(this);

        TextView signIn = findViewById(R.id.already_account);
        signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_signup) {
            isAllFieldsChecked = CheckAllFields();
            if (isAllFieldsChecked) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                RadioButton rbGender = findViewById(rgGender.getCheckedRadioButtonId());
                UserSignUpDetails details = new UserSignUpDetails();
                details.setName(etName.getText().toString());
                details.setEmail(email);
                details.setContact(etContact.getText().toString());
                details.setGender(rbGender.getText().toString());
                SpinnerItemModel sp = (SpinnerItemModel) spCountry.getSelectedItem();
                details.setCountry(sp.getTvCountry());
                details.setState(actState.getText().toString());
                details.setPassword(password);

//                Intent intent = new Intent(this,ProfileActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("UserDetails",details);
//                intent.putExtras(bundle);
//                startActivity(intent);
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d("status", "createUserWithEmail:success");

                                    FirebaseUser user = mAuth.getCurrentUser();
                                } else {
                                    Log.w("status", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(MainActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                Toast.makeText(this, "Registered Successfully", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Error Occured", Toast.LENGTH_LONG).show();
            }
        } else if (v.getId() == R.id.already_account) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
    }

    private boolean CheckAllFields() {
        if (etName.length() == 0) {
            etName.setError("This field is required");
            return false;
        }

        if (etEmail.length() == 0) {
            etEmail.setError("Email is required");
            return false;
        }
        if (etContact.length() == 0) {
            etContact.setError("Contact is required");
            return false;
        } else if (etContact.length() > 10 || etContact.length() <= 9) {
            etContact.setError("Number must be of 11 digits");
            return false;
        }

        return true;
    }
}