package org.sakaiproject.triples.api;

import java.util.Collection;

import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.exception.IdUsedException;
import org.sakaiproject.exception.InconsistentException;

public interface TripleStoreService 
{
	public TripleStore createTripleStore(String storeId) throws IdUsedException;
	public TripleStore getTripleStore(String storeId) throws IdUnusedException;
	
	public void removeTripleStore(String storeId) throws IdUnusedException;
	
	public void add(TripleCollection toAdd, String storeId) throws IdUsedException;
	public void remove(TripleCollection toRemove, String storeId) throws IdUsedException;

	public TripleCollection search(String query, String format, String storeId) throws IdUnusedException, InconsistentException;

	/**
	 * Access a collection (String) of id's for TripleStore's defined on this system
	 */
	public Collection listTripleStores();
	
	/**
	 * Access a collection (TripleStore) of TripleStore's defined on this system
	 */
	public Collection getTripleStores();
}
