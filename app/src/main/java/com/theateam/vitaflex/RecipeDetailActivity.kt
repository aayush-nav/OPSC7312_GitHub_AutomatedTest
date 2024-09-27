package com.theateam.vitaflex

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.theateam.vitaflex.databinding.ActivityRecipeDetailBinding

class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeDetailBinding

    private lateinit var ingredientAdapter: IngredientsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // setContentView(R.layout.activity_recipe_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Get the recipe from intent
        val recipe = intent.getSerializableExtra("recipe") as Recipe

        // Set recipe details
        binding.recipeNameTextView.text = recipe.name


        binding.totalCaloriesTextView.text = "Total Calories: ${recipe.totalCalories}"

        // Set up ingredients RecyclerView
        ingredientAdapter = IngredientsAdapter(recipe.ingredients)
        binding.ingredientsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.ingredientsRecyclerView.adapter = ingredientAdapter

        binding.recipeDetailsBackButton.setOnClickListener() {
            finish()
        }

    }
}