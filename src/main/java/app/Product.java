package app;
public class Product{
    String barCode;
    Integer price;
    String description;
    String producer;

    public Product(String barCode, Integer price, String description, String producer) {
        this.barCode = barCode;
        this.price = price;
        this.description = description;
        this.producer = producer;
    }

    public String getBarCode() {
        return barCode;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getProducer() {
        return producer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "barCode='" + barCode + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (barCode != null ? !barCode.equals(product.barCode) : product.barCode != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        return producer != null ? producer.equals(product.producer) : product.producer == null;
    }

    @Override
    public int hashCode() {
        int result = barCode != null ? barCode.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        return result;
    }
}
