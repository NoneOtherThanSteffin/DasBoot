package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.model.Shipwreck;

import redis.clients.jedis.Jedis;

@Configuration
public class PersistenceConfiguration {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		return jedisConnectionFactory;
	}

	@Bean
	public Jedis jedisClient(JedisConnectionFactory jedisConnectionFactory) {
		return (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
	}

	@Bean
	public RedisTemplate<String, Shipwreck> redisTemplate() {
		final RedisTemplate<String, Shipwreck> template = new RedisTemplate<String, Shipwreck>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

}
