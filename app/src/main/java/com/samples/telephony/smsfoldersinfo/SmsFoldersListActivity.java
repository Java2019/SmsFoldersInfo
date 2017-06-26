package com.samples.telephony.smsfoldersinfo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by use on 26.06.17.
 */
public class SmsFoldersListActivity extends ListActivity {

    private String[] folders = {"inbox", "sent", "draft", "outbox", "failed",
            "queued", "undelivered", "conversations"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, folders));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), SmsFolderInfoActivity.class);
        intent.putExtra("uri", "content://sms/" + folders[position]);
        startActivity(intent);
    }
}
