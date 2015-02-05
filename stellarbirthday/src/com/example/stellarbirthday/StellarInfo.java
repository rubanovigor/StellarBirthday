package com.example.stellarbirthday;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

public class StellarInfo extends Activity{
	private WebView webView;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		setContentView(R.layout.stellar_info);
		setContentView(R.layout.stellar_info_webview);
//		
////		ImageView mIV = (ImageView)findViewById(R.id.star) ; 
////		Drawable new_image= getResources().getDrawable(R.drawable.vega1);   
////		mIV.setImageDrawable(new_image);
//		
		// -- WebView implementation
		webView = (WebView) findViewById(R.id.webview);
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setDisplayZoomControls(true);
//        webView.getSettings().setJavaScriptEnabled(true);
        
//        webView.loadUrl("http://images.ipac.caltech.edu/stsci/stsci-prc-2008-16-bu/stsci_stsci-prc-2008-16-bu_3614.jpg");
//        webView.loadUrl("<link rel='stylesheet' href='http://aladin.u-strasbg.fr/AladinLite/api/v2/latest/aladin.min.css' /><script type='text/javascript' src='http://code.jquery.com/jquery-1.9.1.min.js' charset='utf-8'></script><div id='aladin-lite-div' style='width: 600;height: 400px;'></div><script type='text/javascript' src='http://aladin.u-strasbg.fr/AladinLite/api/v2/latest/aladin.min.js' charset='utf-8'></script>");

//        WebView w = new WebView(this);
//        // Load the asset file by URL. Note the 3 slashes "file:///".
        webView.loadUrl("file:///android_asset/sirius.html");
        
//        //        String customHtml = "<html><body><h2>Greetings from JavaCodeGeeks</h2></body></html>";
//
//        //        webView.loadData(customHtml, "text/html", "UTF-8");

	}
	
}
