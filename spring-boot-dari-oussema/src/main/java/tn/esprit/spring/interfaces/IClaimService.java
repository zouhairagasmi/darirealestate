package tn.esprit.spring.interfaces;

import java.util.List;

import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.User;

public interface IClaimService {
	Claim addClaim(Claim claim);
	List<Claim> getAllClaims();
	void deleteClaim(long id) ;
	Claim updateClaim(Claim claim);
	public void updateClaimById(Claim claim, Long idClaim);
	public Claim getClaimById(Long idClaim);
	public void deleteClaim1(Long  idClaim) ;
}
