/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.blitzstein.demo.testing.domain;

import java.util.Comparator;

/**
 *
 * @author jared
 */
public class ProductComparable implements Comparator {

    public int compare(Object o1, Object o2) {

        Product prod1 = (Product)o1;
        Product prod2 = (Product)o2;

        if (prod1.getId() < prod2.getId()) {
            return -1;
        } else if (prod1.getId() > prod2.getId()) {
            return 1;
        } else {
            return 0;
        }
    }

}
