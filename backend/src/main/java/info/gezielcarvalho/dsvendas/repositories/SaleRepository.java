package info.gezielcarvalho.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.gezielcarvalho.dsvendas.dto.SaleSuccessDTO;
import info.gezielcarvalho.dsvendas.dto.SaleSumDTO;
import info.gezielcarvalho.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{	
	@Query("SELECT new info.gezielcarvalho.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();

	@Query("SELECT new info.gezielcarvalho.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals )) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();

}

