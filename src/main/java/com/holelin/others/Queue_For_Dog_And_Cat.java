package com.holelin.others;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Random;

/**
 * ClassName: Queue_for_dog_and_cat
 * 猫狗队列问题
 * 要求
 * -- 用户可以调用add方法将cat类或dog类的实例放入队列中；
 * -- 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
 * -- 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
 * -- 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
 * -- 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
 * -- 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
 * -- 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例
 *
 * @author HoleLin
 * @version 1.0
 * @date 2019/2/25
 */
class Pet {
	private String type;

	public Pet(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}

class Dog extends Pet {

	public Dog() {
		super("Dog");
	}

}

class Cat extends Pet {
	public Cat() {
		super("Cat");
	}
}

/**
 * 封装宠物类,添加一个index来标记该宠物是第几个进入队列的
 */
class PetEnterQueue {
	private Pet pet;
	private long index;

	public PetEnterQueue(Pet pet, long count) {
		this.pet = pet;
		this.index = count;
	}

	public Pet getPet() {
		return pet;
	}

	public long getIndex() {
		return index;
	}

	public String getEnterPetType() {
		return this.pet.getType();
	}
}

/**
 * 宠物队列
 */
public class Queue_For_Dog_And_Cat {
	private Queue<PetEnterQueue> dogQ;
	private Queue<PetEnterQueue> catQ;
	private long index;
	private static String DOG = "Dog";
	private static String CAT = "Cat";

	public Queue_For_Dog_And_Cat() {
		this.dogQ = new LinkedList<>();
		this.catQ = new LinkedList<>();
		this.index = 0;
	}

	public void add(Pet pet) {

		if (pet.getType().equals(DOG)) {
			// 当宠物类型为Dog时,在dogQ中添加元素
			// this.index++ -- 用来记录当前pet是第几个进入队列的
			this.dogQ.add(new PetEnterQueue(pet, this.index++));
		} else if (pet.getType().equals(CAT)) {
			// 当宠物类型为Cat时,在catQ中添加元素
			// this.index++ -- 用来记录当前pet是第几个进入队列的
			this.catQ.add(new PetEnterQueue(pet, this.index++));
		} else {
			throw new RuntimeException("err, not dog or cat");
		}
	}

	public Dog pollDog() {
		// 当狗队列不为空
		// 弹出对首狗
		if (!this.isDogQueueEmpty()) {
			return (Dog) Objects.requireNonNull(this.dogQ.poll()).getPet();
		} else {
			throw new RuntimeException("Dog Queue is empty");
		}
	}

	public Cat pollCat() {
		// 当猫队列不为空
		// 弹出对首猫
		if (!this.isCatQueueEmpty()) {
			return (Cat) Objects.requireNonNull(this.catQ.poll()).getPet();
		} else {
			throw new RuntimeException("Cat Queue is empty");
		}
	}

	public Pet pollAll() {

		if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
			// 当猫狗队列都不为空时,比较猫队列和狗队列中对首宠物的index的值,谁的index小则谁先出队列
			if (this.dogQ.peek().getIndex() < this.catQ.peek().getIndex()) {
				return Objects.requireNonNull(this.dogQ.poll()).getPet();
			} else {
				return Objects.requireNonNull(this.catQ.poll()).getPet();
			}
		} else if (!this.dogQ.isEmpty()) {
			// 若猫队列为空,直接弹出狗队列对首
			return this.dogQ.poll().getPet();
		} else if (!this.catQ.isEmpty()) {
			// 若狗队列为空,直接弹出猫队列对首
			return this.catQ.poll().getPet();
		} else {
			throw new RuntimeException("err,queue is empty");
		}

	}

	private boolean isCatQueueEmpty() {
		return this.catQ.isEmpty();
	}

	private boolean isDogQueueEmpty() {
		return this.dogQ.isEmpty();
	}

	public static void main(String[] args) {
		int size = 10;
		Queue_For_Dog_And_Cat queue = new Queue_For_Dog_And_Cat();
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			random.nextInt(100);
			if (i % 3 == 0) {
				System.out.print("Dog" + i + "  ");

				queue.add(new Dog());
			} else {
				System.out.print("Cat" + i + "  ");
				queue.add(new Cat());
			}

		}
		System.out.println();
		for (int i = 0; i < size; i++) {
			Pet pet = queue.pollAll();
			System.out.print(pet.getType() + "  ");
		}

	}
}
