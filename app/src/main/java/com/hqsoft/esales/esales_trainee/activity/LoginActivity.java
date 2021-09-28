package com.hqsoft.esales.esales_trainee.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.hqsoft.esales.esales_trainee.R;
import com.hqsoft.esales.esales_trainee.bll.AR_SalespersonHandler;
import com.hqsoft.esales.esales_trainee.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private static ActivityLoginBinding binding;
    AR_SalespersonHandler db = new AR_SalespersonHandler(LoginActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        onAction();
    }

    private void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null) {
            activity.getWindow().getDecorView();
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
            }
        }
    }

    private void onAction() {
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(LoginActivity.this);
                String username = binding.userNameEdt.getText().toString();
                String password = binding.passwordEdt.getText().toString();

                if(username.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Vui lòng nhập username !!!",Toast.LENGTH_SHORT).show();

                }
                else if( password.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Vui lòng nhập password !!!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkLogin = db.checkUser(username, password);
                    if (checkLogin == true) {
                        Toast.makeText(getApplicationContext(), "Login Success !", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("username",username);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this,"UserName or Password is Wrong, Please Try Again.",Toast.LENGTH_LONG).show();
                    }
                }
            }

        });
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}