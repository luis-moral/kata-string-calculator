package es.molabs.kata.stringcalculator;

import java.util.stream.IntStream;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import es.molabs.kata.stringcalculator.CalculatorInputParser.CalculatorInput;

@RunWith(JUnit4.class)
public class CalculatorInputParserShould 
{
	@Test
	public void be_empty_when_empty_string()
	{
		testParseWithParameters(",", 0);
	}
	
	@Test
	public void be_one_parameter_when_string_with_one_number()
	{
		testParseWithParameters(",", 1);
	}
	
	@Test
	public void be_five_parameters_when_string_with_five_numbers_delimited()
	{
		testParseWithParameters(",", 5);
	}
	
	@Test
	public void parse_any_delimiter()
	{
		testParseWithParameters("\n", 5);
	}
	
	private void testParseWithParameters(String delimiter, int amount)
	{
		CalculatorInput input = new CalculatorInputParser(delimiter).parse(numberInput(delimiter, amount));
		
		if (amount > 0)
		
		assertCalculatorInput(input, amount);
	}
	
	private String numberInput(String delimiter, int amount)
	{
		StringBuilder builder = new StringBuilder();
		
		IntStream
			.rangeClosed(1, amount)
			.forEach
			(
				number -> 
				{
					builder.append(number);
					
					if (number < amount)
					{
						builder.append(delimiter);
					}
				}
			);
		
		return builder.toString();
	}
	
	private void assertCalculatorInput(CalculatorInput input, int amount)
	{
		if (amount == 0)
		{
			Assert.assertThat(0, Is.is(input.getParameterList().size()));
		}
		else
		{
			IntStream
				.rangeClosed(1, amount)
				.forEach
				(
					number ->
					{
						Assert.assertThat(number, Is.is(input.getParameterList().get(number - 1)));
					}
				);
		}
	}
	
	@Before
	public void setUp()
	{
		
	}
}
