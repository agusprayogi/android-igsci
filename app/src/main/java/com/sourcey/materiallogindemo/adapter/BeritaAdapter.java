package com.sourcey.materiallogindemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sourcey.materiallogindemo.R;
import com.sourcey.materiallogindemo.model.Berita;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder> {
    @BindView(R.id.img_berita)
    TextView Img_Berita;
    @BindView(R.id.txt_isi_berita) TextView Isi_Berita;
    @BindView(R.id.txt_tgl_berita) TextView Tgl_Berita;
    @BindView(R.id.txt_tag_berita) TextView Tag_Berita;



    public class BeritaViewHolder extends RecyclerView.ViewHolder{

        public BeritaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public void bind (final Berita item){
        Isi_Berita.setText(item.getIsiBerita());


    }


}
