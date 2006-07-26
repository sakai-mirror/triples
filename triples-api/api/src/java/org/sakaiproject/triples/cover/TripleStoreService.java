package org.sakaiproject.triples.cover;

import org.sakaiproject.component.cover.ComponentManager;

public class TripleStoreService 
{

	private static org.sakaiproject.triples.api.TripleStoreService m_instance;

	/**
	 * Access the component instance: special cover only method.
	 * 
	 * @return the component instance.
	 */
	public static org.sakaiproject.triples.api.TripleStoreService getInstance()
	{
		if (ComponentManager.CACHE_COMPONENTS)
		{
			if (m_instance == null)
				m_instance = (org.sakaiproject.triples.api.TripleStoreService) ComponentManager
						.get(org.sakaiproject.triples.api.TripleStoreService.class);
			return m_instance;
		}
		else
		{
			return (org.sakaiproject.triples.api.TripleStoreService) ComponentManager
					.get(org.sakaiproject.triples.api.TripleStoreService.class);
		}
	}

	public static void add(org.sakaiproject.triples.api.TripleCollection triples, String storeId)
			throws org.sakaiproject.exception.IdUsedException 
	{
		org.sakaiproject.triples.api.TripleStoreService service = getInstance();
		if (service == null) return;

		service.add(triples, storeId);
	}

	public static org.sakaiproject.triples.api.TripleStore createTripleStore(String storeId) throws org.sakaiproject.exception.IdUsedException 
	{
		org.sakaiproject.triples.api.TripleStoreService service = getInstance();
		if (service == null) return null;

		return service.createTripleStore(storeId);
	}

	public static org.sakaiproject.triples.api.TripleStore getTripleStore(String storeId) throws org.sakaiproject.exception.IdUnusedException 
	{
		org.sakaiproject.triples.api.TripleStoreService service = getInstance();
		if (service == null) return null;

		return service.getTripleStore(storeId);
	}

	public static java.util.Collection getTripleStores() 
	{
		org.sakaiproject.triples.api.TripleStoreService service = getInstance();
		if (service == null) return null;

		return service.getTripleStores();
	}

	public static java.util.Collection listTripleStores() 
	{
		org.sakaiproject.triples.api.TripleStoreService service = getInstance();
		if (service == null) return null;

		return service.listTripleStores();
	}

	public static void remove(org.sakaiproject.triples.api.TripleCollection toRemove, String storeId)
			throws org.sakaiproject.exception.IdUsedException 
	{
		org.sakaiproject.triples.api.TripleStoreService service = getInstance();
		if (service == null) return;

		service.remove(toRemove, storeId);
	}

	public static void removeTripleStore(String storeId) throws org.sakaiproject.exception.IdUnusedException 
	{
		org.sakaiproject.triples.api.TripleStoreService service = getInstance();
		if (service == null) return;

		service.removeTripleStore(storeId);
	}

	public static org.sakaiproject.triples.api.TripleCollection search(String query, String format, String storeId)
			throws org.sakaiproject.exception.IdUnusedException, org.sakaiproject.exception.InconsistentException 
	{
		org.sakaiproject.triples.api.TripleStoreService service = getInstance();
		if (service == null) return null;

		return service.search(query, format, storeId);
	}

}
