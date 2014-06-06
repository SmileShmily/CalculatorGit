package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

import com.example.view.CaInputView;
import com.example.view.CaInputView.InputHappend;
import com.example.view.CaOutputView;

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
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		civ = new CaInputView(this, this);
		cov = new CaOutputView(this);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void operandIn(String operand) {
		cov.outputData(operand);
		
	}

	@Override
	public void operateIn(String operate) {
		cov.outputData(operate);
	}

}
