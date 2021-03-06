package com.cloume.common.utils;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder<K, V>
{
	private Map<K, V> map;
	private MapBuilder() {}
	
	private Map<K, V> getMap() {
		return map == null ? map = new HashMap<K, V>() : map;
	}
	
	public static <KEY, VALUE> MapBuilder<KEY, VALUE> begin(KEY key, VALUE value) {
		MapBuilder<KEY, VALUE> instance = new MapBuilder<KEY, VALUE>();
		instance.and(key, value);
		return instance;
	}
	
	public MapBuilder<K, V> and(K key, V value) {
		getMap().put(key, value);
		return this;
	}
	
	public Map<K, V> build() {
		return getMap();
	}
}
