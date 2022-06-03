package br.com.calixto;

import org.springframework.expression.spel.ast.OperatorPower;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.calixto.exception.UnsuportadedMathOperationException;

@RestController
public class MathController {

	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportadedMathOperationException("Please set a numeric value!");
		}
		Double res = convertToDouble(numberOne) + convertToDouble(numberTwo); 
		return res;
	}

	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportadedMathOperationException("Please set a numeric value!");
		}
		Double res = convertToDouble(numberOne) - convertToDouble(numberTwo); 
		return res;
	}

	@RequestMapping(value="/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mul(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportadedMathOperationException("Please set a numeric value!");
		}
		Double res = convertToDouble(numberOne) * convertToDouble(numberTwo); 
		return res;
	}

	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportadedMathOperationException("Please set a numeric value!");
		}
		if (convertToDouble(numberTwo) == 0.0)
			throw new UnsuportadedMathOperationException("Invalid division by zero!");
		Double res = convertToDouble(numberOne) / convertToDouble(numberTwo); 
		return res;
	}

	@RequestMapping(value="/avg/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double avg(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportadedMathOperationException("Please set a numeric value!");
		}
		Double res = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2.0; 
		return res;
	}

	@RequestMapping(value="/pow/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double pow(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportadedMathOperationException("Please set a numeric value!");
		}
		Double res = Math.pow(convertToDouble(numberOne), convertToDouble(numberTwo)); 
		return res;
	}

	private Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");		
	}	
}