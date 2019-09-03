package org.matt.calculatorapp.AppView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

import org.matt.calculatorapp.Presenter.AppPresenter;
import org.matt.calculatorapp.Presenter.Presenter;
import org.matt.calculatorapp.R;

public class MainActivity extends AppCompatActivity implements AppView {

    private static final String TAG = MainActivity.class.getSimpleName();
    private final Presenter presenter = new AppPresenter(this);
    private TextView tv_inputString;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_inputString = findViewById(R.id.tv_userInput);
        tv_result = findViewById(R.id.tv_userResult);

        setButtonClickHandlers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.prefix_mode:
                presenter.setCalculatorMode("PREFIX");
                break;
            case R.id.infix_mode:
                presenter.setCalculatorMode("INFIX");
                break;
            case R.id.postfix_mode:
                presenter.setCalculatorMode("POSTFIX");
                break;
        }
        return true;
    }

    @Override
    public void setTvInputString(String inputString) {
        this.tv_inputString.setText(inputString);
    }

    @Override
    public void setTvResult(String result) {
        this.tv_result.setText(result);
    }

    @Override
    public void clearInputString() {
        this.tv_inputString.setText("");
    }

    @Override
    public void clearResult() {
        this.tv_result.setText("");
    }

    private void setButtonClickHandlers() {
        /* These buttons only add a single character to the input string */
        ((Button)findViewById(R.id.btn_0)).setOnClickListener(basicButtonClick);
        ((Button)findViewById(R.id.btn_1)).setOnClickListener(basicButtonClick);
        ((Button)findViewById(R.id.btn_2)).setOnClickListener(basicButtonClick);
        ((Button)findViewById(R.id.btn_3)).setOnClickListener(basicButtonClick);
        ((Button)findViewById(R.id.btn_4)).setOnClickListener(basicButtonClick);
        ((Button)findViewById(R.id.btn_5)).setOnClickListener(basicButtonClick);
        ((Button)findViewById(R.id.btn_6)).setOnClickListener(basicButtonClick);
        ((Button)findViewById(R.id.btn_7)).setOnClickListener(basicButtonClick);
        ((Button)findViewById(R.id.btn_8)).setOnClickListener(basicButtonClick);
        ((Button)findViewById(R.id.btn_9)).setOnClickListener(basicButtonClick);
        ((Button)findViewById(R.id.btn_add)).setOnClickListener(basicButtonClick);
        ((Button)findViewById(R.id.btn_sub)).setOnClickListener(basicButtonClick);
        ((Button)findViewById(R.id.btn_mul)).setOnClickListener(basicButtonClick);
        ((Button)findViewById(R.id.btn_div)).setOnClickListener(basicButtonClick);

        /* These buttons have more advanced functionality */
        ((Button)findViewById(R.id.btn_decimal)).setOnClickListener(decimalButtonClick);
        ((Button)findViewById(R.id.btn_decimal)).setOnLongClickListener(decimalButtonClickLong);
        ((Button)findViewById(R.id.btn_neg)).setOnClickListener(negButtonClick);
        ((Button)findViewById(R.id.btn_paren)).setOnClickListener(parenButtonClick);
        ((Button)findViewById(R.id.btn_eq)).setOnClickListener(equalsButtonClick);
        ((Button)findViewById(R.id.btn_del)).setOnClickListener(deleteButtonClick);
        ((Button)findViewById(R.id.btn_clear)).setOnClickListener(clearButtonClick);
    }

    OnClickListener basicButtonClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            presenter.addToInputString(((Button)view).getText().charAt(0));
        }
    };

    OnClickListener decimalButtonClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            presenter.addToInputString('.');
        }
    };

    OnLongClickListener decimalButtonClickLong = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            presenter.addToInputString(' ');
            return true;
        }
    };

    OnClickListener clearButtonClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            presenter.clearCalculator();
        }
    };

    OnClickListener deleteButtonClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            presenter.deleteFromInputString();
        }
    };

    OnClickListener equalsButtonClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            String tempResult = presenter.getResult();
            presenter.clearCalculator();
            presenter.setInputString(tempResult);
        }
    };

    OnClickListener parenButtonClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            presenter.addParen();
        }
    };

    OnClickListener negButtonClick = new OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };



}