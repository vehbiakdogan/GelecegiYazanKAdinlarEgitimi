package vehhbiakdogan.com.gelecegiyazanlarfirebase;

import android.app.Application;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by vehbiakdogan on 8.07.2017.
 */

public class AppController extends Application {

    private  static  AppController mInstance;
    public  boolean girisYapilmisMi = false;
    public FirebaseUser mUser = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public static  synchronized AppController getInstance() {
        return mInstance;
    }
}
