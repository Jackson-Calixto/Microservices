package br.com.calixto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.calixto.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

	Cambio findByFromAndTo(String from, String to);
}
