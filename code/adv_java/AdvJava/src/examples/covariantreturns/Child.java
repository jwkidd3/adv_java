package examples.covariantreturns;

/**
 * Copyright DevelopIntelligence 2007. All rights reserved.
 * <p/>
 * User: developintelligence llc
 * Date: Mar 6, 2010
 * Time: 1:03:26 PM
 */
public class Child extends Parent {
    
    @Override
    public String getName() {
        return (String) super.getName(); 
    }

    @Override
    public String getValue() {
        return (String) super.getValue();
    }
}
