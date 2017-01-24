package com.example.repository;

import java.util.List;

import com.example.model.Shipwreck;


public interface ShipwreckRepository /*
										 * extends JpaRepository<Shipwreck,
										 * Long>
										 */ {
	Shipwreck saveShipwreck(Shipwreck mShipwreck);

	Shipwreck deleteShipwreck(Long id);

	Shipwreck updateShipwreck(Shipwreck mShipwreck);

	Shipwreck findShipwreck(Long id);
	
	List<Shipwreck> findAllShipwreck();
}
