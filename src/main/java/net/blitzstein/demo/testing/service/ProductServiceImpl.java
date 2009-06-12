/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.blitzstein.demo.testing.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.blitzstein.demo.testing.domain.Product;
import net.blitzstein.demo.testing.domain.ProductComparable;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 *
 * @author jared
 */
@Service
public class ProductServiceImpl implements ProductService, ApplicationContextAware {

    private ApplicationContext context;
    private List<Product> products;

    public Product getProduct(Integer id) {
        for (Product product : products) {

            if (product.getId().equals(id)) {
                return product;
            }

        }

        return null;
    }

    private int getNextProductId() {
        Product product = this.getProducts().get(this.getProducts().size() - 1);
        return product.getId() + 1;
    }

    public List<Product> getProducts() {
        if (this.products == null || this.products.isEmpty()) {
            Map productMap = context.getBeansOfType(net.blitzstein.demo.testing.domain.Product.class);
            this.products = new ArrayList(productMap.values());
        }

        Collections.sort(products, new ProductComparable());
        return this.products;
    }

    public void save(Product product) {
        if (product.getId() == null) {
            product.setId(getNextProductId());
            this.products.add(product);
        } else {
            swapProduct(product);
        }


    }

    public void delete(Integer id) {
        Product product = getProduct(id);
        this.products.remove(product);
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    private void swapProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            Product currentProduct = products.get(i);
            if (currentProduct.getId().intValue() == product.getId().intValue()) {
                this.products.set(i, product);
                return;
            }
        }
    }
}
