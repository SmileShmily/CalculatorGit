package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

import com.example.calculator.R.id;
import com.example.view.CaInputView;
import com.example.view.CaInputView.InputHappend;
import com.example.view.CaOutputView;
import com.exmaple.model.CalModel;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements InputHappend {

	
	private CaInputView civ;
	private CaOutputView cov;
	private CalModel calModel;
	
	private String number = "0";
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		civ = new CaInputView(this, this);
		cov = new CaOutputView(this);
		calModel = new CalModel();
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void operandIn(String operand) {
		number = number.equals("0")? operand : number + operand;
		cov.outputData(number);		
	}

	@Override
	public void operateIn(String operate) {
		if(operate.equalsIgnoreCase("c")){
			calModel.reset();
			number = "0";
			cov.outputData(number);
			return;
		}
		
		calModel.pushOperand(number);
		double result = calModel.pushOperate(operate);
		
		if(result % 1d == 0d)
		{
			int temp = Double.valueOf(result).intValue();
			cov.outputData(String.valueOf(temp));
		}
		else{
			cov.outputData(String.valueOf(result));
		}
	
		number = "0";
	}

}
