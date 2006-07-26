package org.sakaiproject.triples.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.exception.IdUsedException;
import org.sakaiproject.exception.InconsistentException;
import org.sakaiproject.triples.api.TripleCollection;
import org.sakaiproject.triples.api.TripleStore;
import org.sakaiproject.triples.api.TripleStoreService;

public class BaseTripleStoreService 
	implements TripleStoreService
{
	/** Our logger. */
	private static Log M_log = LogFactory.getLog(JenaTripleStoreService.class);

	public void init()
	{
		M_log.info("\n\n\n==================================================\n\ninit()\n\n");
	}
	
	public void destroy()
	{
		M_log.info("destroy()");
	}
	
	public TripleStore createTripleStore(String storeId) throws IdUsedException
	{
		return null;
	}
	
	public TripleStore getTripleStore(String storeId) throws IdUnusedException
	{
		return null;
	}
	
	public void removeTripleStore(String storeId) throws IdUnusedException
	{
		
	}
	
	public void add(TripleCollection toAdd, String storeId) throws IdUsedException
	{
		
	}
	
	public void remove(TripleCollection toRemove, String storeId) throws IdUsedException
	{
		
	}

	public TripleCollection search(String query, String format, String storeId) throws IdUnusedException, InconsistentException
	{
		return null;
	}

	/**
	 * Access a collection (String) of id's for TripleStore's defined on this system
	 */
	public Collection listTripleStores()
	{
		return null;
	}
	
	/**
	 * Access a collection (TripleStore) of TripleStore's defined on this system
	 */
	public Collection getTripleStores()
	{
		return null;
	}
}
