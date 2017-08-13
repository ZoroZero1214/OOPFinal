package com.example.user.oop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
int jumlahSeblak=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public String tampilHasilAkhir(){
        CheckBox sambal = (CheckBox)findViewById(R.id.cbSambel);
        CheckBox makaroni = (CheckBox)findViewById(R.id.cbMakaroni);
        CheckBox kerupuk = (CheckBox)findViewById(R.id.cbKerupuk);
        boolean checkSambal = sambal.isChecked();
        boolean checkmakaroni = makaroni.isChecked();
        boolean checkkerupuk = kerupuk.isChecked();
        int hargaAkhir = hitungHarga(checkSambal,checkmakaroni,checkkerupuk);
        String toping=toping(checkSambal,checkmakaroni,checkkerupuk);
        String pesanAkhir = "Jumlah pesanan : " + jumlahSeblak;
        pesanAkhir += "\nToping = " + toping;
        pesanAkhir += "\nNama = " + kasihNama();
        pesanAkhir += "\nHarga = " + hargaAkhir;
        pesanAkhir += "\nTerimakasih sudah membeli";
        return pesanAkhir;

    }
    public void order(View v){
        TextView txtHasilAkhir = (TextView)findViewById(R.id.txtHasil);
        txtHasilAkhir.setText(tampilHasilAkhir());
    }
    public void tambah(View v){
        TextView txtJumlahSeblak = (TextView)findViewById(R.id.txtJmlh);
        jumlahSeblak = jumlahSeblak + 1;
        txtJumlahSeblak.setText("" + jumlahSeblak);
    }
    public void kurang(View v){
        TextView txtJumlahSeblak = (TextView)findViewById(R.id.txtJmlh);
        jumlahSeblak = jumlahSeblak - 1;
        txtJumlahSeblak.setText("" + jumlahSeblak);
    }
    public int hitungHarga(boolean sambal,boolean makaroni,boolean kerupuk){
        int hargaAwal=5000;
        if (sambal){
            hargaAwal = hargaAwal + 500;
        }
        if (makaroni){
            hargaAwal = hargaAwal + 1000;
        }
        if (kerupuk){
            hargaAwal = hargaAwal + 1000;
        }
        return jumlahSeblak * hargaAwal;
    }
    private String kasihNama(){
        EditText edNama= (EditText)findViewById(R.id.edNama);
        String namaPembeli= edNama.getText().toString();
        return namaPembeli;
    }
    public String toping (boolean sambal,boolean makaroni,boolean kerupuk){
        String topingnya = "";
        if (sambal){
            topingnya = "Sambal";
        }
        if (makaroni){
            topingnya = topingnya + ",Makaroni";
        }
        if (kerupuk){
            topingnya = topingnya + ",Kerupuk";
        }
        return topingnya;
    }
    public void decrement(View v){
        if (jumlahSeblak == 1){
            Toast.makeText(this,"Tidak Bisa Memesan Kurang Dari Satu", Toast.LENGTH_SHORT).show();
            return;
        }
        jumlahSeblak = jumlahSeblak - 1;
        displayQuantity(jumlahSeblak);
    }

    private void displayQuantity(int jumlahSeblak) {
    }
}
