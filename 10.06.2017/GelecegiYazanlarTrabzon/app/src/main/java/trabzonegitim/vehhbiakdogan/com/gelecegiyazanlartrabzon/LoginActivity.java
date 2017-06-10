package trabzonegitim.vehhbiakdogan.com.gelecegiyazanlartrabzon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText edKullaniciAdi, edSifre;
    Button girisBtn;
    String kullaniciAdi, sifre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edKullaniciAdi = (EditText) findViewById(R.id.edKullaniciAdi);
        edSifre = (EditText) findViewById(R.id.edSifre);
        girisBtn = (Button) findViewById(R.id.girisBtn);

        girisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kullaniciAdi = edKullaniciAdi.getText().toString();
                sifre = edSifre.getText().toString();
               if(kullaniciAdi.equals("") || sifre.equals("")) {
                   Log.e("bilgiLogu","Kullanıcı Adı Veya Şifre Boş ");
               }else {
                   Intent i = new Intent(LoginActivity.this,Hosgeldin.class);
                   i.putExtra("kullaniciAdi", kullaniciAdi);
                   startActivity(i);
               }


                // log almak
                // Log.e("kulullaniciadi",kullaniciAdi);
                // Log.e("sifre",sifre);
            }
        });


    }
}
