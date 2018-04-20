package app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeTest {
    Recipe recipe = new Recipe();
    @Before
    public void setUp() throws Exception {
        recipe.addProduct( new Product("PL126752",10,"szampon","Szamponix"));
        recipe.addProduct( new Product("PL122352",100,"spodnie","Spodnix"));
        recipe.addProduct( new Product("PL126432",30,"perfumy","Perfumix"));
        recipe.addProduct( new Product("PL112752",11,"żelki","Żelix"));
        recipe.addProduct( new Product("PL126542",6,"jabkłka","Jabłex"));
        recipe.addProduct( new Product("PL166752",3,"chleb","Chlebex"));
    }
    @Test
    public void getSum() throws Exception {
       assertEquals((long) 160,(long)recipe.getSum());
    }
}