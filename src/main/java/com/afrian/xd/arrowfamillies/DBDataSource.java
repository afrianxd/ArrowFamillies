package com.afrian.xd.arrowfamillies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DBDataSource {

    //inisialiasi SQLite Database
    private SQLiteDatabase database;

    //inisialisasi kelas DBHelper
    private DBHelper dbHelper;

    //ambil semua nama kolom
    private String[] allColumns = { DBHelper.COLUMN_ID,
            DBHelper.COLUMN_AMANDA};

    //DBHelper diinstantiasi pada constructor
    public DBDataSource(Context context)
    {
        dbHelper = new DBHelper(context);
    }

    //membuka/membuat sambungan baru ke database
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    //menutup sambungan ke database
    public void close() {
        dbHelper.close();
    }

    //method untuk create/insert barang ke database
    public GoodGuysActivity createGoodGuysActivity(String Amanda) {

        // membuat sebuah ContentValues, yang berfungsi
        // untuk memasangkan data dengan nama-nama
        // kolom pada database
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_AMANDA, Amanda);


        // mengeksekusi perintah SQL insert data
        // yang akan mengembalikan sebuah insert ID
        long insertId = database.insert(DBHelper.TABLE_NAME, null,
                values);

        // setelah data dimasukkan, memanggil
        // perintah SQL Select menggunakan Cursor untuk
        // melihat apakah data tadi benar2 sudah masuk
        // dengan menyesuaikan ID = insertID
        Cursor cursor = database.query(DBHelper.TABLE_NAME,
                allColumns, DBHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);

        // pindah ke data paling pertama
        cursor.moveToFirst();

        // mengubah objek pada kursor pertama tadi
        // ke dalam objek barang
        GoodGuysActivity newGoodGuysActivity = cursorToGoodGuysActivity(cursor);

        // close cursor
        cursor.close();

        // mengembalikan barang baru
        return newGoodGuysActivity;
    }

    private GoodGuysActivity cursorToGoodGuysActivity(Cursor cursor)
    {
        // buat objek barang baru
        GoodGuysActivity goodGuysActivity = new GoodGuysActivity();
        // debug LOGCAT
        Log.v("info", "The getLONG "+cursor.getLong(0));
        Log.v("info", "The setLatLng "+cursor.getString(1)+","+cursor.getString(2));

        /* Set atribut pada objek barang dengan
         * data kursor yang diambil dari database*/
        goodGuysActivity.setId(cursor.getLong(0));
        goodGuysActivity.setAmanda(cursor.getString(1));


        //kembalikan sebagai objek barang
        return goodGuysActivity;
    }

    //mengambil semua data barang
    public ArrayList<GoodGuysActivity> getGoodGuysActivity() {
        ArrayList<GoodGuysActivity> daftarBarang = new ArrayList<GoodGuysActivity>();

        // select all SQL query
        Cursor cursor = database.query(DBHelper.TABLE_NAME,
                allColumns, null, null, null, null, null);

        // pindah ke data paling pertama
        cursor.moveToFirst();
        // jika masih ada data, masukkan data barang ke
        // daftar barang
        while (!cursor.isAfterLast()) {
            GoodGuysActivity goodGuysActivity = cursorToGoodGuysActivity(cursor);
            daftarBarang.add(goodGuysActivity);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        return daftarBarang;
    }
}
