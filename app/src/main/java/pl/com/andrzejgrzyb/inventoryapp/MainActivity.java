package pl.com.andrzejgrzyb.inventoryapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private final static String LOG_TAG = MainActivity.class.getCanonicalName();
    DbHelper dbHelper;
    ProductCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);
        final ListView listView = (ListView) findViewById(R.id.list_view);
        View emptyView = findViewById(R.id.empty_list_textview);
        listView.setEmptyView(emptyView);

        Cursor cursor = dbHelper.getAllItems();

        adapter = new ProductCursorAdapter(this, cursor);
        listView.setAdapter(adapter);

        Button addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.swapCursor(dbHelper.getAllItems());
    }

    public void clickOnViewItem(long id) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemId", id);
        startActivity(intent);
    }

    public void buyButtonClick(long id, int quantity) {
        dbHelper.sellItem(id, quantity);
        adapter.swapCursor(dbHelper.getAllItems());
    }
}
