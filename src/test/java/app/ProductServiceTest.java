package app;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    ProductService productService = null;
    Recipe recipe = new Recipe();
    @Mock
    Screen screen;
    @Mock
    Scanner scanner;
    @Mock
    DataBase dataBase;
    @Mock
    Printer printer;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        productService = new ProductService(dataBase, scanner, screen,printer);
        recipe.addProduct( new Product("PL126752",10,"szampon","Szamponix"));
        recipe.addProduct( new Product("PL122352",100,"spodnie","Spodnix"));
        recipe.addProduct( new Product("PL126432",30,"perfumy","Perfumix"));
        recipe.addProduct( new Product("PL112752",11,"żelki","Żelix"));
    }

    @Test
    public void searchProduct1() {
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        Product product = new Product("PL126752", 10, "szampon", "Szamponix");
        when(dataBase.findProduct("PL126752")).thenReturn(product);
        productService.screenService("PL126752", recipe);
        verify(screen).printOnScreen(argumentCaptor.capture());
        assertEquals(product.toString(), argumentCaptor.getValue());
    }

    @Test
    public void searchProduct2() {
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        when(dataBase.findProduct("PL126752")).thenReturn(null);
        productService.screenService("PL126752", recipe);
        verify(screen).printOnScreen(argumentCaptor.capture());
        assertEquals("Product not found", argumentCaptor.getValue());
    }
    @Test
    public void searchProduct3() {
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        productService.screenService("", recipe);
        verify(screen).printOnScreen(argumentCaptor.capture());
        assertEquals("Invalid bar-code", argumentCaptor.getValue());
    }
    @Test
    public void searchProduct4() {
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        productService.screenService(null, recipe);
        verify(screen).printOnScreen(argumentCaptor.capture());
        assertEquals("Invalid bar-code", argumentCaptor.getValue());
    }
    @Test
    public void searchProduct5()  {
        ArgumentCaptor<String> printerCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        productService.screenService("exit", recipe);
        verify(screen).printOnScreen(argumentCaptor.capture());
        verify(printer).print(printerCaptor.capture());
        assertEquals(recipe.toString(), argumentCaptor.getValue());
        assertEquals(recipe.toString(), printerCaptor.getValue());
    }
    @Test
    public void clientService() {
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        when(scanner.readValue()).thenReturn("exit");
        productService.clientService(recipe);
        verify(screen).printOnScreen(argumentCaptor.capture());
        assertEquals(recipe.toString(), argumentCaptor.getValue());
    }
}