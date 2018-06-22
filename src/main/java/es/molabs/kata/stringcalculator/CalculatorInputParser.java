package es.molabs.kata.stringcalculator;

import java.util.Optional;

public class CalculatorInputParser 
{
	private final static String DELIMITER = ",";
	
	public CalculatorInput parse(String numbers)
	{
		CalculatorInput input;
		
		if (numbers.isEmpty())
		{
			input = new CalculatorInput(Optional.empty(), Optional.empty());
		}
		else
		{
			String[] splittedNumbers = numbers.split(DELIMITER);
			
			if (splittedNumbers.length == 1)
			{
				input = 
					new CalculatorInput
					(
						Optional.of(Integer.valueOf(splittedNumbers[0])), 
						Optional.empty()
					);
			}
			else
			{
				input = 
					new CalculatorInput
					(
						Optional.of(Integer.valueOf(splittedNumbers[0])), 
						Optional.of(Integer.valueOf(splittedNumbers[1]))
					);
			}			
		}
		
		return input;
	}

	public class CalculatorInput
	{
		private final Optional<Integer> parameterOne;
		private final Optional<Integer> parameterTwo;
		
		public CalculatorInput(Optional<Integer> parameterOne, Optional<Integer> parameterTwo) 
		{
			this.parameterOne = parameterOne;
			this.parameterTwo = parameterTwo;
		}

		public Optional<Integer> getParameterOne() 
		{
			return parameterOne;
		}

		public Optional<Integer> getParameterTwo() 
		{
			return parameterTwo;
		}
	}
}
