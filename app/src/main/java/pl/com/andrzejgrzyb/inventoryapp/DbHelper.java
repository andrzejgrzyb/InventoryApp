package pl.com.andrzejgrzyb.inventoryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andrzej on 24.07.2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    public final static String DB_NAME = "inventoryapp.db";
    public final static int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ProductContract.CREATE_TABLE_STOCK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertItem(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ProductContract.COLUMN_NAME, product.getName());
        values.put(ProductContract.COLUMN_PRICE, product.getPrice());
        values.put(ProductContract.COLUMN_QUANTITY, product.getQuantity());
        values.put(ProductContract.COLUMN_SUPPLIER_NAME, product.getSupplierName());
        values.put(ProductContract.COLUMN_SUPPLIER_PHONE, product.getSupplierPhone());
        values.put(ProductContract.COLUMN_SUPPLIER_EMAIL, product.getSupplierEmail());
        values.put(ProductContract.COLUMN_IMAGE, product.getImage());
        long id = db.insert(ProductContract.TABLE_NAME, null, values);
    }

    public Cursor getAllItems() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                ProductContract.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }

    public Cursor getItem(long itemId) {
        SQLiteDatabase db = getReadableDatabase();
        String selection = ProductContract._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(itemId) };

        Cursor cursor = db.query(
                ProductContract.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        return cursor;
    }

    public void updateItem(long currentItemId, int quantity) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ProductContract.COLUMN_QUANTITY, quantity);
        String selection = ProductContract._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(currentItemId) };
        db.update(ProductContract.TABLE_NAME,
                values, selection, selectionArgs);
    }

    public void sellItem(long itemId, int quantity) {
        SQLiteDatabase db = getWritableDatabase();
        int newQuantity = 0;
        if (quantity > 0) {
            newQuantity = quantity - 1;
        }
        ContentValues values = new ContentValues();
        values.put(ProductContract.COLUMN_QUANTITY, newQuantity);
        String selection = ProductContract._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(itemId) };
        db.update(ProductContract.TABLE_NAME,
                values, selection, selectionArgs);
    }
}