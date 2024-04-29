package com.example.webview;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        WebView webView = findViewById(R.id.webview);
        // Enable JavaScript (optional)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Set a WebViewClient to handle page navigation
        webView.setWebViewClient(new WebViewClient());
        // Load a webpage
        webView.loadUrl("https://www.youtube.com/");
    }
}