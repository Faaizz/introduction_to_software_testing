/*
 * Copyright (c) 2009,  Sarah Heckman, Laurie Williams, Dright Ho
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
 * 
 * 
 * Modifications 
 * 20171114 - Ian De Silva - Updated to comply with JUnit 4 and to adhere to 
 * 							 coding standards.  Added test documentation.
 */
package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

/**
 * Unit tests for CoffeeMaker class.
 * 
 * @author Sarah Heckman
 */
public class CoffeeMakerTest {
	
	/**
	 * The object under test.
	 */
	private CoffeeMaker coffeeMaker;
	
	// Sample recipes to use in testing.
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;
	private Recipe recipe5;
	private Recipe recipe6;
	private Recipe recipe7;

	/**
	 * Initializes some recipes to test with and the {@link CoffeeMaker} 
	 * object we wish to test.
	 * 
	 * @throws RecipeException  if there was an error parsing the ingredient 
	 * 		amount when setting up the recipe.
	 */
	@Before
	public void setUp() throws RecipeException {
		coffeeMaker = new CoffeeMaker();
		
		//Set up for r1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for r3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for r4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");

		//Set up for r5
		recipe5 = new Recipe();
		recipe5.setName("Custom");
		recipe5.setAmtChocolate("4");
		recipe5.setAmtCoffee("0");
		recipe5.setAmtMilk("1");
		recipe5.setAmtSugar("30");
		recipe5.setPrice("65");

		//Set up for r6
		recipe6 = new Recipe();
		recipe6.setName("Custom");
		recipe6.setAmtChocolate("4");
		recipe6.setAmtCoffee("0");
		recipe6.setAmtMilk("30");
		recipe6.setAmtSugar("1");
		recipe6.setPrice("65");

		//Set up for r7
		recipe7 = new Recipe();
		recipe7.setName("Custom");
		recipe7.setAmtChocolate("4");
		recipe7.setAmtCoffee("30");
		recipe7.setAmtMilk("0");
		recipe7.setAmtSugar("1");
		recipe7.setPrice("65");
	}
	

	/** UC5: ADD INVENTORY */
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with well-formed quantities
	 * Then we do not get an exception trying to read the inventory quantities.
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test
	public void testAddInventory() throws InventoryException {
		coffeeMaker.addInventory("4","7","0","9");
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantity for amtCoffee
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionCoffee() throws InventoryException {
		coffeeMaker.addInventory("-4", "1", "2", "3");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantity for amtCoffee
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionCoffeeAlp() throws InventoryException {
		coffeeMaker.addInventory("ll", "1", "2", "3");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantity for amtMilk
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionMilk() throws InventoryException {
		coffeeMaker.addInventory("4", "-1", "2", "3");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantity for amtMilk
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionMilkAlp() throws InventoryException {
		coffeeMaker.addInventory("4", "pop", "2", "3");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantity for amtSugar
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionSugar() throws InventoryException {
		coffeeMaker.addInventory("4", "1", "-2", "3");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantity for amtSugar
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionSugarAlp() throws InventoryException {
		coffeeMaker.addInventory("4", "1", "lp", "3");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantity for amtChocolate
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionChocolate() throws InventoryException {
		coffeeMaker.addInventory("4", "1", "2", "-3");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantity for amtChocolate
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionChocolateAlp() throws InventoryException {
		coffeeMaker.addInventory("4", "1", "2", "aa");
	}


	/** UC6: CHECK INVENTORY */
	/**
	 * Given a coffee maker
	 * When we check inventory
	 * Then we get a string representation of the default inventory
	 */
	@Test
	public void testCheckInventory() {
		
		StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(15);
    	buf.append("\n");
		
		
		assertEquals(buf.toString(), coffeeMaker.checkInventory());
	}

	/**
	 * Given a coffee maker
	 * When we check inventory after adding some Milk (5)
	 * Then we get a string representation of the new inventory
	 */
	@Test
	public void testCheckInventoryMilk() throws InventoryException {
		
		coffeeMaker.addInventory("0", "5", "0", "0");

		StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append(15+5);
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(15);
    	buf.append("\n");
		
		
		assertEquals(buf.toString(), coffeeMaker.checkInventory());
	}

	/**
	 * Given a coffee maker
	 * When we check inventory after adding some Sugar (5)
	 * Then we get a string representation of the new inventory
	 */
	@Test
	public void testCheckInventorySugar() throws InventoryException {
		
		coffeeMaker.addInventory("0", "0", "5", "0");

		StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append(15+5);
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(15);
    	buf.append("\n");
		
		
		assertEquals(buf.toString(), coffeeMaker.checkInventory());
	}

	/**
	 * Given a coffee maker
	 * When we check inventory after adding some Chocolate (5)
	 * Then we get a string representation of the new inventory
	 */
	@Test
	public void testCheckInventoryChoco() throws InventoryException {
		
		coffeeMaker.addInventory("0", "0", "0", "5");

		StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(15+5);
    	buf.append("\n");
		
		
		assertEquals(buf.toString(), coffeeMaker.checkInventory());
	}

	/**
	 * Given a coffee maker
	 * When we check inventory after adding some Coffee (5)
	 * Then we get a string representation of the new inventory
	 */
	@Test
	public void testCheckInventoryCoffee() throws InventoryException {
		
		coffeeMaker.addInventory("5", "0", "0", "0");

		StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append(15+5);
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(15);
    	buf.append("\n");
		
		
		assertEquals(buf.toString(), coffeeMaker.checkInventory());
	}




	/** UC7: PURCHASE BEVERAGE */
	
	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying more than 
	 * 		the coffee costs
	 * Then we get the correct change back.
	 */
	@Test
	public void testMakeCoffee() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals(25, coffeeMaker.makeCoffee(0, 75));
	}

	/**
	 * Given a coffee maker with 3 valid recipes
	 * When we make coffee, selecting the 3rd recipe and paying more than 
	 * 		the coffee costs
	 * Then we get the correct change back.
	 */
	@Test
	public void testMakeCoffeeMultipleTrue() {
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		coffeeMaker.addRecipe(recipe3);
		assertEquals(75, coffeeMaker.makeCoffee(2, 175));
	}

	/**
	 * Given a coffee maker with 3 valid recipes
	 * When we make coffee, selecting the 2nd recipe and paying less than 
	 * 		the coffee costs
	 * Then we get the amount paid back.
	 */
	@Test
	public void testMakeCoffeeMultipleFalse() {
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe4);
		coffeeMaker.addRecipe(recipe3);
		assertEquals(5, coffeeMaker.makeCoffee(1, 5));
	}

	/**
	 * Given a coffee maker with 3 valid recipes
	 * When we make coffee, selecting the 1st recipe and paying the exact 
	 * 		amount the coffee costs
	 * Then we get the nothing back.
	 */
	@Test
	public void testMakeCoffeeMultiple() {
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		coffeeMaker.addRecipe(recipe3);
		assertEquals(0, coffeeMaker.makeCoffee(0, 50));
	}


	/**
	 * Given a coffee maker with 3 valid recipes
	 * When we make coffee, selecting the 2nd recipe which requires (20,3,1,1)
	 * 		with the default inventory (15, 15, 15, 15)
	 * Then we get the money back.
	 */
	@Test
	public void testMakeCoffeeInventoryFalse() {
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		coffeeMaker.addRecipe(recipe3);
		assertEquals(100, coffeeMaker.makeCoffee(1, 100));
	}

	/**
	 * Given a coffee maker with 3 valid recipes
	 * When we make coffee, selecting the valid recipe which requires (4,0,30,1)
	 * 		with the default inventory (15, 15, 15, 15)
	 * Then we get the money back.
	 */
	@Test
	public void testMakeCoffeeInventoryFalse6() {
		coffeeMaker.addRecipe(recipe6);
		assertEquals(100, coffeeMaker.makeCoffee(0, 100));
	}

	/**
	 * Given a coffee maker with 3 valid recipes
	 * When we make coffee, selecting the valid recipe which requires (4,30,0,1)
	 * 		with the default inventory (15, 15, 15, 15)
	 * Then we get the money back.
	 */
	@Test
	public void testMakeCoffeeInventoryFalse7() {
		coffeeMaker.addRecipe(recipe7);
		assertEquals(100, coffeeMaker.makeCoffee(0, 100));
	}

	/**
	 * Given a coffee maker with 3 valid recipes
	 * When we make coffee, selecting the valid recipe which requires (4,0,1,30)
	 * 		with the default inventory (15, 15, 15, 15)
	 * Then we get the money back.
	 */
	@Test
	public void testMakeCoffeeInventoryFalse2() {
		coffeeMaker.addRecipe(recipe5);
		assertEquals(100, coffeeMaker.makeCoffee(0, 100));
	}

	/**
	 * Given a coffee maker with 3 valid recipes
	 * When we make coffee, selecting the 2nd recipe which requires (20,3,1,1)
	 * 		with the extra chocolate (20) added to the default 
	 * 		inventory to yield (35, 15, 15, 15)
	 * Then we get the money back.
	 */
	@Test
	public void testMakeCoffeeInventoryTrue() throws InventoryException {
		coffeeMaker.addInventory("0", "0", "0", "20");
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		coffeeMaker.addRecipe(recipe3);
		assertEquals(25, coffeeMaker.makeCoffee(1, 100));
	}

	/**
	 * Given a coffee maker with no valid recipes
	 * When we try to make coffee
	 * Then we get the money back.
	 */
	@Test
	public void testMakeCoffeeInventoryFalse3() {
		assertEquals(100, coffeeMaker.makeCoffee(0, 100));
	}

	/**
	 * Given a coffee maker with 3 valid recipes
	 * When we make coffee, if we specify a negative recipe index
	 * Then we get the money back.
	 */
	@Test
	public void testMakeCoffeeInventoryFalse4() {
		coffeeMaker.addRecipe(recipe5);
		assertEquals(100, coffeeMaker.makeCoffee(-1, 100));
	}

	/**
	 * Given a coffee maker with 3 valid recipes
	 * When we make coffee, if we specify an invalid recipe index
	 * Then we get the money back.
	 */
	@Test
	public void testMakeCoffeeInventoryFalse5() {
		coffeeMaker.addRecipe(recipe5);
		assertEquals(100, coffeeMaker.makeCoffee(10, 100));
	}



	/** UC2: ADD RECIPE */

	/**
	 * Given a coffee maker with no recipes
	 * When we add a valid recipe
	 * Then we get a coffee maker with one recipe.
	 */
	@Test
	public void testMakeCoffeeAddRecipe1() {
		coffeeMaker.addRecipe(recipe1);
		assertNotEquals(null, coffeeMaker.getRecipes()[0]);
	}

	/**
	 * Given a coffee maker with no recipes
	 * When we add 3 valid recipes
	 * Then we get a coffee maker with 3 recipes.
	 */
	@Test
	public void testMakeCoffeeAddRecipe2() {
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		coffeeMaker.addRecipe(recipe3);
		assertNotEquals(null, coffeeMaker.getRecipes()[0]);
		assertNotEquals(null, coffeeMaker.getRecipes()[1]);
		assertNotEquals(null, coffeeMaker.getRecipes()[2]);
	}

	/**
	 * Given a coffee maker with no recipes
	 * When we add a recipe with the same name as an existing one
	 * Then we get a false response.
	 */
	@Test
	public void testMakeCoffeeAddRecipe3() {
		coffeeMaker.addRecipe(recipe3);
		Recipe recipe= new Recipe();
		recipe.setName(recipe3.getName());
		assertEquals(false, coffeeMaker.addRecipe(recipe));
	}


	/** UC3: DELETE RECIPE */

	/**
	 * Given a coffee maker with no recipes
	 * When we add a valid recipe and then delete the recipe
	 * Then we get a coffee maker with no recipes.
	 */
	@Test
	public void testMakeCoffeeDeleteRecipe1() {
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.deleteRecipe(0);
		assertEquals(null, coffeeMaker.getRecipes()[0]);
	}

	/**
	 * Given a coffee maker with no recipes
	 * When we delete a recipe
	 * Then we get a null response.
	 */
	@Test
	public void testMakeCoffeeDeleteRecipe2() {
		assertEquals(null, coffeeMaker.deleteRecipe(0));
	}

	/**
	 * Given a coffee maker with no recipes
	 * When we delete a recipe with an invalid index
	 * Then we get a null response.
	 */
	@Test
	public void testMakeCoffeeDeleteRecipe3() {
		assertEquals(null, coffeeMaker.deleteRecipe(-1));
	}


	/** UC4: EDIT RECIPE */

	/**
	 * Given a coffee maker with no recipes
	 * When we add a valid recipe and then edit the recipe
	 * Then we get a coffee maker with a recipe corresponding to the new data.
	 */
	@Test
	public void testMakeCoffeeEditRecipe1() {
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.editRecipe(0, recipe2);
		assertEquals(recipe2.getPrice(), coffeeMaker.getRecipes()[0].getPrice());
	}

	/**
	 * Given a coffee maker with no recipes
	 * When we edit a recipe
	 * Then we get a null response.
	 */
	@Test
	public void testMakeCoffeeEditRecipe2() {
		assertEquals(null, coffeeMaker.editRecipe(0, recipe2));
	}

	/**
	 * Given a coffee maker with no recipes
	 * When we edit a recipe with an invalid index
	 * Then we get a null response.
	 */
	@Test
	public void testMakeCoffeeEditRecipe3() {
		assertEquals(null, coffeeMaker.editRecipe(-1, recipe2));
	}

	
	/** OTHER CLASSES */
	/**
	 * When we create a recipe with an invalid price
	 * Then we get a RecipeException.
	 */
	@Test(expected = RecipeException.class)
	public void testCreateRecipe1() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setPrice("-50");
	}

	/**
	 * When we create a recipe with an invalid entry
	 * Then we get a RecipeException.
	 */
	@Test(expected = RecipeException.class)
	public void testCreateRecipe2() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("-1");
		recipe.setPrice("50");
	}

	/**
	 * When we create a recipe with an invalid entry
	 * Then we get a RecipeException.
	 */
	@Test(expected = RecipeException.class)
	public void testCreateRecipe3() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("-1");
		recipe.setAmtSugar("1");
		recipe.setPrice("50");
	}

	/**
	 * When we create a recipe with an invalid entry
	 * Then we get a RecipeException.
	 */
	@Test(expected = RecipeException.class)
	public void testCreateRecipe4() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("-3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setPrice("50");
	}

	/**
	 * When we create a recipe with an invalid entry
	 * Then we get a RecipeException.
	 */
	@Test(expected = RecipeException.class)
	public void testCreateRecipe5() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("-10");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setPrice("50");
	}

	/**
	 * When we create a recipe with an invalid entry
	 * Then we get a RecipeException.
	 */
	@Test(expected = RecipeException.class)
	public void testCreateRecipe6() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setPrice("abc");
	}

	/**
	 * When we create a recipe with an invalid entry
	 * Then we get a RecipeException.
	 */
	@Test(expected = RecipeException.class)
	public void testCreateRecipe7() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("aa");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setPrice("50");
	}

	/**
	 * When we create a recipe with an invalid entry
	 * Then we get a RecipeException.
	 */
	@Test(expected = RecipeException.class)
	public void testCreateRecipe8() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("bb");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setPrice("50");
	}

	/**
	 * When we create a recipe with an invalid entry
	 * Then we get a RecipeException.
	 */
	@Test(expected = RecipeException.class)
	public void testCreateRecipe9() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("bb");
		recipe.setAmtSugar("1");
		recipe.setPrice("50");
	}

	/**
	 * When we create a recipe with an invalid entry
	 * Then we get a RecipeException.
	 */
	@Test(expected = RecipeException.class)
	public void testCreateRecipe10() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("bb");
		recipe.setPrice("50");
	}

	/**
	 * When we compare 2 recipes with the same name
	 * Then we get an true response.
	 */
	@Test
	public void testCreateRecipe11() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");

		assertEquals(true, recipe1.equals(recipe));
	}

	/**
	 * When we compare 2 recipes with different names
	 * Then we get an false response.
	 */
	@Test
	public void testCreateRecipe12() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Mocha");

		assertEquals(false, recipe1.equals(recipe));
	}
	

	/**
	 * When we compare 2 recipes with different names
	 * Then we get an false response.
	 */
	@Test
	public void testCreateRecipe13() throws RecipeException {
		Recipe recipe = new Recipe();

		assertEquals(false, recipe1.equals(recipe));
	}

	/**
	 * When we compare 2 recipes with different names
	 * Then we get an false response.
	 */
	@Test
	public void testCreateRecipe14() throws RecipeException {
		Recipe recipe = new Recipe();

		assertEquals(false, recipe.equals(recipe1));
	}

	/**
	 * When we check a recipe's name
	 * Then we get back the assigned name.
	 */
	@Test
	public void testCreateRecipe15() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Mocha");

		assertEquals("Mocha", recipe.toString());
	}

}
