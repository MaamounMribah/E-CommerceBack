package tn.camps.tuncamps.persistence.repository.ecomerce;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.camps.tuncamps.persistence.entity.ecomerce.Allocation;
import tn.camps.tuncamps.persistence.entity.ecomerce.CartItem;

public interface AllocationRepository extends JpaRepository<Allocation, Integer> {

}
