package org.sakaiproject.triples.api;

import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.exception.InconsistentException;

public interface TripleStore 
{
	public void init();
	public void destroy();
	
	public String getId();
	
	public void add(TripleCollection toAdd);
	public void remove(TripleCollection toRemove);
	
	public TripleCollection search(String query, String format) throws IdUnusedException, InconsistentException;
	
	// public TripleCollection search(Triple searchSpec);
	// public TripleCollection search(TripleCollection searchSpec);
}
