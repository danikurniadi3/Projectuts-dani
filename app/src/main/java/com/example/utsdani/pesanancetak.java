package com.example.utsdani;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class pesanancetak extends AppCompatActivity {
    public pesanancetak() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_pesanancetak);
        TextView namakonsumen = (TextView)this.findViewById(R.id.nama_konsumen);
        TextView tanggal = (TextView)this.findViewById(R.id.tanggal);
        TextView text = (TextView)this.findViewById(R.id.hasil);
        TextView Total = (TextView)this.findViewById(R.id.total);
        TextView paj = (TextView)this.findViewById(R.id.pajak);
        TextView bel = (TextView)this.findViewById(R.id.jml_total);
        Intent intent = this.getIntent();
        String sum = intent.getStringExtra("subtotal");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.US);
        String currentDate = dateFormat.format(new Date());
        tanggal.setText("Tanggal : " + currentDate);
        tanggal.setEnabled(false);
        String nama = intent.getStringExtra("nama");
        int subtotal = intent.getIntExtra("pembayaran", 0);
        int pajak = intent.getIntExtra("Pajak", 0);
        int total = subtotal + pajak;
        namakonsumen.setText("Nama Konsumen : " + nama);
        text.setText(sum);
        Total.setText("Rp. " + subtotal);
        paj.setText("RP. " + pajak);
        bel.setText("Rp. " + total);
    }

    public void cetakkembalian(View v) {
        EditText Tunai = (EditText)this.findViewById(R.id.tunai);
        TextView kembali = (TextView)this.findViewById(R.id.kembalian);
        Intent intent = this.getIntent();
        int subtotal = intent.getIntExtra("pembayaran", 0);
        int pajak = intent.getIntExtra("Pajak", 0);
        int total = subtotal + pajak;
        int tunai = Integer.parseInt(String.valueOf(Tunai.getText()));
        int hitungkembalian = tunai - total;
        kembali.setText("Kembalian : Rp. " + hitungkembalian);
        if (total > tunai) {
            kembali.setText("Kembalian : Tunai Harus lebih besar dari Total Order ");
        }

    }
}
