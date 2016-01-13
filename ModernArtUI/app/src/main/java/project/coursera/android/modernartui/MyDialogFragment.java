package project.coursera.android.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/**
 * MyDialogFragment.java :This is a fragment class that displays a dialog window,
 * floating on top of its activity's window.
 * @author  Pallav Johari
 * @version 1.0
 */
public class MyDialogFragment extends DialogFragment {

    final String className= "MyDialogFragment";

    /**
     * It is used to build your own custom Dialog container. This is typically used to show an
     * AlertDialog instead of a generic Dialog.
     * In this project , this method is used to create custom alert box for selecting whether user
     * wants to open wepage or not.
     * @param savedInstanceState
     * @return
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.i(className, "In onCreateDialog method");
        DialogInterface.OnClickListener positiveClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.moma.org"));
                getActivity().startActivity(intent);
            }
        };

        DialogInterface.OnClickListener negativeClick = new DialogInterface.OnClickListener() {
            /**
             * This method is used for mapping the onClick event with the OnClickListener method.
             * Here user can specify the type of operation he wants to perform when the user clicks on the button.
             * @param dialog
             * @param which
             */
            @Override
            public void onClick(DialogInterface dialog, int which) {


                dismiss();
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setNegativeButton("Not Now", negativeClick);
        builder.setPositiveButton("Visit MOMA", positiveClick);
        builder.setTitle("Visit to learn more");
        Dialog dialog = builder.create();
        return dialog;
    }
}