package com.example.view;

import android.app.Activity;
import android.widget.TextView;

import com.example.calculator.R;

public class CaOutputView {

	
	TextView tv;

	
	public CaOutputView(Activity ac) {
		tv = (TextView)ac.findViewById(R.id.OutputText);
	}
	
	public void outputData(String str){
		tv.setText(str);
	}

}
