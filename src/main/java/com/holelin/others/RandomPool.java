package com.holelin.others;

import java.util.HashMap;

/**
 * ClassName: RandomPool
 * 设计RandomPool
 * -- 设计一种结构,在该结构中如下三个功能:
 * -- insert(key) : 将某个key加入该结构,做到不重复加入
 * -- delete(key) : 将原本在结构中的某个key移除
 * -- getRandom() : 等概率随机返回结构中的任何一个key
 * 要求:
 * insert,delete,getRandom方法的时间复杂度都是O(1)
 * 思路: 使用两个HashMap,一个Map存放方式为key-value,一个Map存放方式为value-key
 * -- insert(key) : 完成不重复功能--在添加之前检查一下Map中是否存在过该key
 * -- delete(key) : 在当前key存在情况下,将最后一条记录的key和value覆盖到待删除的位置,再删除最后一条记录
 * -- getRandom() : int randomIndex = (int) (Math.random() * this.size);
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/25
 */

public class RandomPool<K> {
	private HashMap<K, Integer> keyIndexMap;
	private HashMap<Integer, K> indexKeyMap;
	private int size;

	public RandomPool() {
		this.keyIndexMap = new HashMap<>();
		this.indexKeyMap = new HashMap<>();
		this.size = 0;
	}

	public void insert(K key) {
		if (!this.keyIndexMap.containsKey(key)) {
			this.keyIndexMap.put(key, this.size);
			this.indexKeyMap.put(this.size++, key);
		}
	}

	public void delete(K key) {
		if (this.keyIndexMap.containsKey(key)) {
			int deleteValue = this.keyIndexMap.get(key);
			// lastIndex --> Map中最后一条记录的索引
			int lastIndex = --this.size;
			// 获取最后一条记录的key
			K lastKey = this.indexKeyMap.get(lastIndex);
			// 把最后一条记录放到删除位置
			this.keyIndexMap.put(lastKey, deleteValue);
			this.indexKeyMap.put(deleteValue, lastKey);
			// 移除两个Map中的待删除key
			this.keyIndexMap.remove(lastKey);
			this.indexKeyMap.remove(lastIndex);
		}
	}

	public K getRandom() {
		if (this.size == 0) {
			return null;
		}
		int randomIndex = (int) (Math.random() * this.size);
		return this.indexKeyMap.get(randomIndex);
	}

}
