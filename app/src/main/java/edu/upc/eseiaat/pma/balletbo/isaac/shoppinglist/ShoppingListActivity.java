package edu.upc.eseiaat.pma.balletbo.isaac.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShoppingListActivity extends AppCompatActivity {

    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;

    private ListView list;
    private Button btn_add;
    private EditText edit_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        list = (ListView) findViewById(R.id.list);
        btn_add = (Button) findViewById(R.id.btn_add);
        edit_item = (EditText) findViewById(R.id.edit_item);

        //Creem una llista d'Array
        itemList = new ArrayList<>();
        itemList.add("Patatas");
        itemList.add("Papel WC");
        itemList.add("Zanahorias");
        itemList.add("Copas Danone");

        //Creem l'adaptador del ArrayList
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);
        //Funcio al clickar al btn_add
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });

        edit_item.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                addItem();
                return true;
            }
        });


        list.setAdapter(adapter);
    }

    private void addItem() {
        //Agafem el text de la caixeta
        String item_text = edit_item.getText().toString();
        //Si el text no esta en blanc
        if(!item_text.isEmpty()) {
            //Afegim a la llista el text agafat
            itemList.add(item_text);
            adapter.notifyDataSetChanged();
            edit_item.setText("");
        }
    }
}
