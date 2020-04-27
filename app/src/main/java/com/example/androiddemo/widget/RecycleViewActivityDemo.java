package com.example.androiddemo.widget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androiddemo.R;

import java.util.ArrayList;

public class RecycleViewActivityDemo extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<FamousPerson> famousPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_demo);

        recyclerView = findViewById(R.id.recycleView);

        famousPeople = new ArrayList<FamousPerson>();
        FamousPerson p = new FamousPerson();
        p.name = "test";
        p.age = 99;

        famousPeople.add(p);
        famousPeople.add(p);
        famousPeople.add(p);
        famousPeople.add(p);
        famousPeople.add(p);
        FamousRecycleAdapter adapter = new FamousRecycleAdapter(famousPeople);
        recyclerView.setAdapter(adapter);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(RecyclerView.HORIZONTAL);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

    }

    class FamousRecycleAdapter extends RecyclerView.Adapter<FamousRecycleAdapter.FamousRecycleViewHolder> {

        ArrayList<FamousPerson> list;

        FamousRecycleAdapter(ArrayList<FamousPerson> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public FamousRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view =
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.famous_person_item,
                            parent,false);
            final FamousRecycleViewHolder famousRecycleViewHolder = new FamousRecycleViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = famousRecycleViewHolder.getAdapterPosition();
                    FamousPerson p = list.get(position);
                    Toast.makeText(v.getContext(),p.name, Toast.LENGTH_LONG).show();
                }
            });
            return famousRecycleViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull FamousRecycleViewHolder holder, int position) {
            FamousPerson p = list.get(position);
            holder.imgView.setImageResource(R.mipmap.jxf_test);
            holder.nameView.setText(p.name);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class FamousRecycleViewHolder extends RecyclerView.ViewHolder {

            ImageView imgView;
            TextView nameView;

            public FamousRecycleViewHolder(@NonNull View itemView) {
                super(itemView);

                this.imgView = itemView.findViewById(R.id.head_icon);
                this.nameView = itemView.findViewById(R.id.name);
            }
        }
    }
}


