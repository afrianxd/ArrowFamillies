package com.afrian.xd.arrowfamillies;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class GoodGuysActivity extends AppCompatActivity {

    private long id;

    private TextView Amanda;

    public GoodGuysActivity()
    {

    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the Amanda
     */
    public String getAmanda() {
        return Amanda;
    }

    /**
     * @param Amanda the nama_barang to set
     */
    public void setAmanda(String Amanda) {
        this.Amanda = Amanda;
    }

    /**
     * @return the merk_barang
     */

    @Override
    public String toString()
    {
        return "GoodGuysActivity"+ Amanda;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_guys);

        Amanda = (TextView)findViewById(R.id.txtAmanda)
    }
}

public class GoodGuysActivity extends Activity implements View.OnClickListener {

    private Button bTambah;
    private Button bAmanda;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_guys);

        bTambah = (Button) findViewById(R.id.button_tambah);
        bTambah.setOnClickListener(this);
        bAmanda = (Button) findViewById(R.id.txtAmanda);
        bAmanda.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId())
        {
            case R.id.button_tambah :
                Intent i = new Intent(this, CreateData.class);
                startActivity(i);
                break;
            case R.id.txtAmanda :
                Intent i2 = new Intent(this, Amanda.class);
                startActivity(i2);
                break;

        }
    }
}

public class Amanda extends ListActivity {

    //inisialisasi kontroller
    private DBDataSource dataSource;

    //inisialisasi arraylist
    private ArrayList<GoodGuysActivity> values;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_guys);

        dataSource = new DBDataSource(this);
        // buka kontroller
        dataSource.open();

        // ambil semua data GoodGuysActivity
        values = dataSource.getAllGoodGuysActivity();

        // masukkan data barang ke array adapter
        ArrayAdapter<GoodGuysActivity> adapter = new ArrayAdapter<GoodGuysActivity>(this,
                android.R.layout.simple_list_item_1, values);

        // set adapter pada list
        setListAdapter(adapter);
    }
}


