package br.com.calixto.math;

import org.springframework.stereotype.Service;

@Service
public class SimpleMath {

	public Double sum(Double numberOne, Double numberTwo) throws Exception {
		return (numberOne) + (numberTwo);
	}

	public Double sub(Double numberOne, Double numberTwo) throws Exception {
		return (numberOne) - (numberTwo);
	}

	public Double mul(Double numberOne, Double numberTwo) throws Exception {
		return (numberOne) * (numberTwo);
	}

	public Double div(Double numberOne, Double numberTwo) throws Exception {
		return (numberOne) / (numberTwo);
	}

	public Double avg(Double numberOne, Double numberTwo) throws Exception {
		return ((numberOne) + (numberTwo)) / 2.0;
	}

	public Double pow(Double numberOne, Double numberTwo) throws Exception {
		return Math.pow((numberOne), (numberTwo));
	}	
}
