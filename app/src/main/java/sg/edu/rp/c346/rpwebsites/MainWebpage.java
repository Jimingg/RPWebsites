package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainWebpage extends AppCompatActivity {
    WebView wvpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_webpage);
        wvpage=findViewById(R.id.WebViewPage);
        wvpage.setWebViewClient(new WebViewClient());

        Intent intentReceived =getIntent();

        String URL = intentReceived.getStringExtra("URL");
        Log.i("URL",URL+"");
        wvpage.loadUrl(URL);

        wvpage.getSettings().setJavaScriptEnabled(true);
        wvpage.getSettings().setBuiltInZoomControls(true);

    }
}
