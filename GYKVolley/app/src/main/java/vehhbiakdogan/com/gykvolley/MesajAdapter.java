package vehhbiakdogan.com.gykvolley;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by vehbiakdogan on 18.06.2017.
 */

public class MesajAdapter extends BaseAdapter {

    private  List<Mesaj> mesajlar;
    private LayoutInflater layoutInflater;

    public MesajAdapter(Activity a, List<Mesaj> mesajlar) {
        this.mesajlar = mesajlar;
        layoutInflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mesajlar.size();
    }

    @Override
    public Object getItem(int i) {
        return mesajlar.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View satirView;
        satirView = layoutInflater.inflate(R.layout.liste_row,null);

        TextView tvAdSoyad = (TextView) satirView.findViewById(R.id.tvAdSoyad);
        TextView tvMesaj = (TextView) satirView.findViewById(R.id.tvMesaj);
        TextView tvMesajDurum = (TextView) satirView.findViewById(R.id.tvmesajDurum);
        ImageView imMesajImg = (ImageView) satirView.findViewById(R.id.imMesajImg);

        tvAdSoyad.setText(mesajlar.get(i).getAdSoyad());
        tvMesaj.setText(mesajlar.get(i).getMesaj());

        if(!mesajlar.get(i).getResimUrl().equals("")) {
            imMesajImg.setVisibility(View.VISIBLE);
            Glide.with(satirView).
                    load(mesajlar.get(i).getResimUrl()).
                    into(imMesajImg);
        }else {
            imMesajImg.setVisibility(View.GONE);
        }


        if(mesajlar.get(i).getDurum() == 1) {
            tvMesajDurum.setText("Okundu.");
        }else {
            tvMesajDurum.setText("");
        }
        if (mesajlar.get(i).getGonderenId() == 1) {
            satirView.setBackgroundResource(R.color.colorPrimary);
        }else {
            satirView.setBackgroundResource(R.color.sari);
        }



        return satirView;
    }
}
