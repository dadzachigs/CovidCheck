package co.zw.engineer.covidscreening.Results;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import co.zw.engineer.covidscreening.MainActivity;
import co.zw.engineer.covidscreening.R;

public class ResultNotClear extends AppCompatActivity {

    private TextView log;
    private Button finished;

    AlertDialog.Builder builder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_not_clear);
        log = findViewById(R.id.share);
        finished = findViewById(R.id.button);
        builder = new AlertDialog.Builder(this);

        log.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        finished.setOnClickListener(v -> {






        });
    }



    @Override
    public void onBackPressed() {


    }



    public void openDialog() {

        builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

        //Setting message manually and performing action on button click
        builder.setMessage("Your test result and the questions you selected will be saved and used for analysis by the national COVID-19 Task Force for decision making that will help you and the nation at large. Your identity will remain protected. " +
                "" +
                "If you are willing to save your result click ACCEPT and if you are not interested click DECLINE")
                .setCancelable(false)
                .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                })
                .setNegativeButton("Decline", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle(R.string.dialog_title);
        alert.show();
    }
}