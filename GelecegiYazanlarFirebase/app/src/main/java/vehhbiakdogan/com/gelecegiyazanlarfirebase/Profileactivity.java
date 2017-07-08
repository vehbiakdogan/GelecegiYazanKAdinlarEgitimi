package vehhbiakdogan.com.gelecegiyazanlarfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profileactivity extends BaseActivitiy {
    TextView tvName,tvPosta;
    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("mesajlar");
        myRef.setValue("Hello, World!");


        tvName = (TextView) findViewById(R.id.name);
        tvPosta = (TextView) findViewById(R.id.posta);
        tvName.setText(AppController.getInstance().mUser.getUid());
        tvPosta.setText(AppController.getInstance().mUser.getEmail());
    }
}
