package info.gezielcarvalho.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import info.gezielcarvalho.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
