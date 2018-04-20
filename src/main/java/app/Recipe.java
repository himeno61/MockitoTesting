package app;

import java.util.LinkedList;
import java.util.List;

public class Recipe {
    private List<Product> productList = new LinkedList<>();
    private Integer sum=0;

    public Recipe() {
    }

    public Integer getSum() {
        return sum;
    }

    public void addProduct(Product product){
        productList.add(product);
        sum+=product.getPrice();
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "productList=" + productList +
                ", sum=" + sum +
                '}';
    }
}
