package com.v0lture.deAngelo.mymu.bugs_folder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.v0lture.deAngelo.mymu.R;

public class Bugs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bugs);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView myWebview = (WebView) findViewById(R.id.bugsWeb);
        myWebview.loadUrl("https://bugs.v0lture.com/");
        myWebview.setWebViewClient(new MyWebViewClient());
        WebSettings webSettings = myWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    private class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            if (Uri.parse(url).getHost().equals("https://bugs.v0lture.com/")){
                return false;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
