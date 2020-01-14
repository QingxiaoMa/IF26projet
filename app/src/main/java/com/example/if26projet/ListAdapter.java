package com.example.if26projet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    public ArrayList<Plat> products;
    private Context context;

    public ListAdapter(Context context,ArrayList<Plat> listPlats) {
        this.context = context;
        this.products = listPlats;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Plat getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView
            , ViewGroup parent) {
        View row;
        final ListViewHolder listViewHolder;
        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.list_item,parent,false);
            listViewHolder = new ListViewHolder();
            listViewHolder.tvProductName = row.findViewById(R.id.tvProductName);
            listViewHolder.ivProduct = row.findViewById(R.id.ivProduct);
            listViewHolder.tvPrice = row.findViewById(R.id.tvPrice);
            listViewHolder.btnPlus = row.findViewById(R.id.ib_addnew);
            listViewHolder.edTextQuantity = row.findViewById(R.id.editTextQuantity);
            listViewHolder.btnMinus = row.findViewById(R.id.ib_remove);
            row.setTag(listViewHolder);
        }
        else
        {
            row=convertView;
            listViewHolder= (ListViewHolder) row.getTag();
        }
        final Plat plat = getItem(position);

        listViewHolder.tvProductName.setText(plat.getNom());
        listViewHolder.ivProduct.setImageResource(plat.ProductImage);
        listViewHolder.tvPrice.setText(plat.getPrix()+" $");
        listViewHolder.edTextQuantity.setText(plat.CartQuantity+"");
        listViewHolder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                updateQuantity(position,listViewHolder.edTextQuantity,1);
            }
        });
        //listViewHolder.edTextQuantity.setText("0");
        listViewHolder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuantity(position,listViewHolder.edTextQuantity,-1);

            }
        });

        return row;
    }

    private void updateQuantity(int position, EditText edTextQuantity, int value) {

        Plat products = getItem(position);
        if(value > 0)
        {
            products.CartQuantity = products.CartQuantity + 1;
        }
        else
        {
            if(products.CartQuantity > 0)
            {
                products.CartQuantity = products.CartQuantity - 1;
            }

        }
        edTextQuantity.setText(products.CartQuantity+"");
    }
}