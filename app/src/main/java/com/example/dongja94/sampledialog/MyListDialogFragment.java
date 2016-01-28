package com.example.dongja94.sampledialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

/**
 * Created by dongja94 on 2016-01-28.
 */
public class MyListDialogFragment extends DialogFragment {

    String[] items = {"item 1" , "item 2" , "item 3" , "item 4",
            "item 5","item 6" , "item 7" , "item 8" };

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("Dialog");

        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDialogFragment f = new MyDialogFragment();
                Fragment olddialog = getFragmentManager().findFragmentByTag("dialog");
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.remove(olddialog);
                ft.addToBackStack(null);
                f.show(ft, "childdialog");
            }
        });

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "Yes Click", Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }
}
