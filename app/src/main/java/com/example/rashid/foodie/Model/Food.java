package com.example.rashid.foodie.Model;

import com.example.rashid.foodie.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rashid on 3/31/17.
 */

public class Food {

    private static final String[] name={"Bar-B-Que","Dosa Pancake","Italian Pasta","Pain Pasta","Pizza",
                                        "Samdwich","Spaghetti","Sushi","Tandoori Grill","Vegetable frenzi"};
    private static final int[] price={130,80,150,100,450,90,190,300,220,145};
    private static final int[] imageid={R.drawable.barbeque,R.drawable.dosas_pancakes,R.drawable.italian_pasta,
                                        R.drawable.pain_pasta,R.drawable.pizza,R.drawable.sandwich,R.drawable.spaghetti_bolognese,
                                        R.drawable.sushi,R.drawable.tandoori_grill,R.drawable.vegetable_jalfrezi};

    public static List<Listitem> getItem(){

        List<Listitem> data=new ArrayList<>();
        for (int i=0;i<name.length && i<price.length && i<imageid.length;i++)
        {
            Listitem listitem=new Listitem();
            listitem.setImageid(imageid[i]);
            listitem.setName(name[i]);
            listitem.setPrice(price[i]);
            data.add(listitem);
        }

        return data;
    }
}
