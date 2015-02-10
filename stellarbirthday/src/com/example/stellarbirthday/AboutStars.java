package com.example.stellarbirthday;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;

public class AboutStars extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.about_stars);
		
		View backgroundImage = findViewById(R.id.background);
		Drawable background = backgroundImage.getBackground();
//		background.setAlpha(80);
		
		// -- get BirthdayStar name based on Birthday Date from Facebook
			// add logic here
//			BirthdayStar = "sirius";
		// -- end

		
		// -- WebView implementation
//		webView = (WebView) findViewById(R.id.webview);
	}
	
}
