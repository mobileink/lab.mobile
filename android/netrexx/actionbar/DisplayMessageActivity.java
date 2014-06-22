package com.example.myfirstapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class DisplayMessageActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_display_message);

		Intent intent = getIntent();
		String message = intent.getStringExtra(FullscreenActivity.EXTRA_MESSAGE);

		TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText(message);
		setContentView(textView);

		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}



// public class DisplayMessageActivity extends ActionBarActivity {

//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_display_message);

//         if (savedInstanceState == null) {
//             getSupportFragmentManager().beginTransaction()
//                 .add(R.id.container, new PlaceholderFragment()).commit();
//         }
//     }

//     @Override
//     public boolean onOptionsItemSelected(MenuItem item) {
//         // Handle action bar item clicks here. The action bar will
//         // automatically handle clicks on the Home/Up button, so long
//         // as you specify a parent activity in AndroidManifest.xml.
//         int id = item.getItemId();
//         if (id == R.id.action_settings) {
//             return true;
//         }
//         return super.onOptionsItemSelected(item);
//     }

//     /**
//      * A placeholder fragment containing a simple view.
//      */
//     public static class PlaceholderFragment extends Fragment {

//         public PlaceholderFragment() { }

//         @Override
//         public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                   Bundle savedInstanceState) {
//               View rootView = inflater.inflate(R.layout.fragment_display_message,
//                       container, false);
//               return rootView;
//         }
//     }
// }
