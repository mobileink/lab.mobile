package com.example.android;

import android.app.Activity;	// = gui task
import android.os.Bundle;
import android.content.Intent; 	// = message
import android.widget.EditText;

public class MainActivity extends Activity
{
    public final static String EXTRA_MESSAGE = "com.example.android.MESSAGE";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
	//sig: public Intent (Context packageContext, Class<?> cls)
	// Activity inherits from Context
	Intent intent = new Intent(this, DisplayMessageActivity.class);
	// R.id.edit_message set by main.xml:
	//    <EditText android:id="@+id/edit_message"
	//    that makes it the id of the EditText view (widget)
	//    its content is set by strings.xml
	EditText editText = (EditText) findViewById(R.id.edit_message);
	String message = editText.getText().toString();
	intent.putExtra(EXTRA_MESSAGE, message);
	startActivity(intent);
    }
}
