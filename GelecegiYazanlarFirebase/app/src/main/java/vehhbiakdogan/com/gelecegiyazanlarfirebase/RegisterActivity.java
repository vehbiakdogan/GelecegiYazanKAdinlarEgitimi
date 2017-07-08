package vehhbiakdogan.com.gelecegiyazanlarfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class RegisterActivity extends BaseActivitiy implements View.OnClickListener {

    TextInputEditText edPosta, edSifre;
    Button girisBtn, kaydolBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ilklendir();
    }

    private void ilklendir() {
        edPosta = (TextInputEditText) findViewById(R.id.posta);
        edSifre = (TextInputEditText) findViewById(R.id.sifre);
        girisBtn = (Button) findViewById(R.id.girisBtn);
        kaydolBtn = (Button) findViewById(R.id.kaydolBtn);

        girisBtn.setOnClickListener(this);
        kaydolBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.girisBtn:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                break;
            case R.id.kaydolBtn:
                kayitOl(edPosta.getText().toString(), edSifre.getText().toString());
                break;
        }
    }

    private void kayitOl(String posta, String sifre) {
        mAuth.createUserWithEmailAndPassword(posta, sifre)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Kayıt Başarılı", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Kayıt Başarısız", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
