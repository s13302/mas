package pl.s13302.mas.manager;

import pl.s13302.mas.model.Product;

public class ProductManager implements Manager<Product> {

    @Override
    public String className() {
        return Product.class.getSimpleName();
    }
}
