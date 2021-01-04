package com.example.jobapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobapplication.data.JobListing;

public class AddJobs extends AppCompatActivity {

    EditText txtJobName, txtJobDesc, txtJobSalary;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_jobs);

        txtJobName = (EditText) findViewById(R.id.txt_job_name);
        txtJobDesc = (EditText) findViewById(R.id.txt_job_desc);
        txtJobSalary = (EditText) findViewById(R.id.txt_job_salary);

        btnSubmit = (Button) findViewById(R.id.btn_add_jobs_submit);
    }

    public void btn_clicked_submit_job(View view){

        String jn = txtJobName.getText().toString();
        String jD = txtJobDesc.getText().toString();
        double sal = Double.parseDouble(txtJobSalary.getText().toString());

        if(!(jn.isEmpty() || jD.isEmpty() || sal == 0)){

            JobListing listing = new JobListing();
            boolean val = listing.addNewJob(jn, jD, sal);

            if(val == true){
                Toast.makeText(AddJobs.this, "The job is added", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(AddJobs.this, "Sorry we couldn't add.", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(AddJobs.this, "The values shouldn't be empty", Toast.LENGTH_SHORT).show();
        }

    }
}