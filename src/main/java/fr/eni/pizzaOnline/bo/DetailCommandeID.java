package fr.eni.pizzaOnline.bo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class DetailCommandeID implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long commandeId;
	private Long produitId;
	
	@Override
	public int hashCode() {
		return Objects.hash(commandeId, produitId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailCommandeID other = (DetailCommandeID) obj;
		return Objects.equals(commandeId, other.commandeId) && Objects.equals(produitId, other.produitId);
	}
	
	
	
}
