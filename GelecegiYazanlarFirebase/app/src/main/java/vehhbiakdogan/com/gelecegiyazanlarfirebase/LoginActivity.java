package vehhbiakdogan.com.gelecegiyazanlarfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends BaseActivitiy
 implements  View.OnClickListener{

    TextInputEditText edPosta, edSifre;
    Button girisBtn, kaydolBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        try {
            ilklendir();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void ilklendir() throws InterruptedException {
        edPosta = (TextInputEditText) findViewById(R.id.posta);
        edSifre = (TextInputEditText) findViewById(R.id.sifre);
        girisBtn = (Button) findViewById(R.id.girisBtn);
        kaydolBtn = (Button) findViewById(R.id.kaydolBtn);

        girisBtn.setOnClickListener(this);
        kaydolBtn.setOnClickListener(this);

        Thread.sleep(1000);
        if (AppController.getInstance().girisYapilmisMi)
            startActivity(new Intent(LoginActivity.this,Profileactivity.class));
    }


    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.girisBtn:
                girisYap(edPosta.getText().toString(),edSifre.getText().toString());
                break;
            case R.id.kaydolBtn:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private  void girisYap(String posta, String sifre) {
        mAuth.signInWithEmailAndPassword(posta, sifre)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            AppController.getInstance().girisYapilmisMi = true;
                            Toast.makeText(getApplicationContext(),
                                    "Giriş Başarılı.",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(LoginActivity.this,Profileactivity.class));

                        }else {
                            Toast.makeText(getApplicationContext(),
                                    "Giriş Başarısız.",Toast.LENGTH_LONG).show();

                        }
                    }
                });


    }
}
