package net.blitzstein.demo.testing.integration.web;

import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;

public class ProductIndexSeleniumTest extends SeleneseTestCase {

    public void setUp() throws Exception {
        setUp("http://localhost:8080/", "*chrome");
    }

    public void testNew() throws Exception {
        selenium.open("/testing-demo/product/index.htm");

        //Verify page title
        verifyEquals("Index", selenium.getTitle());

        //Verify page headings
        verifyEquals("Index", selenium.getText("css=h1"));

        //Veify page elements
        verifyEquals("Id", selenium.getText("//th[1]"));
        verifyEquals("Name", selenium.getText("//th[2]"));
        verifyEquals("Manufacturer", selenium.getText("//th[3]"));
        verifyEquals("Price", selenium.getText("//th[4]"));
        verifyEquals("Action", selenium.getText("//th[5]"));

        //Verify page buttons
        verifyEquals("Create", selenium.getText("link=Create"));

        //TODO - Add some type of function to find a valid product that should be there
        //or have DbUnit ensure expected values are present
        //or pass in a mock / dummy
        validateProductValues(1);

        
    }

    private void validateProductValues(int productIdToVerify) {
        verifyEquals("View", selenium.getAttribute(String.format("view_%s@title", productIdToVerify)));
        verifyEquals("Edit", selenium.getAttribute(String.format("edit_%s@title", productIdToVerify)));
        verifyEquals("Delete", selenium.getAttribute(String.format("delete_%s@title", productIdToVerify)));

        verifyEquals("eu", selenium.getText(String.format("xpath=//tr[@id='product_row_%s']/td[%s]", productIdToVerify, 2)));
        verifyEquals("ullamcorper,", selenium.getText(String.format("xpath=//tr[@id='product_row_%s']/td[%s]", productIdToVerify, 3)));
        verifyEquals("$254.00", selenium.getText(String.format("xpath=//tr[@id='product_row_%s']/td[%s]", productIdToVerify, 4)));
    }
}
