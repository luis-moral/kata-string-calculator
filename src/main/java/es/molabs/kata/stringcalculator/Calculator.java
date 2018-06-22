package es.molabs.kata.stringcalculator;

import es.molabs.kata.stringcalculator.CalculatorInputParser.CalculatorInput;

public class Calculator 
{	
	private CalculatorInputParser inputParser;
	
	public Calculator()
	{
		inputParser = new CalculatorInputParser();
	}
	
	public int add(String numbers)
	{
		int sum = 0;
		
		CalculatorInput input = inputParser.parse(numbers);
		
		if (input.getParameterOne().isPresent() && input.getParameterTwo().isPresent())
		{
			sum = input.getParameterOne().get() + input.getParameterTwo().get();
		}
		else if (input.getParameterOne().isPresent())
		{
			sum = input.getParameterOne().get();
		}
		
		return sum;
	}
}
