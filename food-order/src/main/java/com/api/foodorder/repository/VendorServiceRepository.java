package com.api.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.foodorder.entity.Vendor;

@Repository
public interface VendorServiceRepository extends JpaRepository<Vendor, Integer>{

	Vendor findByVendorName(String name);

	
}
