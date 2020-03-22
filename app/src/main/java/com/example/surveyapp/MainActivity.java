package com.example.surveyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button send_button, date_button;
    private EditText name, surname, city, occupation;
    private TextView date;
    private RadioButton male, female;
    private RadioGroup gender_radio_group;
    private DatePickerDialog datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.setContentView(R.layout.activity_main);

        send_button = findViewById(R.id.button);
        date_button = findViewById(R.id.date_button);
        name = findViewById(R.id.name_field);
        surname = findViewById(R.id.surname_field);
        city = findViewById(R.id.city_field);
        occupation = findViewById(R.id.occupation_field);
        date = findViewById(R.id.dateText);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        gender_radio_group = findViewById(R.id.radioGroup);


        date_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar today = Calendar.getInstance();
                String dateSelected = today.DAY_OF_MONTH + " - " + (today.MONTH + 1) + " - " + today.YEAR;
                date.setText(dateSelected);

                datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        String dateSelected = dayOfMonth + " - " + (monthOfYear + 1) + " - " + year;
                        date.setText(dateSelected);
                    }
                }, today.YEAR, today.MONTH, today.DAY_OF_MONTH);
                datePicker.show();
            }
        });

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Name can not be empty", Toast.LENGTH_SHORT).show();
                } else if (!name.getText().toString().matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")) {
                    Toast.makeText(getApplicationContext(), "Name should only contain English letters", Toast.LENGTH_SHORT).show();
                } else if (surname.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Surname can not be empty", Toast.LENGTH_SHORT).show();
                } else if (!surname.getText().toString().matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")) {
                    Toast.makeText(getApplicationContext(), "Surname should only contain English letters", Toast.LENGTH_SHORT).show();
                } else if (city.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "City can not be empty", Toast.LENGTH_SHORT).show();
                } else if (!city.getText().toString().matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")) {
                    Toast.makeText(getApplicationContext(), "City should only contain English letters", Toast.LENGTH_SHORT).show();
                }else if (city.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "City can not be empty", Toast.LENGTH_SHORT).show();
                } else if (!(male.isChecked() || female.isChecked())) {
                    Toast.makeText(getApplicationContext(), "You should specify your gender", Toast.LENGTH_SHORT).show();
                } else if (occupation.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Occupation can not be empty", Toast.LENGTH_SHORT).show();
                } else {
                    String gender_text;
                    if (male.isChecked())
                        gender_text = "Male";
                    else
                        gender_text = "Female";

                    OperationDialog dialog = new OperationDialog(MainActivity.this, name.getText().toString(), surname.getText().toString(), city.getText().toString(), date.getText().toString(), gender_text, occupation.getText().toString());
                    dialog.show();
                }
            }
        });

    }
}
