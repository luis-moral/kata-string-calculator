package es.molabs.kata.stringcalculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorInputParser 
{
	private final String delimiter;
	
	public CalculatorInputParser(String delimiter)
	{
		this.delimiter = delimiter;
	}
	
	public CalculatorInput parse(String numbers)
	{
		CalculatorInput input;
		
		if (numbers.isEmpty())
		{
			input = new CalculatorInput();
		}
		else
		{
			String[] splittedNumbers = numbers.split(delimiter);
			
			input = 
				new CalculatorInput
				(
					Arrays
						.stream(splittedNumbers)
						.map(value -> Integer.parseInt(value))
						.collect(Collectors.toList())
				);		
		}
		
		return input;
	}

	public class CalculatorInput
	{
		private final List<Integer> parameterList;
		
		public CalculatorInput() 
		{
			this(new LinkedList<Integer>());
		}
		
		public CalculatorInput(List<Integer> parameterList)
		{
			this.parameterList = parameterList;
		}

		public List<Integer> getParameterList() 
		{
			return parameterList;
		}
	}
}
