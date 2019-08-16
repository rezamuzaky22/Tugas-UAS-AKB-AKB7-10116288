/*
Tanggal Pengerjaan : 15 Agustus 2019
NIM : 10116288
Nama : Muhammad Reza Muzaky
Kelas : AKB-7
 */

package com.rezamuzaky.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rezamuzaky.R;
import com.rezamuzaky.model.Friend;
import com.rezamuzaky.view.tambahTemanActivity;
import com.rezamuzaky.view.FriendListAdaptor;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class FriendFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend,container,false);
        Realm.init(getContext());
        Realm realm = Realm.getDefaultInstance();
        ArrayList<Friend> friends =  new ArrayList<>();
        RealmResults<Friend> friend = realm.where(Friend.class).findAll();
        for(Friend c : friend){
            friends.add(c);
        }
        FriendListAdaptor adaptor = new FriendListAdaptor(getContext(),R.layout.adapter_list,friends);

        ListView lvTeman = (ListView) view.findViewById(R.id.list);
        lvTeman.setAdapter(adaptor);
        Button btnTambahTeman = (Button) view.findViewById(R.id.btnAddFriends);
        btnTambahTeman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), tambahTemanActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
