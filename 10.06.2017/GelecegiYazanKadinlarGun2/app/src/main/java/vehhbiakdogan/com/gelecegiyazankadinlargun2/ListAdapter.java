package vehhbiakdogan.com.gelecegiyazankadinlargun2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vehbiakdogan on 11.06.2017.
 */

public class ListAdapter extends BaseAdapter {

    List <Uye> uyeler;
    LayoutInflater layoutInflater;

    public ListAdapter(Activity activity, List<Uye> uyeler) {
        this.uyeler = uyeler;
        layoutInflater =
                (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return uyeler.size();
    }

    @Override
    public Object getItem(int i) {
        return uyeler.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // listede kaç adet eleman varsa o kadar çağırılır.
        // ve listenin her bir satırı burada oluşturulur.
        View satirView;
        ImageView profilImg;
        TextView listAdSoyad, listSehir, listFb;
        satirView = layoutInflater.inflate(R.layout.liste_row,null);
        profilImg = (ImageView) satirView.findViewById(R.id.profilImg);
        listAdSoyad = (TextView) satirView.findViewById(R.id.listAdSoyad);
        listSehir = (TextView) satirView.findViewById(R.id.listSehir);
        listFb = (TextView) satirView.findViewById(R.id.listFb);

        profilImg.setImageResource(uyeler.get(i).getResimUrl());
        listAdSoyad.setText(uyeler.get(i).getAdSoyad());
        listSehir.setText(uyeler.get(i).getSehir());
        listFb.setText(listFb.getText()+" "+uyeler.get(i).getFacebookUrl());



        return satirView;
    }
}
