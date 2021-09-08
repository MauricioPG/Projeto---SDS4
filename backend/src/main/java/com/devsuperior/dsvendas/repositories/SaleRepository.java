package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository  extends JpaRepository<Sale, Long>{
	
	
	// o nome completo para que seja criado a lista agrupada do tipo que estou buscando mas
	// tem que ser com todo o caminho do pacote
	// e tem que jogar o construtor
	// obj e o apelido de cada objeto Sale
	// obj.seller por causa do campo seller do Sale
	// SUM é a opercao escalar (SUM, COUNT...
	// FROM Sale -> o Sale é o nome da classe
	
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.seller, SUM (obj.amount)) " 
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	
	// no SUM, tem que ser o nome igual do atributo em Sale. No exemplo anterior tambem (amount)
	// aqui vai ser o visited e o deals
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM (obj.visited), SUM(obj.deals)) " 
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();

}
