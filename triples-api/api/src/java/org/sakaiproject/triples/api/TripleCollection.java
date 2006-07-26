/**
 * 
 */
package org.sakaiproject.triples.api;

import java.net.URI;
import java.util.Date;
import java.util.Iterator;

/**
 *
 */
public interface TripleCollection 
{
	public void add(Triple triple);
	public void add(URI subject, URI predicate, URI object);
	public void add(URI subject, URI predicate, String literal);
	public void add(URI subject, URI predicate, Date literal);
	public void add(URI subject, URI predicate, Integer literal);
	public void add(URI subject, URI predicate, Double literal);
	
	public TripleCollection search(Triple searchSpec);
	public TripleCollection search(TripleCollection searchSpec);
	
	public Iterator iterator();
	
}
