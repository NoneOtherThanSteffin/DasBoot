package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Shipwreck;
import com.example.repository.ShipwreckRepository;
import com.example.repository.ShipwreckRepositoryImpl;

@RestController
@RequestMapping("/api/v1/")
public class ShipwreckController {

	/*
	 * @Autowired private ShipwreckRepository mShipwreckRepository;
	 */
	@Autowired
	private ShipwreckRepository mShipwreckRepositoryImpl;

	/*
	 * @RequestMapping(value = "shipwrecks", method = RequestMethod.GET) public
	 * List<Shipwreck> list() {
	 * 
	 * return ShipwreckRepository.findAll(); }
	 */

	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		// return ShipwreckRepository.saveAndFlush(shipwreck);
		return mShipwreckRepositoryImpl.saveShipwreck(shipwreck);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id) {
		// return ShipwreckRepository.findOne(id);
		return mShipwreckRepositoryImpl.findShipwreck(id);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
		/*
		 * Shipwreck existingShipwreck = ShipwreckRepository.findOne(id);
		 * BeanUtils.copyProperties(shipwreck, existingShipwreck); return
		 * ShipwreckRepository.saveAndFlush(existingShipwreck);
		 */
		return mShipwreckRepositoryImpl.updateShipwreck(shipwreck);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id) {
		/*
		 * Shipwreck existingShipwreck = ShipwreckRepository.findOne(id);
		 * ShipwreckRepository.delete(existingShipwreck); return
		 * existingShipwreck;
		 */
		return mShipwreckRepositoryImpl.deleteShipwreck(id);
	}

	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
	public List<Shipwreck> list() {
		return mShipwreckRepositoryImpl.findAllShipwreck();
	}

}
