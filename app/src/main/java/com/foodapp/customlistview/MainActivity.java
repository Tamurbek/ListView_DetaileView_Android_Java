package com.foodapp.customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.foodapp.customlistview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList=new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int[] imageList={
                R.drawable.f1,
                R.drawable.f2,
                R.drawable.f3,
                R.drawable.f4,
                R.drawable.f5,
                R.drawable.f6,
                R.drawable.f7
        };
        int[] ingredientList={
                R.string.pastaIngredients,
                R.string.maggiIngredients,
                R.string.cakeIngredients,
                R.string.pancakeIngredients,
                R.string.burgerIngredients,
                R.string.friesIngredients,
                R.string.pizzaIngredients,
        };
        int[] descList={
                R.string.pastaDesc,
                R.string.maggieDesc,
                R.string.cakeDesc,
                R.string.pancakeDesc,
                R.string.burgerDesc,
                R.string.friesDesc,
                R.string.pizzaDesc,
        };

        String[] nameList={
                "Pasta",
                "Maggi",
                "Cake",
                "Pancake",
                "Pizza",
                "Burgers",
                "Fries"
        };
        String[] timeList={
                "30 mins",
                "2 mins",
                "45 mins",
                "10 mins",
                "60 mins",
                "45 mins",
                "30 mins"
        };

        for (int i=0;i<imageList.length;i++){
            listData=new ListData(nameList[i],timeList[i],ingredientList[i],descList[i],imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter=new ListAdapter(MainActivity.this,dataArrayList);
        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this, DetailedActivity.class);
                intent.putExtra("name",nameList[i]);
                intent.putExtra("time",timeList[i]);
                intent.putExtra("ingredients",ingredientList[i]);
                intent.putExtra("image",imageList[i]);
                intent.putExtra("desc",descList[i]);
//                Toast.makeText(
//                        getApplicationContext(),
//                        nameList[i]+" "+timeList[i]+" "+ingredientList[i]+" "+imageList[i]+" "+descList[i],
//                        Toast.LENGTH_SHORT
//                ).show();
                startActivity(intent);
            }
        });
    }
}