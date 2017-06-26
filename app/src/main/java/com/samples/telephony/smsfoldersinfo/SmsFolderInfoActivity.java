package com.samples.telephony.smsfoldersinfo;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SmsFolderInfoActivity extends ListActivity {

    private Cursor cursor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = this.getIntent().getExtras();
        Uri uri = Uri.parse(extras.getString("uri"));
        this.setTitle(uri.toString());

        cursor = getContentResolver().query(uri, null, null, null, null);
        startManagingCursor(cursor);

        String[] colomns = new String[]{"address", "body"};
        int[] row = new int[]{R.id.address, R.id.body};

        ListAdapter listAdapter = new SimpleCursorAdapter(
                this, R.layout.row, cursor, colomns, row);
        setListAdapter(listAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        cursor.moveToPosition(position);
        StringBuilder data = new StringBuilder();

        for (int i = 0; i < cursor.getColumnCount(); i++) {
            data.append(cursor.getColumnName(i) + ":\t" +
                    cursor.getString(i) + "\n");}

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("SMS Details");
        builder.setMessage(data.toString());
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {}
        });
        builder.show();
    }
}
