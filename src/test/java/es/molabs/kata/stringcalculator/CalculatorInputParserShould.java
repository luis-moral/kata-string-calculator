package es.molabs.kata.stringcalculator;

import java.util.Optional;

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
	private CalculatorInputParser inputParser;
	
	@Test
	public void be_empty_when_empty_string()
	{
		CalculatorInput input = inputParser.parse("");
		
		Assert.assertThat(false, Is.is(input.getParameterOne().isPresent()));
		Assert.assertThat(false, Is.is(input.getParameterTwo().isPresent()));
	}
	
	@Test
	public void be_one_parameter_when_string_with_one_number()
	{
		CalculatorInput input = inputParser.parse("1");
		
		Assert.assertThat(1, Is.is(input.getParameterOne().get()));
		Assert.assertThat(Optional.empty(), Is.is(input.getParameterTwo()));
	}
	
	@Test
	public void be_two_parameters_when_string_with_two_numbers_delimited()
	{
		CalculatorInput input = inputParser.parse("1,2");
		
		Assert.assertThat(1, Is.is(input.getParameterOne().get()));
		Assert.assertThat(2, Is.is(input.getParameterTwo().get()));
	}
	
	@Before
	public void setUp()
	{
		inputParser = new CalculatorInputParser();
	}
}
