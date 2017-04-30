package br.com.hbsis.nelson.jankenpo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StrategyValidatorTest {
	private StrategyValidator validator;

	@Before
	public void init() {
		validator = new StrategyValidator();
	}

	@Test
	public void if_strategy_is_valid_return_true() {
		Assert.assertTrue(validator.isValidStrategy("P"));
		Assert.assertTrue(validator.isValidStrategy("R"));
		Assert.assertTrue(validator.isValidStrategy("S"));
		Assert.assertTrue(validator.isValidStrategy("p"));
		Assert.assertTrue(validator.isValidStrategy("r"));
		Assert.assertTrue(validator.isValidStrategy("s"));
	}

	@Test
	public void if_strategy_is_not_valid_return_false() {
		Assert.assertFalse(validator.isValidStrategy("a"));
	}

}
