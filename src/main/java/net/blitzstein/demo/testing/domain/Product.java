/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.blitzstein.demo.testing.domain;

/**
 *
 * @author jared
 */
public class Product {
    private Integer id;
    private String name, description;
    private float price;
    private String manufacturer;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product() {
    }

    public Product(Integer id, String name, String description, String manufacturer, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    

}
