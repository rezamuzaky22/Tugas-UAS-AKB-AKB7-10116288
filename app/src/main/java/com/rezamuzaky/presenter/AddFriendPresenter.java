/*
Tanggal Pengerjaan : 15 Agustus 2019
NIM : 10116288
Nama : Muhammad Reza Muzaky
Kelas : AKB-7
 */

package com.rezamuzaky.presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.rezamuzaky.MainActivity;
import com.rezamuzaky.model.Friend;

import io.realm.Realm;

public class AddFriendPresenter {
    public void btnAddClicked(Context context,
                              EditText inputNim,
                              EditText inputName,
                              EditText inputKelas,
                              EditText inputTlp,
                              EditText inputIg,
                              EditText inputEmail
    ){
        if(!(inputNim.getText().toString().equals("") ||
                inputName.getText().toString().trim().equals("") ||
                inputKelas.getText().toString().trim().equals("") ||
                inputTlp.getText().toString().trim().equals("") ||
                inputIg.getText().toString().trim().equals("") ||
                inputEmail.getText().toString().trim().equals("")
        )){     Realm.init(context);
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                Number num = realm.where(Friend.class).max("id");
                int nextID;
                if(num == null) {
                    nextID = 1;
                } else {
                    nextID = num.intValue() + 1;
                }
                Friend friend = realm.createObject(Friend.class,nextID);
                friend.setNim(inputNim.getText().toString());
                friend.setNama(inputName.getText().toString());
                friend.setKelas(inputKelas.getText().toString());
                friend.setTelepon(inputTlp.getText().toString());
                friend.setInstagram(inputIg.getText().toString());
                friend.setEmail(inputEmail.getText().toString());
                realm.commitTransaction();
                Toast.makeText(context, "Data Teman Telah Berhasil Dimasukkan", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
        }else{
            Toast.makeText(context, "Data Tidak Boleh Ada Yang Kosong", Toast.LENGTH_SHORT).show();
        }
    }
}
