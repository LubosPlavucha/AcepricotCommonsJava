package com.lubosplavucha.commonutils.structures;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.Validate;

/**
 * Constructs pair of object where order of 2 elements doens't matter, i.e. comparing 2 pairs of this class with same elements, 
 * but different order will be considered equal.
 * 
 * @author lubos.plavucha
 *
 * @param <T>
 */
public class UnorderedPair<T> implements Comparable {
	
	
	private Set<T> elements;	// used for purposes of comparison if order doesn't matter
	private T leftObject;
	private T rightObject;
	
	
	public UnorderedPair(T leftObject, T rightObject) {
		super();
		Validate.notNull(leftObject);
		Validate.notNull(rightObject);
		this.leftObject = leftObject;
		this.rightObject = rightObject;
		elements = new HashSet<T>();
        elements.add(this.leftObject);
        elements.add(this.rightObject);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		return elements.equals(((UnorderedPair<?>) obj).elements);
	}


	@Override
	public int hashCode() {
		return elements.hashCode();
	}
	

	@Override
	public String toString() {
		return "(" + leftObject + "," + rightObject + ")";
    }


	@Override
	public int compareTo(Object object) {
		if(! this.equals(object))
			return 1;
		return 0;
	}

	public T getLeftObject() {
		return leftObject;
	}


	public T getRightObject() {
		return rightObject;
	}

}
