package vehhbiakdogan.com.gelecegiyazankadinlargun2;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class ProfileWebview extends AppCompatActivity {
    WebView webView;
    TextView internetMesaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_webview);
        webView = (WebView) findViewById(R.id.webview);
        internetMesaj = (TextView) findViewById(R.id.internetMesaj);

        if (intrnetVarMi(getApplicationContext())) {
            // internet var ise bilgilendirme mesajını kaldır.
            // webviewi aç
            internetMesaj.setVisibility(View.GONE);
            webView.setVisibility(View.VISIBLE);

            webView.loadUrl(getIntent().getStringExtra("adres"));
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                }
            });
        } else {
            internetMesaj.setVisibility(View.VISIBLE);
            webView.setVisibility(View.GONE);
        }


    }

    private boolean intrnetVarMi(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
