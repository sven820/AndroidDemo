package com.example.androiddemo.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androiddemo.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class ListViewActivityDemo extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);

        listView = findViewById(R.id.listView);
        showFamousListView();
    }

    void showStringDatas() {
        String[] data = {"test","hello","test","hello","test","hello","test","hello","test","hello","test","hello",};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, data);
        listView.setAdapter(adapter);
    }

    void showFamousListView() {

        FamousPerson p = new FamousPerson();
        p.name = "test";
        p.age = 99;

        ArrayList<FamousPerson> famousPeople = new ArrayList<>();
        famousPeople.add(p);
        famousPeople.add(p);
        FamousPersonAdapter adapter = new FamousPersonAdapter(this,
                R.layout.famous_person_item, famousPeople);
        listView.setAdapter(adapter);
    }
}

class FamousPersonAdapter extends ArrayAdapter<FamousPerson> {

    int resourceId;
    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public FamousPersonAdapter(@NonNull Context context, int resource,
                               @NonNull List<FamousPerson> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        FamousPerson p = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView imgView = view.findViewById(R.id.head_icon);
        imgView.setImageResource(R.mipmap.jxf_test);
        TextView tView = view.findViewById(R.id.name);
        tView.setText(p.name);
        return  view;
    }
}
