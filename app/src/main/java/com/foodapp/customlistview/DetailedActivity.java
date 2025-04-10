package com.foodapp.customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.foodapp.customlistview.databinding.ActivityDetailedBinding;
import com.foodapp.customlistview.databinding.ActivityMainBinding;

import java.util.Objects;

public class DetailedActivity extends AppCompatActivity {

    ActivityDetailedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=this.getIntent();
        if (intent!=null){
            String name=intent.getStringExtra("name");
            String time=intent.getStringExtra("time");
            int ingredients= intent.getIntExtra("ingredients", R.string.maggiIngredients);
            int desc= intent.getIntExtra("desc", R.string.maggieDesc);
            int image= intent.getIntExtra("image", R.drawable.f1);

            Toast.makeText(
                    getApplicationContext(),
                    name+" "+time+" "+ingredients+" "+desc+" "+image,
                    Toast.LENGTH_SHORT
            ).show();

            binding.detailName.setText(name);
            binding.detailTime.setText(time);
            binding.detailDesc.setText(desc);
            binding.detailDesc.setText(desc);
            binding.detailIngredients.setText(ingredients);
            binding.detailImage.setImageResource(image);
        }
    }
}