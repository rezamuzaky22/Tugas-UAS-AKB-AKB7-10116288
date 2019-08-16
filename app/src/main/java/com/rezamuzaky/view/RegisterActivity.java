/*
Tanggal Pengerjaan : 15 Agustus 2019
NIM : 10116288
Nama : Muhammad Reza Muzaky
Kelas : AKB-7
 */

package com.rezamuzaky.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rezamuzaky.R;
import com.rezamuzaky.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity {
    private EditText inputName,inputEmail,inputPassword,inputRepassword;
    private Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        inputName = (EditText) findViewById(R.id.input_name);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);
        inputRepassword = (EditText) findViewById(R.id.input_repassword);
        btnRegister = (Button) findViewById(R.id.btn_register);

        final RegisterPresenter registerPresenter = new RegisterPresenter();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerPresenter.btnRegisterClicked(
                        getBaseContext(),
                        inputName,
                        inputEmail,
                        inputPassword,
                        inputRepassword
                );
            }
        });
    }
}
