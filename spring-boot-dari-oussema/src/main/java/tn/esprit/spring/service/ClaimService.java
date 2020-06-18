package tn.esprit.spring.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import tn.esprit.spring.entities.Discount;
//import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.interfaces.IClaimService;
import tn.esprit.spring.entity.Role;
//import tn.esprit.spring.repository.DiscountRepository;
import tn.esprit.spring.repository.ClaimRepository;
//import tn.esprit.spring.entities.Discount;
//import tn.esprit.spring.entities.Product;
//import tn.esprit.spring.repository.DiscountRepository;
//import tn.esprit.spring.repository.ProductRepository;
@Component

public class ClaimService implements IClaimService {
	@Autowired 
	ClaimRepository claimRepository;
	/*@Autowired
	DiscountRepository discountRepository;*/

	@Override
	public Claim addClaim(Claim claim) {
		return claimRepository.save(claim);
	}

	@Override
	public List<Claim> getAllClaims() {
		return (List<Claim>) claimRepository.findAll();
	}

	@Override
	public void deleteClaim(long id) {
		claimRepository.deleteById(id);
	}

	@Override
	public Claim updateClaim(Claim product) {
		/*Optional<Discount> d=null;
		if(productRepository.existsById(product.getIdProduct())) {
			if(product.getDiscount()!=null&&discountRepository.existsById(product.getDiscount().getId()))
				d=discountRepository.findById(product.getDiscount().getId());
				product.setDiscount(d.get());
		return productRepository.save(product);}*/
		return null;
	}
	@Override
	public Claim getClaimById(Long idClaim){
		return claimRepository.findById(idClaim).get();
	} 
	@Override
	public void updateClaimById(Claim claim, Long idClaim) {
		claimRepository.updateClaimById(  claim.getDescription()
										,claim.getStatus()
										,claim.getType()
										, idClaim);
	}


	@Override
	public void deleteClaim1(Long idClaim) {
		claimRepository.deleteById(idClaim);
	}
}
