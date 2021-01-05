/*
 * Copyright (c) 2017,  Michael W. Whalen
 * All Rights Reserved.
 * 
 * Permission has been explicitly granted to the University of Minnesota 
 * Software Engineering Center to use and distribute this source for 
 * educational purposes, including delivering online education through
 * Coursera or other entities.  
 * 
 * No warranty is given regarding this software, including warranties as
 * to the correctness or completeness of this software, including 
 * fitness for purpose.
 */
package edu.ncsu.csc326.coffeemaker;

public interface RecipeBook {
	
	
	/**
	 * Returns the recipe array.
	 * @param r
	 * @return Recipe[]
	 */
	public Recipe[] getRecipes();
	
	public boolean addRecipe(Recipe r);
	
	/**
	 * Returns the name of the recipe deleted at the position specified
	 * and null if the recipe does not exist.
	 * @param recipeToDelete
	 * @return String
	 */
	public String deleteRecipe(int recipeToDelete); 	
	
	/**
	 * Returns the name of the recipe edited at the position specified
	 * and null if the recipe does not exist.
	 * @param recipeToEdit
	 * @param newRecipe
	 * @return String
	 */
	public String editRecipe(int recipeToEdit, Recipe newRecipe);

}
