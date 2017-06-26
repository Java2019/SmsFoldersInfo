package com.samples.telephony.smsfoldersinfo;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class SmsFolderInfoActivity extends ListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = this.getIntent().getExtras();
        Uri uri = Uri.parse(extras.getString("uri"));
        this.setTitle(uri.toString());

        Cursor cursor =
                getContentResolver().query(uri, null, null, null, null);
        startManagingCursor(cursor);

        String[] colomns = new String[]{"address", "body"};
        int[] row = new int[]{R.id.address, R.id.body};

        ListAdapter listAdapter = new SimpleCursorAdapter(
                this, R.layout.row, cursor, colomns, row);
        setListAdapter(listAdapter);

    }
}
