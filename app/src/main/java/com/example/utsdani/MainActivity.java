package com.example.utsdani;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public MainActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);


        final CheckBox menu1 = (CheckBox)this.findViewById(R.id.c1);
        final CheckBox menu2 = (CheckBox)this.findViewById(R.id.c2);
        final CheckBox menu3 = (CheckBox)this.findViewById(R.id.c3);
        final CheckBox menu4 = (CheckBox)this.findViewById(R.id.c4);
        final CheckBox menu5 = (CheckBox)this.findViewById(R.id.c5);
        final CheckBox menu6 = (CheckBox)this.findViewById(R.id.c6);
        final EditText jml_menu1 = (EditText)this.findViewById(R.id.jml1);
        final EditText jml_menu2 = (EditText)this.findViewById(R.id.jml2);
        final EditText jml_menu3 = (EditText)this.findViewById(R.id.jml3);
        final EditText jml_menu4 = (EditText)this.findViewById(R.id.jml4);
        final EditText jml_menu5 = (EditText)this.findViewById(R.id.jml5);
        final EditText jml_menu6 = (EditText)this.findViewById(R.id.jml6);
        final Button btn = (Button)this.findViewById(R.id.btn_psn);


        int harga_menu1 = 35000;
        int harga_menu2 = 30000;
        int harga_menu3 = 25000;
        int harga_menu4 = 10000;
        int harga_menu5 = 18000;
        int harga_menu6 = 15000;

        btn.setOnClickListener((v) -> {
            EditText konsumen = (EditText)this.findViewById(R.id.name);
            String nama = konsumen.getText().toString();
            if (!menu1.isChecked() && !menu2.isChecked() && !menu3.isChecked() && !menu4.isChecked() && !menu5.isChecked() && !menu6.isChecked()) {
                Toast.makeText(this.getApplicationContext(), "Pilih Makanan dan Minuman Yang Akan di pesan", Toast.LENGTH_SHORT).show();
            } else {
                String sub = "";
                int totalorder = 0;
                int pajak = 0;
                String hasil;
                int jml;
                int cal;
                if (menu1.isChecked()) {
                    hasil = "Honey Garlic Chicken Rice ";
                    jml = Integer.parseInt(String.valueOf(jml_menu1.getText()));
                    cal = jml * harga_menu1;
                    sub = sub + jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\tRp. " + cal + "\n\n";
                    totalorder += cal;
                }

                if (menu2.isChecked()) {
                    hasil = "Beef Burger ";
                    jml = Integer.parseInt(String.valueOf(jml_menu2.getText()));
                    cal = jml * harga_menu2;
                    sub = sub + jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\tRp. " + cal + "\n\n";
                    totalorder += cal;
                }

                if (menu3.isChecked()) {
                    hasil = " Reguler Fries ";
                    jml = Integer.parseInt(String.valueOf(jml_menu3.getText()));
                    cal = jml * harga_menu3;
                    sub = sub + jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\tRp. " + cal + "\n\n";
                    totalorder += cal;
                }

                if (menu4.isChecked()) {
                    hasil = "Ice Cream Cone ";
                    jml = Integer.parseInt(String.valueOf(jml_menu4.getText()));
                    cal = jml * harga_menu4;
                    sub = sub + jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\tRp. " + cal + "\n\n";
                    totalorder += cal;
                }

                if (menu5.isChecked()) {
                    hasil = "Flurry Oreo ";
                    jml = Integer.parseInt(String.valueOf(jml_menu5.getText()));
                    cal = jml * harga_menu5;
                    sub = sub + jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\tRp. " + cal + "\n\n";
                    totalorder += cal;
                }

                if (menu6.isChecked()) {
                    hasil = " Fanta Float ";
                    jml = Integer.parseInt(String.valueOf(jml_menu6.getText()));
                    cal = jml * harga_menu6;
                    sub = sub + jml + "\t\t" + hasil + "\t\t\t\t\t\t\t\t\tRp. " + cal + "\n\n";
                    totalorder += cal;
                }

                if (totalorder > 0) {
                    pajak = (int)((double)totalorder * 0.01D);
                }

                Intent intent = new Intent(this, pesanancetak.class);
                intent.putExtra("nama", nama);
                intent.putExtra("subtotal", sub);
                intent.putExtra("pembayaran", totalorder);
                intent.putExtra("Pajak", pajak);
                this.startActivity(intent);
            }

        });
    }
}