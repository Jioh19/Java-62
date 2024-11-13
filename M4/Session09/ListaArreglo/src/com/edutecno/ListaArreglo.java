package com.edutecno;

import java.util.Arrays;

public class ListaArreglo<T> {
	
	private T[] arr;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ListaArreglo() {
		super();
		this.arr = (T[]) new Object[10];
		this.size = 0;
	}
	
	private void crecer() {
		if(size == arr.length) {
			@SuppressWarnings("unchecked")
			T[] nuevoArr = (T[]) new Object[(int) (arr.length * 1.5)];
			System.arraycopy(arr, 0, nuevoArr, 0, size);
			arr = nuevoArr;
 		}
	}
	
	public void add(T elemento) {
		crecer();
		arr[size++] = elemento;
	}
	
	public int size() {
		return size;
	}
	
	public T get(int index) {	
		return arr[index];
	}
	
	public void remove(int index) {
		System.arraycopy(arr, index + 1, arr, index, size - index - 1);
		arr[--size] = null;
	}

	@Override
	public String toString() {
		return "ListaArreglo [arr=" + Arrays.toString(arr) + ", size=" + size + "]";
	}
	

	
}
