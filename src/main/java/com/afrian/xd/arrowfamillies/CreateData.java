package com.afrian.xd.arrowfamillies;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateData extends Activity implements OnClickListener {

    //inisilisasi elemen-elemen pada layout
    private Button buttonSubmit;
    private EditText edNama;
    private EditText edMerk;
    private EditText edHarga;
    //inisialisasi kontroller/Data Source
    private DBDataSource dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_data);

        buttonSubmit = (Button) findViewById(R.id.buttom_submit);
        buttonSubmit.setOnClickListener(this);
        edNama = (EditText) findViewById(R.id.nama_barang);
        edHarga = (EditText) findViewById(R.id.harga_barang);
        edMerk = (EditText) findViewById(R.id.merk_barang);

        // instanstiasi kelas DBDataSource
        dataSource = new DBDataSource(this);

        //membuat sambungan baru ke database
        dataSource.open();
    }

    //KETIKA Tombol Submit Diklik

    @Override
    public void onClick(View v) {
        // Inisialisasi data barang
        String GoodGuysActivity = null;

        @SuppressWarnings("unused")

        //inisialisasi barang baru (masih kosong)
                GoodGuysActivity goodGuysActivity = null;
        if(edNama.getText()!=null && edMerk.getText()!=null && edHarga.getText()!=null)
        {
            /* jika field nama, merk, dan harga tidak kosong
             * maka masukkan ke dalam data barang*/
            GoodGuysActivity = edNama.getText().toString();

        }

        switch(v.getId())
        {
            case R.id.buttom_submit:
                // insert data barang baru
                goodGuysActivity = dataSource.createGoodGuysActivity(Amanda);

                //konfirmasi kesuksesan
                Toast.makeText(this, "masuk GoodGuysActivity\n" +
                        "nama" + ((GoodGuysActivity) goodGuysActivity).getAmanda()
                        , Toast.LENGTH_LONG).show();
                break;
        }

    }
}






