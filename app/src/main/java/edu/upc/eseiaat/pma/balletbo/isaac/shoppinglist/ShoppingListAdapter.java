package edu.upc.eseiaat.pma.balletbo.isaac.shoppinglist;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Usuario on 23/10/2017.
 */

public class ShoppingListAdapter extends ArrayAdapter {
    public ShoppingListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
    }
}
