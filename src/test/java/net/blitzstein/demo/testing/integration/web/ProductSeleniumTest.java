/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.blitzstein.demo.testing.integration.web;

import org.junit.Test;
import static org.junit.Assert.*;
import com.thoughtworks.selenium.*;

import com.thoughtworks.selenium.DefaultSelenium;
import org.junit.Before;

/**
 *
 * @author jared
 */
public class ProductSeleniumTest extends SeleneseTestCase {

    @Test
    public void thisIsTrue() {
        assertTrue(true);
    }

    @Before
    public void before() throws Exception {
        setUp("http://www.google.com/", "*chrome");
    }

    @Test
    public void testSomethingSimple() throws Exception {
        //DefaultSelenium selenium = createSeleniumClient("http://localhost:8080/");
        //selenium.start();

        //
        // This is an exmaple of testing the Apache Geroniom Welcome page for specific text
        //

        selenium.open("/");
        selenium.type("//input[@name='q']", "test");
        selenium.click("btnG");
        verifyTrue(selenium.isElementPresent("//a[@id='logo']/img"));


//        selenium.click("link=JVM");
//        selenium.waitForPageToLoad("30000");
//        selenium.click("link=Welcome");
//        selenium.waitForPageToLoad("30000");
//        assertEquals("Geronimo Console", selenium.getTitle());
//        assertEquals("Welcome", selenium.getText(
//            "xpath=/html/body/table[@id='rootfragment']/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/table/tbody/tr[1]/td/table/tbody/tr[1]/td/div/table/tbody/tr/td[2]/table/tbody/tr/td[1]/strong"));
//
//        // Test help link
//        selenium.click("link=help");
//        selenium.waitForPageToLoad("30000");
//        selenium.isTextPresent("This is the help for the Geronimo Administration Console Welcome.");

        //selenium.stop();
    }
}
