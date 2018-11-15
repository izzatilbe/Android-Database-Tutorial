package com.example.bryan.databasetutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputField;
    EditText updateField;
    EditText newDataField;
    TextView listView;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.inputField);
        updateField = findViewById(R.id.updateField);
        newDataField = findViewById(R.id.newDataField);
        listView = findViewById(R.id.listView);

        dbManager = new DBManager(this);

        printDatabase();
    }

    public void printDatabase(){
        String dbString = dbManager.getTableData();

        listView.setText(dbString);
        inputField.setText("");
        updateField.setText("");
        newDataField.setText("");
    }

    public void addRow(View view){
        Row row = new Row(inputField.getText().toString());

        dbManager.addRow(row);

        printDatabase();
    }

    public void deleteRow(View view){
        dbManager.deleteRow(inputField.getText().toString());

        printDatabase();
    }

    public void updateRow(View view){
        dbManager.updateRow(updateField.getText().toString(), newDataField.getText().toString());

        printDatabase();
    }
}










