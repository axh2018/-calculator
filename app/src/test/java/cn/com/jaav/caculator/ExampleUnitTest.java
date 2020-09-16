package cn.com.jaav.caculator;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(1+1, 2);
    }
    //javaScript引擎计算表达式的值
    public static String getResult(String rule) {
        String result = null;
        try {
            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
            result =String.valueOf(scriptEngine.eval(rule));
        } catch (Exception e) {
            e.getMessage();
        }
        return result;
    }
}