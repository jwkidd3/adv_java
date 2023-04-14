package examples.platform;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * EmbeddedJSExample is an example of creating a Java application that
 * hosts a ScriptEngine. The example uses JS as the language and Rhino
 * as the ScriptEngine.
 * <p/>
 * Copyright DevelopIntelligence 2010. All rights reserved.
 * <p/>
 * User: developintelligence llc
 * Date: Mar 7, 2010
 * Time: 8:31:03 PM
 */
public class EmbeddedJSExample {

  public static void main(String[] args) {
    ScriptEngineManager factory = new ScriptEngineManager();
    ScriptEngine engine = factory.getEngineByName("JavaScript");

    try {
      engine.eval("print('Hello Scripting World')");
    } catch (ScriptException e) {
      System.err.println("Error processing JS: " + e);

    }
  }
}
