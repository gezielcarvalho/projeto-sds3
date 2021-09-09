package info.gezielcarvalho.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.gezielcarvalho.dsvendas.dto.SaleDTO;
import info.gezielcarvalho.dsvendas.dto.SaleSuccessDTO;
import info.gezielcarvalho.dsvendas.dto.SaleSumDTO;
import info.gezielcarvalho.dsvendas.entities.Sale;
import info.gezielcarvalho.dsvendas.repositories.SaleRepository;
import info.gezielcarvalho.dsvendas.repositories.SellerRepository;
@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}	

}
