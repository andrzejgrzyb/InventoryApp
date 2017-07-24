package pl.com.andrzejgrzyb.inventoryapp;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Andrzej on 24.07.2017.
 */

public class ProductCursorAdapter extends CursorAdapter {

    private final MainActivity activity;

    public ProductCursorAdapter(MainActivity mainActivity, Cursor cursor) {
        super(mainActivity, cursor, 0);
        this.activity = mainActivity;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.listview_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        TextView nameTextView = (TextView) view.findViewById(R.id.name_textview);
        TextView quantityTextView = (TextView) view.findViewById(R.id.quantity_textview);
        TextView priceTextView = (TextView) view.findViewById(R.id.price_textview);
        Button buyButton = (Button) view.findViewById(R.id.buy_button);
        ImageView image = (ImageView) view.findViewById(R.id.image_view);

        String name = cursor.getString(cursor.getColumnIndex(ProductContract.COLUMN_NAME));
        final int quantity = cursor.getInt(cursor.getColumnIndex(ProductContract.COLUMN_QUANTITY));
        String price = cursor.getString(cursor.getColumnIndex(ProductContract.COLUMN_PRICE));

        image.setImageURI(Uri.parse(cursor.getString(cursor.getColumnIndex(ProductContract.COLUMN_IMAGE))));

        nameTextView.setText(name);
        quantityTextView.setText(String.valueOf(quantity));
        priceTextView.setText(activity.getResources().getString(R.string.price_formatter, price));

        final long id = cursor.getLong(cursor.getColumnIndex(ProductContract._ID));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.clickOnViewItem(id);
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.buyButtonClick(id, quantity);
            }
        });
    }
}
