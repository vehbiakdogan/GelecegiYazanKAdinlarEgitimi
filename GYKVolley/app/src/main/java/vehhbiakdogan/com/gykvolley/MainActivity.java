package vehhbiakdogan.com.gykvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Mesaj> mesajlar;
    RequestQueue queue;
    final String URL = "http://vehbiakdogan.com/mesajlar.php";
    MesajAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);

        sorguOlustur();


        listView = (ListView) findViewById(R.id.listview);
        mesajlar = new ArrayList<>();
        adapter = new MesajAdapter(this, mesajlar);
        listView.setAdapter(adapter);
    }

    private void sorguOlustur() {
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            jsonParseEt(response);
                        } catch (JSONException e) {
                            Log.e("JSONPARSE", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEYHATA", error.toString());
            }
        }
        );
        queue.add(stringRequest);
    }

    // json parse edici method
    public void jsonParseEt(String response) throws JSONException {
        // throws bir hata oluştuğunda hata fırlatır.
        JSONObject data = new JSONObject(response);
        JSONArray jsonMesajlar = data.getJSONArray("mesajlar");
        JSONObject mesaj;
        for (int i = 0; i < jsonMesajlar.length(); i++) {
            mesaj = jsonMesajlar.getJSONObject(i);
            mesajlar.add(new Mesaj(
                    mesaj.getInt("gonderenId"),
                    mesaj.getInt("durum"),
                    mesaj.getString("adSoyad"),
                    mesaj.getString("mesaj"),
                    mesaj.getString("resimUrl"))
            );
        }
        adapter.notifyDataSetChanged();
    }
}
