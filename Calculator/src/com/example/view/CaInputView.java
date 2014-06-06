package com.example.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;

public class CaInputView {

	public interface InputHappend{
		public void operandIn(String operand);
		public void operateIn(String operate);
	}

	
	
	List<Button> operands = new ArrayList<Button>();
	List<Button> operates = new ArrayList<Button>();
	
	private CaInputView.InputHappend dlg;
	
	public CaInputView(Activity ac, CaInputView.InputHappend  delegate)
	{
		dlg = delegate;
		
		Resources res = ac.getResources();
		for(int i = 0; i <= 9; i++)
		{
			int id = res.getIdentifier("Operand" + i, "id", ac.getPackageName());
			Button btn = (Button)ac.findViewById(id);
			operands.add(btn);
		}
		
		for(int i = 0; i <= 5; i++)
		{
			int id = res.getIdentifier("Operate" + i, "id", ac.getPackageName());
			Button btn = (Button)ac.findViewById(id);
			operates.add(btn);
		}
		
		
		for(Button btn: operands)
		{
			btn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Button cli_btn = (Button)v;
					String text = cli_btn.getText().toString();
					dlg.operandIn(text);					
				}
			});
		}
		
		
		
		for(Button btn: operates)
		{
			btn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Button cli_btn = (Button)v;
					String text = cli_btn.getText().toString();
					dlg.operateIn(text);					
				}
			});
		}
	}
	
	
	
}
