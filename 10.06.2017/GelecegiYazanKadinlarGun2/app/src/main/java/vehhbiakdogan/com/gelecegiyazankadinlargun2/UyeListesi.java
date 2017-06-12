package vehhbiakdogan.com.gelecegiyazankadinlargun2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UyeListesi extends AppCompatActivity {
    ListView uyeListesi;
    List<Uye> uyeler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_listesi);
        uyeListesi = (ListView) findViewById(R.id.uyeList);

        uyeler = new ArrayList<>();
        uyeler.add(new Uye("Vehbi Akdoğan", "ERZURUM", "http://fb.me/vehbii25", "http://twitter.com/vehbiakdogan", R.mipmap.ic_launcher));
        uyeler.add(new Uye("Deneme2", "ERZURUM", "http://fb.me/vehbii25", "http://twitter.com/vehbiakdogan", R.mipmap.ic_launcher));
        uyeler.add(new Uye("Deneme3", "TRABZON", "http://fb.me/vehbii25", "http://twitter.com/vehbiakdogan", R.mipmap.ic_launcher));
        uyeler.add(new Uye("Deneme4", "ERZURUM", "http://fb.me/vehbii25", "http://twitter.com/vehbiakdogan", R.mipmap.ic_launcher));


        ListAdapter adapter = new ListAdapter(this, uyeler);
        uyeListesi.setAdapter(adapter);

        uyeListesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Log.e("TiklananEleman:",uyeler.get(i).getAdSoyad());
                Intent intent = new Intent(UyeListesi.this, ProfileWebview.class);
                intent.putExtra("adres", uyeler.get(i).getFacebookUrl());
                startActivity(intent);
            }
        });
        uyeListesi.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(UyeListesi.this, ProfileWebview.class);
                intent.putExtra("adres", uyeler.get(i).getTwitterUrl());
                startActivity(intent);

                return false;
            }
        });


    }
}
