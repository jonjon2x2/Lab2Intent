package com.example.taruc.lab2intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_TAG = "com.example.taruc.lab2intent.MESSAGE";
    private static final int REPLY_MESSAGE_CODE = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REPLY_MESSAGE_CODE && resultCode == RESULT_OK){
            TextView textViewReply;
            textViewReply = findViewById(R.id.textViewReply);

            if(data.hasExtra(secondActivity.REPLY_TAG)){
                String stringReply = data.getStringExtra(secondActivity.REPLY_TAG);
                textViewReply.setText(stringReply);
            }

            //TODO lololol good luck

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Main", "onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Main", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main", "onResume");
    }

    public void sendMessage(View view){
        EditText editTextMessage;
        editTextMessage = findViewById(R.id.editTextMessage);

        if(TextUtils.isEmpty(editTextMessage.getText())){
            editTextMessage.setError(getString(R.string.error_message));
            return;
        }
        String stringMsg = editTextMessage.getText().toString();
        //Use an Intent and pass data to SecondActivity
        Intent intent = new Intent(this, secondActivity.class);//Explicit Intent
        intent.putExtra(MESSAGE_TAG, stringMsg);
        startActivityForResult(intent, REPLY_MESSAGE_CODE);

    }
}
