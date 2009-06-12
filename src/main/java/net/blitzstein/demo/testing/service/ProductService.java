/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.blitzstein.demo.testing.service;

import java.util.List;
import net.blitzstein.demo.testing.domain.Product;

/**
 *
 * @author jared
 */
public interface ProductService {
    public Product getProduct(Integer id);
    public List<Product> getProducts();
    public void save(Product product);
    public void delete(Integer id);

}
