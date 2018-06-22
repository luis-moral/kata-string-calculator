package es.molabs.kata.stringcalculator;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculatorShould 
{
	private Calculator calculator;
	
	@Test
	public void sum_zero_number_values()
	{
		Assert.assertThat(calculator.add(""), Is.is(0));
	}
	
	@Test
	public void sum_one_number_value()
	{
		Assert.assertThat(calculator.add("1"), Is.is(1));
	}
	
	@Test
	public void sum_two_number_values()
	{
		Assert.assertThat(calculator.add("1,2"), Is.is(3));
	}
	
	@Test
	public void sum_three_number_values()
	{
		Assert.assertThat(calculator.add("1,2,3"), Is.is(6));
	}
	
	@Before
	public void setUp()
	{
		calculator = new Calculator(",");
	}
}