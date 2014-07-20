package com.example.android;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.content.Intent;
// import android.support.v7.app.ActionBar
// import android.support.v7.app.ActionBarActivity
import android.view.*;
import android.widget.TextView;

class DisplayMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	// get message from sending intent
	Intent myintent = getIntent();
	String message = myintent.getStringExtra(MainActivity.EXTRA_MESSAGE);

	// Create the text view
	TextView mytextView = new TextView(this);
	mytextView.setTextSize(40);
	mytextView.setText(message);

	// Set the text view as the activity layout
	setContentView(mytextView);
    }

    // @Override
    // protected void onCreate(Bundle savedInstanceState) {
    // 	super.onCreate(savedInstanceState);
    // 	setContentView(R.layout.activity_display_message);
    // 	if (savedInstanceState == null) {
    // 	    getSupportFragmentManager().beginTransaction()
    // 		.add(R.id.container, new PlaceholderFragment()).commit();
    // 	}
    // }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() { }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                  Bundle savedInstanceState) {
              View rootView = inflater.inflate(R.layout.fragment_display_message,
                      container, false);
              return rootView;
        }
    }
}

