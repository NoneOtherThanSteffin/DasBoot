package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Shipwreck;

@Repository("mShipwreckRepositoryImpl")
public class ShipwreckRepositoryImpl implements ShipwreckRepository {
	private static final String KEY = "Shipwreck";

	private HashOperations<String, Long, Shipwreck> hashOperations;

	@Autowired
	private RedisTemplate<String, Shipwreck> redisTemplate;

	public ShipwreckRepositoryImpl() {

	}

	@PostConstruct
	public void Init() {
		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public Shipwreck saveShipwreck(Shipwreck mShipwreck) {
		hashOperations.put(KEY, mShipwreck.getId(), mShipwreck);
		return mShipwreck;
	}

	@Override
	public Shipwreck deleteShipwreck(Long id) {
		Shipwreck shipwreck = hashOperations.get(KEY, id);
		hashOperations.delete(KEY, id);
		return shipwreck;
	}

	@Override
	public Shipwreck updateShipwreck(Shipwreck mShipwreck) {
		hashOperations.put(KEY, mShipwreck.getId(), mShipwreck);
		return mShipwreck;
	}

	@Override
	public Shipwreck findShipwreck(Long id) {
		Shipwreck shipwreck = hashOperations.get(KEY, id);
		return shipwreck;
	}

	@Override
	public List<Shipwreck> findAllShipwreck() {
		List<Shipwreck> allAvailableShipwreck = new ArrayList<Shipwreck>();
		Set<Long> allShipwreckID = hashOperations.keys(KEY);
		for (long id : allShipwreckID) {
			allAvailableShipwreck.add(hashOperations.get(KEY, id));
		}
		return allAvailableShipwreck;
	}

}
