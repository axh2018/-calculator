package cn.com.jaav.caculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.googlecode.aviator.AviatorEvaluator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7,
            button_8, button_9, button_add, button_substract, button_multiple,
            button_devide, button_point, button_equal, button_clear, button_del;
    private EditText editText_result;

    public void init() {
        button_0 = findViewById(R.id.button_0);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);
        button_add = findViewById(R.id.button_add);
        button_substract = findViewById(R.id.button_substract);
        button_multiple = findViewById(R.id.button_multiply);
        button_devide = findViewById(R.id.button_devide);
        button_point = findViewById(R.id.button_point);
        button_equal = findViewById(R.id.button_equal);
        button_clear = findViewById(R.id.clear);
        button_del = findViewById(R.id.del);
        editText_result = findViewById(R.id.result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
         * 初始化
         */
        init();
        /*
         * 响应
         */
        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_del.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_substract.setOnClickListener(this);
        button_multiple.setOnClickListener(this);
        button_devide.setOnClickListener(this);
        button_point.setOnClickListener(this);
        button_equal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_0:
                editText_result.append("0");
                break;
            case R.id.button_1:
                editText_result.append("1");
                break;
            case R.id.button_2:
                editText_result.append("2");
                break;
            case R.id.button_3:
                editText_result.append("3");
                break;
            case R.id.button_4:
                editText_result.append("4");
                break;
            case R.id.button_5:
                editText_result.append("5");
                break;
            case R.id.button_6:
                editText_result.append("6");
                break;
            case R.id.button_7:
                editText_result.append("7");
                break;
            case R.id.button_8:
                editText_result.append("8");
                break;
            case R.id.button_9:
                editText_result.append("9");
                break;
            case R.id.button_point:
                editText_result.append(".");
                break;
            case R.id.button_equal:
                String expression = editText_result.getText().toString();
                if (!"".equals(expression))
                {
                    Long result = (Long) AviatorEvaluator.execute(expression);
                    editText_result.setText(result.toString());
                }
                break;
                /*
                Toast.makeText(getApplicationContext(), expression, Toast.LENGTH_LONG).show();
                String result = "";
                ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
                ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
                try {
                    //空指针异常
                    if (scriptEngine.eval(expression) != null) {
                        result = String.valueOf(scriptEngine.eval(expression));
                    }
                    editText_result.setText(result);
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
                 */
            case R.id.button_add:
                editText_result.append("+");
                break;
            case R.id.button_substract:
                editText_result.append("-");
                break;
            case R.id.button_multiply:
                editText_result.append("*");
                break;
            case R.id.button_devide:
                editText_result.append("/");
                break;
            case R.id.clear:
                editText_result.setText("");
                break;
            case R.id.del:
                String resultDel = editText_result.getText().toString();
                if (resultDel.length() != 0) {
                    String newResult = resultDel.substring(0, resultDel.length() - 1);
                    editText_result.setText(newResult);
                }
                break;
            default:
                break;
        }
    }
}