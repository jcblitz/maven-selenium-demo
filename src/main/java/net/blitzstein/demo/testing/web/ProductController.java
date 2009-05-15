/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.blitzstein.demo.testing.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.blitzstein.demo.testing.domain.Product;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jared
 */
@Controller
public class ProductController implements ApplicationContextAware {
    private List<Product> products = new ArrayList();
    private ApplicationContext context;

    @RequestMapping(value = "/product/index.htm", method = RequestMethod.GET)
    public void index(Model model) {
        model.addAttribute("products", getProducts());
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @RequestMapping(value = "/product/view.htm", method = RequestMethod.GET)
    public void view(Model model, @RequestParam("id") int id) {
        Product product = getProduct(id);
        model.addAttribute(product);
    }

    @RequestMapping(value = "/product/edit.htm", method = RequestMethod.GET)
    public void edit(Model model, @RequestParam("id") int id) {
        Product product = getProduct(id);
        model.addAttribute(product);
    }

    @RequestMapping(value = "/product/create.htm", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute(new Product());
        return "product/edit";
    }

    @RequestMapping(value = "/product/save.htm", method = RequestMethod.POST)
    public void save(
            @ModelAttribute("Product") Product product) {

    }


    @RequestMapping(value = "/product/delete.htm", method = RequestMethod.GET)
    public String delete(@RequestParam("id") int id) {
        deleteProduct(id);
        return "redirect:index.htm";
    }

    private void deleteProduct(int id) {
        Product product = getProduct(id);
        this.products.remove(product);
    }

    private List<Product> getProducts() {
        //return products;
        if (this.products == null || this.products.isEmpty()) {
            Map productMap =  context.getBeansOfType(net.blitzstein.demo.testing.domain.Product.class);
            this.products = new ArrayList(productMap.values());
        }

        return this.products;
    }

    private Product getProduct(Integer id) {
        for (Product product : products) {

            if (product.getId().equals(id)) {
                return product;
            }

        }

        return null;
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }
}
