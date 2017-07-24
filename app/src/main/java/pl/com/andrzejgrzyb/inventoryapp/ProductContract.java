package pl.com.andrzejgrzyb.inventoryapp;

import android.provider.BaseColumns;

/**
 * Created by Andrzej on 24.07.2017.
 */

public class ProductContract implements BaseColumns {

    public static final String TABLE_NAME = "products";

    public static final String _ID = BaseColumns._ID;
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_SUPPLIER_NAME = "supplier_name";
    public static final String COLUMN_SUPPLIER_PHONE = "supplier_phone";
    public static final String COLUMN_SUPPLIER_EMAIL = "supplier_email";
    public static final String COLUMN_IMAGE = "image";

    public static final String CREATE_TABLE_STOCK = "CREATE TABLE " +
            TABLE_NAME + "(" +
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_NAME + " TEXT NOT NULL," +
            COLUMN_PRICE + " TEXT NOT NULL," +
            COLUMN_QUANTITY + " INTEGER NOT NULL," +
            COLUMN_SUPPLIER_NAME + " TEXT NOT NULL," +
            COLUMN_SUPPLIER_PHONE + " TEXT NOT NULL," +
            COLUMN_SUPPLIER_EMAIL + " TEXT NOT NULL," +
            COLUMN_IMAGE + " TEXT NOT NULL" + ");";

}
