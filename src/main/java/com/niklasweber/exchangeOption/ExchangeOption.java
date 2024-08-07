package com.niklasweber.exchangeOption;

import net.finmath.exception.CalculationException;
import net.finmath.montecarlo.assetderivativevaluation.AssetModelMonteCarloSimulationModel;
import net.finmath.montecarlo.assetderivativevaluation.products.AbstractAssetMonteCarloProduct;
import net.finmath.stochastic.RandomVariable;

/**
 * This class represents an exchange option, involving therefore a two-dimensional process
 *
 * @author Niklas Weber
 *
 */
public class ExchangeOption extends AbstractAssetMonteCarloProduct {

	private final double maturity;
	private final int firstAssetIndex;
	private final int secondAssetIndex;

	/**
	 * Construct a product representing an Exchange option on two assets S^1, S^2:
	 * S^1 is the asset with index firstAssetIndex and S^2 the one with index
	 * secondAssetIndex
	 *
	 * @param maturity         The maturity T in the option payoff max(S(T)-K,0)
	 * @param firstAssetIndex  Identifier for the first asset
	 * @param secondAssetIndex Identifier for the second asset
	 */
	public ExchangeOption(double maturity, int firstAssetIndex, int secondAssetIndex) {
		this.maturity = maturity;
		this.firstAssetIndex = firstAssetIndex;
		this.secondAssetIndex = secondAssetIndex;
	}

	// overloaded constructor: firstAssetIndex = 0, secondAssetIndex = 1
	/**
	 * Construct a product representing an Exchange option on two assets S^1, S^2:
	 * identified by indices 0 and 1, respectively
	 *
	 * @param maturity The maturity T in the option payoff max(S(T)-K,0)
	 */
	public ExchangeOption(double maturity) {
		this(maturity, 0, 1);
	}

	@Override
	public RandomVariable getValue(double evaluationTime, AssetModelMonteCarloSimulationModel model)
			throws CalculationException {

		RandomVariable values = model.getRandomVariableForConstant(0);
		return values;
	}

}
