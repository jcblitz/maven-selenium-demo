/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.blitzstein.demo.testing.web;

import net.blitzstein.demo.testing.domain.Product;
import net.blitzstein.demo.testing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author jared
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/index.htm", method = RequestMethod.GET)
    public void index(Model model) {
        model.addAttribute("products", productService.getProducts());
    }

    @RequestMapping(value = "/product/view.htm", method = RequestMethod.GET)
    public void view(Model model, @RequestParam("id") int id) {
        Product product = productService.getProduct(new Integer(id));
        model.addAttribute(product);
    }

    @RequestMapping(value = "/product/edit.htm", method = RequestMethod.GET)
    public void edit(Model model, @RequestParam("id") int id) {
        Product product = productService.getProduct(new Integer(id));
        model.addAttribute(product);
    }

    @RequestMapping(value = "/product/create.htm", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute(new Product());
        return "product/edit";
    }

    @RequestMapping(value = "/product/save.htm", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("Product") Product product, Model model, WebRequest webRequest) {

        productService.save(product);

        registerMessage(webRequest, "Product was saved!");
        return "redirect:view.htm?id=" + product.getId();
    }

    @RequestMapping(value = "/product/delete.htm", method = RequestMethod.GET)
    public String delete(@RequestParam("id") int id) {
        productService.delete(new Integer(id));
        return "redirect:index.htm";
    }

    private void registerMessage(WebRequest webRequest, String message) {
        webRequest.setAttribute("message", message, WebRequest.SCOPE_SESSION);
    }
}
