package com.example.project;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Webactivity extends AppCompatActivity {

    WebView webView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webactivity);
        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.kindmeal.my/recipes.htm?gclid=CjwKCAjwhOD0BRAQEiwAK7JHmBgtLVNsmGEEuyyqk68P5E-3GjoK8mQ-Xj6VnUOXQhdOREHks3YwqhoCUWwQAvD_BwE");
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }



}
