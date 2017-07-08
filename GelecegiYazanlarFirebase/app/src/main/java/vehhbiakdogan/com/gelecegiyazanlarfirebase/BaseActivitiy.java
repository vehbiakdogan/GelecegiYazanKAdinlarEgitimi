package vehhbiakdogan.com.gelecegiyazanlarfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BaseActivitiy extends AppCompatActivity {
    public FirebaseAuth mAuth = null;
    public FirebaseAuth.AuthStateListener mAuthListener = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                Log.e("TAG","Kontrol Sistemi Çalışıyor");
                if (user != null) {
                    AppController.getInstance().girisYapilmisMi = true;
                    AppController.getInstance().mUser = user;
                    // User is signed in
                } else {
                    AppController.getInstance().girisYapilmisMi = false;

                }
                // ...
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(mAuthListener);

    }
}
