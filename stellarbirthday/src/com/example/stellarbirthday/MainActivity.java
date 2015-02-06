package com.example.stellarbirthday;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;


public class MainActivity extends Activity {
	Uri fileUri; 
	private DatePicker dpResult;
	private Button changeDate;
	private int year, month, day;
	static final int DATE_PICKER_ID = 1111; 
//	final Calendar c;
	private TextView Output;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		changeDate = (Button) findViewById(R.id.changeDate);
		Output = (TextView) findViewById(R.id.userInfoTextView);
		dpResult = (DatePicker) findViewById(R.id.date_picker);
		
        // -- get current date by calender
        final Calendar c = Calendar.getInstance();
        year  = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day   = c.get(Calendar.DAY_OF_MONTH);
        
        // Show current date
        changeDate.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(month + 1).append("-").append(day).append("-")
                .append(year).append(" "));
        
        
        // Button listener to show date picker dialog   
        changeDate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                 
                // On button click show datepicker dialog 
                showDialog(DATE_PICKER_ID);
 
            }
 
        });
     
        // --DatePicker listener
        Calendar today = Calendar.getInstance();
        dpResult.init(
        	    today.get(Calendar.YEAR), 
        	    today.get(Calendar.MONTH), 
        	    today.get(Calendar.DAY_OF_MONTH), 
        	   
        	    new OnDateChangedListener(){
        	     @Override
        	     public void onDateChanged(DatePicker view, 
        	       int year, int monthOfYear,int dayOfMonth) {
//        	      Toast.makeText(getApplicationContext(), 
//        	        "onDateChanged", Toast.LENGTH_SHORT).show();
        	      
        	   // -- get difference in days
                  Calendar thatDay = Calendar.getInstance();
                  thatDay.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                  thatDay.set(Calendar.MONTH,monthOfYear); // 0-11 so 1 less
                  thatDay.set(Calendar.YEAR, year);

                  Calendar today = Calendar.getInstance();

                  long diff = today.getTimeInMillis() - thatDay.getTimeInMillis(); //result in millis
                  long days = diff / (24 * 60 * 60 * 1000);
                  Output.setText(String.valueOf(days));
                  
//        	      Output.setText(
//        	        "Year: " + year + "\n" +
//        	        "Month of Year: " + monthOfYear+1 + "\n" +
//        	        "Day of Month: " + dayOfMonth);
        	      
        	     }});
        
        
	}

    
    
	@Override
	protected Dialog onCreateDialog(int id) {
	        switch (id) {
	        case DATE_PICKER_ID:
	             
	            // open datepicker dialog. 
	            // set date picker for current date 
	            // add pickerListener listner to date picker
	            return new DatePickerDialog(this, pickerListener, year, month,day);
	        }
	        return null;
	}	
	
    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {
    	 
        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                int selectedMonth, int selectedDay) {
             
            year  = selectedYear;
            month = selectedMonth;
            day   = selectedDay;
 
            // Show selected date 
            changeDate.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));
            
            // -- get difference in days
            Calendar thatDay = Calendar.getInstance();
            thatDay.set(Calendar.DAY_OF_MONTH,day);
            thatDay.set(Calendar.MONTH,month); // 0-11 so 1 less
            thatDay.set(Calendar.YEAR, year);

            Calendar today = Calendar.getInstance();

            long diff = today.getTimeInMillis() - thatDay.getTimeInMillis(); //result in millis
            long days = diff / (24 * 60 * 60 * 1000);
            Output.setText(String.valueOf(days));
           }
    };
	

	// -- start google skymap
	public void onClick_start_googleskymap (View v)
	{	
		Intent i = new Intent(Intent.ACTION_SEARCH);
		i.setPackage("com.google.android.stardroid");
		i.putExtra(SearchManager.QUERY, "vega");
		
		
		// Verify it resolves
		PackageManager packageManager = getPackageManager();
		List<ResolveInfo> activities = packageManager.queryIntentActivities(i, 0);
		boolean isIntentSafe = activities.size() > 0;

		// Start an activity if it's safe
		if (isIntentSafe) {
			startActivity(i);
		}
		else {
//			Toast.makeText(this, "warning", Toast.LENGTH_LONG).show();
			
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("market://search?q=sky map&c=apps"));			
			startActivity(intent);
		}
	}
	
	// -- start stellar info page
	public void onClick_start_stellarinfo (View v)
	{
		Intent intent = new Intent(this, StellarInfo.class);
		startActivity(intent);
		
	}
	
	// -- start stellar info page
	public void onClick_share_stellarinfo (View v)
	{
		
		/* Get a File for the selected file name. Assume that the file names are in the mImageFilename array */
//        File requestFile = new File(mImageFilename[position]);
        File requestFile = new File("vega1.jpg"); 
//        File filePath = getFileStreamPath("vega1.jpg");
        /* Most file-related method calls need to be in try-catch blocks */
        // Use the FileProvider to get a content URI
        Uri uri = Uri.parse("android.resource://com.example.stellarbirthday/drawable/vega1.jpg");
        try {
            fileUri = FileProvider.getUriForFile(MainActivity.this,
                    "com.example.stellarbirthday.fileprovider",  requestFile);
        } catch (IllegalArgumentException e) {
            Log.e("File Selector", "The selected file can't be shared: ");
        }
//        Toast.makeText(this, fileUri, Toast.LENGTH_LONG).show();
        
        //		// Verify the original intent will resolve to at least one activity
//		if (sendIntent.resolveActivity(getPackageManager()) != null) {
//		    startActivity(chooser);
//		}
		
//		Intent sendIntent = new Intent();
//		sendIntent.setAction(Intent.ACTION_SEND);
//		File filePath = getFileStreamPath("vega1.jpg");
//		Uri uriToImage = Uri.fromFile(filePath);
		
		Intent shareIntent = new Intent();
		shareIntent.setAction(Intent.ACTION_SEND);
		shareIntent.putExtra(Intent.EXTRA_TEXT, "My next #Stellar #Birthdays is VEGA");
//		shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(filePath)); 
		shareIntent.putExtra(Intent.EXTRA_STREAM, fileUri); 
//		shareIntent.putExtra(Intent.EXTRA_STREAM, uri); 
//		shareIntent.setType("image/jpeg");
		// Grant temporary read permission to the content URI
//		if (fileUri != null) {
            // Grant temporary read permission to the content URI
			shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//        }
		
		shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		shareIntent.setType("image/*");
		startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.chooser_title)));
		
//		sendIntent.putExtra(Intent.EXTRA_TEXT, "My next #Stellar #Birthdays is VEGA");
//		sendIntent.setType("text/plain");
//		startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.chooser_title)));
	}

		
}
