package br.com.calixto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.calixto.exception.UnsuportadedMathOperationException;
import br.com.calixto.math.SimpleMath;
import br.com.calixto.request.converters.NumberConverter;

@RestController
public class PersonController {
	
	@Autowired
	private SimpleMath math;
	
	@Autowired
	private NumberConverter numberConverter;

	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
			throw new UnsuportadedMathOperationException("Please set a numeric value!");
		}

		return math.sum(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
			throw new UnsuportadedMathOperationException("Please set a numeric value!");
		}

		return math.sub(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value="/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mul(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
			throw new UnsuportadedMathOperationException("Please set a numeric value!");
		}

		return math.mul(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
			throw new UnsuportadedMathOperationException("Please set a numeric value!");
		}
		
		if (numberConverter.convertToDouble(numberTwo) == 0)
			throw new UnsuportadedMathOperationException("Invalid division by ZERO!");

		return math.div(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value="/avg/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double avg(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
			throw new UnsuportadedMathOperationException("Please set a numeric value!");
		}

		return math.avg(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));		
	}

	@RequestMapping(value="/pow/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double pow(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
			throw new UnsuportadedMathOperationException("Please set a numeric value!");
		}
		 
		return math.pow(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
	}	
}