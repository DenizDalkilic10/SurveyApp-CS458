package com.example.surveyapp;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class OperationDialog extends Dialog implements View.OnClickListener {
    public Activity activity;
    private String name;
    private String surname;
    private String city;
    private String birthdate;
    private String occupation;
    private String gender;
    private TextView submissionDetails;
    private TextView submissionResult;
    private Button dismissButton;

    public OperationDialog() {
        super(null);
    }

    public OperationDialog(Activity activity, String name, String surname, String city, String birthdate, String gender, String occupation) {
        super(activity);
        this.activity = activity;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.birthdate = birthdate;
        this.gender = gender;
        this.occupation = occupation;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.operation_dialog);

        submissionDetails = findViewById(R.id.submission_details);
        submissionResult = findViewById(R.id.submission_result);
        dismissButton = findViewById(R.id.dismiss_button);

        submissionDetails.setText(name + " " + surname + "\n\n" + gender + "\n\n" + birthdate + "\n\n" + city + "\n\n" + occupation);
        submissionResult.setText("Successful Submission");

        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }


    @Override
    public void onClick(View v) {
        dismiss();
    }
}
