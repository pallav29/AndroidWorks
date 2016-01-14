package project.coursera.android.modernartui;

import android.app.FragmentManager;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

import project.coursera.android.modernartui.R;

/**
 * MainActivity.java :This is the Launcher Activity of the Project.
 * @author  Pallav Johari
 * @version 1.0
 */
public class MainActivity extends ActionBarActivity {
    final String className= "MainActivity";
    SeekBar seekBar;

    /**
     * In this method  you initialize your activity. Here by using findViewById(int) you will
     * retrieve the widgets in that UI that you need to interact with programmatically.
     * In this method four views  with default background color
     * as red , white , Dark blue , pink and  purple blue are initialized.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int i=0;
        final View view_one=findViewById(R.id.view_01);
        final View view_two=findViewById(R.id.view_02);
        final View view_three=findViewById(R.id.view_03);
        final View view_four=findViewById(R.id.view_04);
        final View view_five=findViewById(R.id.view_05);

        view_one.setBackgroundColor(Color.rgb(102,102,255));
        view_two.setBackgroundColor(Color.rgb(255,153,204));
        view_three.setBackgroundColor(Color.rgb(155,0,0));
        view_four.setBackgroundColor(Color.rgb(255,255,255));
        view_five.setBackgroundColor(Color.rgb(0,0,204));
        seekBar=(SeekBar)findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * This method is used for notification that the progress level has changed.
             * In the project this method is responsible for changing the rectangles color
             * as the progress bar is moved left or right.
             * @param seekBar
             * @param increment
             * @param fromUser
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int increment, boolean fromUser) {

                Log.i(className,"In onProgressChanged method");
                view_one.setBackgroundColor(Color.rgb(102 + increment, 102 + increment, 255));
                view_two.setBackgroundColor(Color.rgb(255, 153 + increment, 204 + increment));
                view_three.setBackgroundColor(Color.rgb(155 - increment, 0, 0 + increment));
               // view_four.setBackgroundColor(Color.rgb(255 , 255, 0 + increment));
                view_five.setBackgroundColor(Color.rgb(0 + increment + 100, 0 + increment, 204));

            }

            /**
             * Notification that the user has started a touch gesture.
             * Clients may want to use this to disable advancing the seekbar.
             * In the project we are not using this method, but it can be utilized
             * based on client requirement.
             * @param seekBar
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i(className, "In onStartTrackingTouch method");

            }

            /**
             * Notification that the user has finished a touch gesture.
             * Clients may want to use this to re-enable advancing the seekbar.
             * In the project we are not using this method, but it can be utilized
             * based on client requirement.
             * @param seekBar
             */
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i(className,"In onStopTrackingTouch method");

            }
        });


    }

    /**
     * This method inflates the menu;
     * this adds items to the action bar if it is present
     * @param menu
     * @return boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(className,"In onCreateOptionsMenu method");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    /**
     * Handle action bar item clicks here. The action bar will
     * automatically handle clicks on the Home/Up button, so long
     * as you specify a parent activity in AndroidManifest.xml.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Log.i(className,"In onOptionsItemSelected method");
        int id = item.getItemId();


        if (id == R.id.action_settings) {
            openDialogFragment();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openDialogFragment() {
        Log.i(className,"In openDialogFragment method");
        FragmentManager fm=getFragmentManager();
        MyDialogFragment myDialogFragment=new MyDialogFragment();

        myDialogFragment.show(fm,"choose from here");

    }


}
