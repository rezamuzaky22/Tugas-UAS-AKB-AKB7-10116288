/*
Tanggal Pengerjaan : 15 Agustus 2019
NIM : 10116288
Nama : Muhammad Reza Muzaky
Kelas : AKB-7
 */

package com.rezamuzaky.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.rezamuzaky.R;
import com.rezamuzaky.presenter.AddFriendPresenter;

public class tambahTemanActivity extends AppCompatActivity {
    private EditText inputName,inputEmail,inputNim,inputKelas,inputTlp,inputIg;
    private Button btnAddFriend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfriend);
        inputNim = (EditText) findViewById(R.id.input_nim);
        inputName = (EditText) findViewById(R.id.input_nama);
        inputKelas = (EditText) findViewById(R.id.input_kelas);
        inputTlp= (EditText) findViewById(R.id.input_tlp);
        inputIg = (EditText) findViewById(R.id.input_ig);
        inputEmail = (EditText) findViewById(R.id.input_email);
        btnAddFriend = (Button) findViewById(R.id.btn_saveFriend);

        final AddFriendPresenter AddFriendPresenter = new AddFriendPresenter();
                btnAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddFriendPresenter.btnAddClicked(
                        getBaseContext(),
                        inputNim,
                        inputName,
                        inputKelas,
                        inputTlp,
                        inputIg,
                        inputEmail
                );
            }
        });
    }
}
