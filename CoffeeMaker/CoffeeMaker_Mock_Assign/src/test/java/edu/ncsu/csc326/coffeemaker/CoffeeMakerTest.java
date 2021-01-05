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
 * Modifications
 * 20171113 - Michael W. Whalen - Extended with additional recipe.
 * 20171114 - Ian J. De Silva   - Updated to JUnit 4; fixed variable names.
 */
package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;



/**
 * Unit tests for CoffeeMaker class.
 * 
 * @author Sarah Heckman
 *
 * Extended by Mike Whalen
 */

public class CoffeeMakerTest {
	
	//-----------------------------------------------------------------------
	//	DATA MEMBERS
	//-----------------------------------------------------------------------
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;
	private Recipe recipe5;
	private Recipe recipe6;
	
	private Recipe [] stubRecipies; 
	
	/**
	 * The coffee maker -- our object under test.
	 */
	private CoffeeMaker coffeeMaker;
	
	/**
	 * The stubbed recipe book.
	 */
	private RecipeBook recipeBookStub;
	
	
	//-----------------------------------------------------------------------
	//	Set-up / Tear-down
	//-----------------------------------------------------------------------
	/**
	 * Initializes some recipes to test with, creates the {@link CoffeeMaker} 
	 * object we wish to test, and stubs the {@link RecipeBook}. 
	 * 
	 * @throws RecipeException  if there was an error parsing the ingredient 
	 * 		amount when setting up the recipe.
	 */
	@Before
	public void setUp() throws RecipeException {
		
		recipeBookStub = mock(RecipeBook.class);
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		
		//Set up for recipe1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for recipe2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for recipe3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for recipe4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");
		
		//Set up for recipe5 (added by MWW)
		recipe5 = new Recipe();
		recipe5.setName("Super Hot Chocolate");
		recipe5.setAmtChocolate("6");
		recipe5.setAmtCoffee("60");
		recipe5.setAmtMilk("1");
		recipe5.setAmtSugar("1");
		recipe5.setPrice("100");

		//Set up for recipe6 (added by MWW)
		recipe6 = new Recipe();
		recipe6.setName("Super Hot Chocolate");
		recipe6.setAmtChocolate("6");
		recipe6.setAmtCoffee("0");
		recipe6.setAmtMilk("1");
		recipe6.setAmtSugar("40");
		recipe6.setPrice("100");

		stubRecipies = new Recipe [] {recipe1, recipe2, recipe3};

	}
	
	
	//-----------------------------------------------------------------------
	//	Test Methods
	//-----------------------------------------------------------------------
	
	// put your tests here!
	
	@Test
	public void testMakeCoffee() {
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		assertTrue(true);
	}

	/**
	 * UC7: PurchaseBeverage
	 */

	/**
	 * Given a coffee maker with enough ingedients
	 * When we put in enough money
	 * Then we get our coffee and corresponding change
	 */
	@Test
	public void testPurchaseBeverage1(){
		// Create RecipeBook stub
		when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);

		// Create coffee maker
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		// Make coffee
		assertEquals(50, coffeeMaker.makeCoffee(0, 100));
		
	}

	/**
	 * Given a coffee maker with enough ingedients
	 * When we put in too little money
	 * Then we get our money back and no coffee
	 */
	@Test
	public void testPurchaseBeverage2(){
		// Create RecipeBook stub
		when(recipeBookStub.getRecipes()).thenReturn(stubRecipies);

		// Create coffee maker
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		// Make coffee
		assertEquals(5, coffeeMaker.makeCoffee(0, 5));
		
	}

	/**
	 * Given a coffee maker with not enough ingedients
	 * When we put in enough money
	 * Then we get no coffee and our money back
	 */
	@Test
	public void testPurchaseBeverage3(){
		// Create RecipeBook stub
		when(recipeBookStub.getRecipes()).thenReturn(new Recipe[]{recipe1, recipe6, null});

		// Create coffee maker
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		// Make coffee
		assertEquals(100, coffeeMaker.makeCoffee(1, 100));
		
	}

	/**
	 * Given a coffee maker with 2 recipes
	 * When we try to purchase a recipe at index 2
	 * Then we get our money back
	 */
	@Test
	public void testPurchaseBeverage4(){
		// Create RecipeBook stub
		when(recipeBookStub.getRecipes()).thenReturn(new Recipe[]{recipe1, recipe6, null});

		// Create coffee maker
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		// Make coffee
		assertEquals(100, coffeeMaker.makeCoffee(2, 100));
		
	}

	/**
	 * Given a coffee maker with 2 recipes
	 * When we try to purchase a recipe at index 4
	 * Then we get our money back
	 */
	@Test
	public void testPurchaseBeverage7(){
		// Create RecipeBook stub
		when(recipeBookStub.getRecipes()).thenReturn(new Recipe[]{recipe1, recipe6, null});

		// Create coffee maker
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		// Make coffee
		assertEquals(100, coffeeMaker.makeCoffee(4, 100));
		
	}

	/**
	 * Given a coffee maker with not enough ingedients
	 * When we put in enough money
	 * Then we get no coffee and our money back
	 */
	@Test
	public void testPurchaseBeverage8(){
		// Create RecipeBook stub
		when(recipeBookStub.getRecipes()).thenReturn(new Recipe[]{recipe1, recipe5, null});

		// Create coffee maker
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		// Make coffee
		assertEquals(100, coffeeMaker.makeCoffee(1, 100));
		
	}


	/**
	 * CHECK FOR ENOUGH INGREDIENTS
	 */

	/**
	 * Given a coffee maker with 3 recipes
	 * When we try to purchase a recipe with not enough ingredients
	 * Then the useIngredients method of the inventory class gets 
	 * called with the recipe we want to buy
	 */
	@Test
	public void testPurchaseBeverage5(){
		// Create Inventory Spy
		Inventory inventorySpy= spy(new Inventory());
		// Create RecipeBook stub
		when(recipeBookStub.getRecipes()).thenReturn(new Recipe[]{recipe1, recipe6, recipe3});

		// Create coffee maker
		coffeeMaker = new CoffeeMaker(recipeBookStub, inventorySpy);
		// Make coffee
		coffeeMaker.makeCoffee(2, 100);

		// Verify method call
		verify(inventorySpy).useIngredients(recipe3);
		
	}

	/**
	 * Given a coffee maker with 3 recipes
	 * When we try to purchase a recipe with not enough ingredients
	 * Then the enoughIngredients method of the inventory class gets 
	 * called with the recipe we want to buy
	 */
	@Test
	public void testPurchaseBeverage6(){
		// Create Inventory Spy
		Inventory inventorySpy= spy(new Inventory());
		// Create RecipeBook stub
		when(recipeBookStub.getRecipes()).thenReturn(new Recipe[]{recipe1, recipe6, recipe3});

		// Create coffee maker
		coffeeMaker = new CoffeeMaker(recipeBookStub, inventorySpy);
		// Make coffee
		coffeeMaker.makeCoffee(2, 100);

		// Verify method call
		verify(inventorySpy).enoughIngredients(recipe3);
		
	}


	/**
	 * VERIFY THAT getAmtChocolate(), getAmtCoffee(), getAmtMilk(), and getPrice() 
	 * ARE BEING CALLED ONCE ON THE SELECTED RECIPE AND ZERO TIMES ON OTHER RECIPES
	 */

	/**
	 * Given a coffee maker with recipes
	 * When we try to purchase a recipe at index 2
	 * Then the getAmt functions get called on the selected recipe at least once
	 * and do not get called on the other 2 recipes
	 */
	@Test
	public void testVerifyCall(){
		// Spy on recipes
		Recipe recipe1Spy= spy(recipe1);
		Recipe recipe6Spy= spy(recipe6);
		Recipe recipe3Spy= spy(recipe3);

		// Create RecipeBook stub
		when(recipeBookStub.getRecipes()).thenReturn(new Recipe[]{recipe1Spy, recipe6Spy, recipe3Spy});

		// Create coffee maker
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		// Make coffee
		assertEquals(0, coffeeMaker.makeCoffee(2, 100));

		// Verify method calls for selected recipe
		verify(recipe3Spy, atLeastOnce()).getAmtChocolate();
		verify(recipe3Spy, atLeastOnce()).getAmtMilk();
		verify(recipe3Spy, atLeastOnce()).getAmtSugar();
		verify(recipe3Spy, atLeastOnce()).getAmtCoffee();
		verify(recipe3Spy, atLeastOnce()).getPrice();

		// Verify method calls for other recipes
		verify(recipe1Spy, times(0)).getAmtChocolate();
		verify(recipe1Spy, times(0)).getAmtMilk();
		verify(recipe1Spy, times(0)).getAmtSugar();
		verify(recipe1Spy, times(0)).getAmtCoffee();
		verify(recipe1Spy, times(0)).getPrice();

		verify(recipe6Spy, times(0)).getAmtChocolate();
		verify(recipe6Spy, times(0)).getAmtMilk();
		verify(recipe6Spy, times(0)).getAmtSugar();
		verify(recipe6Spy, times(0)).getAmtCoffee();
		verify(recipe6Spy, times(0)).getPrice();
	}

	/**
	 * Given a coffee maker with 2 recipes
	 * When we try to purchase a recipe with not enough ingredients
	 * Then the getAmt functions get called only once
	 */
	@Test
	public void testVerifyCall1(){
		// Spy on recipes
		Recipe recipe1Spy= spy(recipe1);
		Recipe recipe6Spy= spy(recipe6);
		Recipe recipe3Spy= spy(recipe3);

		// Create RecipeBook stub
		when(recipeBookStub.getRecipes()).thenReturn(new Recipe[]{recipe1Spy, recipe6Spy, recipe3Spy});

		// Create coffee maker
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		// Make coffee
		assertEquals(100, coffeeMaker.makeCoffee(1, 100));

		// Verify method calls for selected recipe
		verify(recipe6Spy, times(1)).getAmtChocolate();
		verify(recipe6Spy, times(1)).getAmtMilk();
		verify(recipe6Spy, times(1)).getAmtSugar();
		verify(recipe6Spy, times(1)).getAmtCoffee();
		verify(recipe6Spy, times(1)).getPrice();

		// Verify method calls for other recipes
		verify(recipe1Spy, times(0)).getAmtChocolate();
		verify(recipe1Spy, times(0)).getAmtMilk();
		verify(recipe1Spy, times(0)).getAmtSugar();
		verify(recipe1Spy, times(0)).getAmtCoffee();
		verify(recipe1Spy, times(0)).getPrice();

		verify(recipe3Spy, times(0)).getAmtChocolate();
		verify(recipe3Spy, times(0)).getAmtMilk();
		verify(recipe3Spy, times(0)).getAmtSugar();
		verify(recipe3Spy, times(0)).getAmtCoffee();
		verify(recipe3Spy, times(0)).getPrice();
	}

	/**
	 * Given a coffee maker with recipes
	 * When we try to purchase a recipe at index 2
	 * Then the getAmt functions get called on the seledted recipe at least once
	 * and do not get called on the other 2 recipes
	 */
	@Test
	public void testVerifyCall2(){
		// Spy on recipes
		Recipe recipe1Spy= spy(recipe1);
		Recipe recipe6Spy= spy(recipe6);
		Recipe recipe3Spy= spy(recipe3);

		// Create RecipeBook stub
		when(recipeBookStub.getRecipes()).thenReturn(new Recipe[]{recipe1Spy, recipe6Spy, recipe3Spy});

		// Create coffee maker
		coffeeMaker = new CoffeeMaker(recipeBookStub, new Inventory());
		// Make coffee
		assertEquals(50, coffeeMaker.makeCoffee(0, 100));

		// Verify method calls for selected recipe
		verify(recipe1Spy, atLeastOnce()).getAmtChocolate();
		verify(recipe1Spy, atLeastOnce()).getAmtMilk();
		verify(recipe1Spy, atLeastOnce()).getAmtSugar();
		verify(recipe1Spy, atLeastOnce()).getAmtCoffee();
		verify(recipe1Spy, atLeastOnce()).getPrice();

		// Verify method calls for other recipes
		verify(recipe3Spy, times(0)).getAmtChocolate();
		verify(recipe3Spy, times(0)).getAmtMilk();
		verify(recipe3Spy, times(0)).getAmtSugar();
		verify(recipe3Spy, times(0)).getAmtCoffee();
		verify(recipe3Spy, times(0)).getPrice();

		verify(recipe6Spy, times(0)).getAmtChocolate();
		verify(recipe6Spy, times(0)).getAmtMilk();
		verify(recipe6Spy, times(0)).getAmtSugar();
		verify(recipe6Spy, times(0)).getAmtCoffee();
		verify(recipe6Spy, times(0)).getPrice();
	}

	/**
	 * CHECK THAT INVENTORY HAS DECREASED
	 */
	/**
	 * Given a coffee maker with enough ingedients
	 * When we put in enough money
	 * Then we get coffee and the coffee maker's inventory decreases
	 */
	@Test
	public void testInventory(){
		// Create RecipeBook stub
		when(recipeBookStub.getRecipes()).thenReturn(new Recipe[]{recipe1, recipe6, null});

		// Create coffee maker
		Inventory inventory= new Inventory();
		coffeeMaker = new CoffeeMaker(recipeBookStub, inventory);

		// Get inventory before coffee
		String prevInventory= coffeeMaker.checkInventory();
		// Make coffee
		coffeeMaker.makeCoffee(0, 100);

		// Check decreased inventory
		assertNotEquals(prevInventory, coffeeMaker.checkInventory());
		
	}

	/**
	 * Given a coffee maker with enough ingedients
	 * When we put in enough money
	 * Then we get coffee and the coffee maker's inventory decreases
	 */
	@Test
	public void testInventory1(){
		// Create RecipeBook stub
		when(recipeBookStub.getRecipes()).thenReturn(new Recipe[]{recipe1, recipe6, null});

		// Create coffee maker
		Inventory inventory= new Inventory();
		coffeeMaker = new CoffeeMaker(recipeBookStub, inventory);

		// Make coffee
		coffeeMaker.makeCoffee(0, 100);

		// Check decreased inventory
		assertEquals(15-recipe1.getAmtChocolate(), inventory.getChocolate());
		assertEquals(15-recipe1.getAmtMilk(), inventory.getMilk());
		assertEquals(15-recipe1.getAmtSugar(), inventory.getSugar());
		assertEquals(15-recipe1.getAmtCoffee(), inventory.getCoffee());
		
	}

	

	
}
