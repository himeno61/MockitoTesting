package app;

public class ProductService {
    private DataBase dataBase;
    private Scanner scanner;
    private Screen screen;
    private Printer printer;

    public ProductService(DataBase dataBase, Scanner scanner, Screen screen, Printer printer) {
        this.dataBase = dataBase;
        this.scanner = scanner;
        this.screen = screen;
        this.printer = printer;
    }

    public void clientService(Recipe recipe){
        String barCode = null;
        while (true){
            barCode = scanner.readValue();
            if(barCode == "exit") {
                screenService(barCode,recipe);
                break;
            }
            else
                screenService(barCode,recipe);
        }
    }

    public void screenService(String barCode, Recipe recipe ) {
        if (barCode == "exit") {
            screen.printOnScreen(recipe.toString());
            printer.print(recipe.toString());
        } else {
            Product temp = null;
            try {
                temp = searchProduct(barCode);
                if (temp != null) {
                    recipe.addProduct(temp);
                    screen.printOnScreen(temp.toString());
                } else {
                    screen.printOnScreen("Product not found");
                }
            } catch (BarCodeExeption e) {
                screen.printOnScreen("Invalid bar-code");
            }
        }
    }

    private Product searchProduct(String barCode) throws BarCodeExeption {
        Product temp = null;
        if(barCode == "" || barCode == null )
            throw new  BarCodeExeption("Invalid bar-code");
        else {
            temp = dataBase.findProduct(barCode);
            return temp;
        }
    }
}
