package trabzonegitim.vehhbiakdogan.com.gelecegiyazanlartrabzon;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Hosgeldin extends AppCompatActivity {
    String kullaniciAdi;
    TextView tvHosgeldin;
    ListView liste;
     AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosgeldin);
        tvHosgeldin = (TextView) findViewById(R.id.tvMesaj);
        liste = (ListView) findViewById(R.id.liste);
        final String ulkeler[] = new String[]{
                "Türkiye",
                "İran",
                "Deneme",
                "aaa"
        };

        // alertdialog ilklendirildi
        dialog = new AlertDialog.Builder(Hosgeldin.this);
        // alert dialog kapat butonu oluşturuldu
        dialog.setNegativeButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });




        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_expandable_list_item_1,
                        android.R.id.text1,
                        ulkeler);
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("key",ulkeler[i]);
                dialog.setTitle("Geleceği yazanlar");
                dialog.setMessage("Seçilen item: "+ulkeler[i]);
                dialog.show();
            }
        });



        kullaniciAdi = getIntent() // intenti ele aldık
                .getExtras() // intentle gelen verilere ulaştıık
                .getString("kullaniciAdi"); // gönderilen string veriyi aldık.

        tvHosgeldin.setText(tvHosgeldin.getText() + ": " + kullaniciAdi);
    }
}
