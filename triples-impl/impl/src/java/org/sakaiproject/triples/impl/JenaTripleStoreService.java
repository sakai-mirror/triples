package org.sakaiproject.triples.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.sakaiproject.db.api.SqlService;
import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.exception.IdUsedException;
import org.sakaiproject.exception.InconsistentException;
import org.sakaiproject.triples.api.TripleCollection;
import org.sakaiproject.triples.api.TripleStore;
import org.sakaiproject.triples.api.TripleStoreService;

import com.hp.hpl.jena.db.DBConnection;
import com.hp.hpl.jena.db.IDBConnection;
import com.hp.hpl.jena.db.ModelRDB;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.ModelMaker;
import com.hp.hpl.jena.shared.AlreadyExistsException;

public class JenaTripleStoreService implements TripleStoreService 
{
	/** Our logger. */
	private static Log M_log = LogFactory.getLog(JenaTripleStoreService.class);

	protected final static String JENA_IMPL_ID = "jena_mgr";
	protected final static String TRIPLES_MANAGER = "triples_mgr";

	/** Dependency: SqlService */
	protected SqlService m_sqlService = null;

	/**
	 * Dependency: SqlService.
	 * 
	 * @param service
	 *        The SqlService.
	 */
	public void setSqlService(SqlService service)
	{
		m_sqlService = service;
	}
	
	
	protected TripleStore m_manager = null;
	
	public void init()
	{
		//System.out.println("JenaTripleStoreService.init():  " );
		try
		{
			M_log.info("init()");
			this.m_manager = new JenaTripleStore(JENA_IMPL_ID, TRIPLES_MANAGER);
			M_log.info("init() done");
			
		}
		catch (Throwable t)
		{
			M_log.warn("init(): ", t);
		}
		//M_log.info("JenaTripleStoreService.init():  " );

	}

	public void destroy()
	{
		//System.out.println("JenaTripleStoreService.destroy():  " );
		try
		{
			M_log.info("destroy()");
		}
		catch (Throwable t)
		{
			M_log.warn("destroy(): ", t);
		}
		//M_log.info("JenaTripleStoreService.destroy():  " );

	}

	public void add(TripleCollection toAdd, String storeId)
			throws IdUsedException 
	{
		// TODO Auto-generated method stub

	}

	public TripleStore createTripleStore(String storeId) throws IdUsedException 
	{
		if(m_manager == null)
		{
			m_manager = new JenaTripleStore(JENA_IMPL_ID, TRIPLES_MANAGER);
		}
		return null;
	}

	public TripleStore getTripleStore(String storeId) throws IdUnusedException 
	{
		if(m_manager == null)
		{
			m_manager = new JenaTripleStore(JENA_IMPL_ID, TRIPLES_MANAGER);
		}
		return null;
	}

	public Collection getTripleStores() 
	{
		if(m_manager == null)
		{
			m_manager = new JenaTripleStore(JENA_IMPL_ID, TRIPLES_MANAGER);
		}
		return null;
	}

	public Collection listTripleStores() 
	{
		if(m_manager == null)
		{
			m_manager = new JenaTripleStore(JENA_IMPL_ID, TRIPLES_MANAGER);
		}
		return null;
	}

	public void remove(TripleCollection toRemove, String storeId)
			throws IdUsedException 
	{
		if(m_manager == null)
		{
			m_manager = new JenaTripleStore(JENA_IMPL_ID, TRIPLES_MANAGER);
		}

	}

	public void removeTripleStore(String storeId) throws IdUnusedException 
	{
		if(m_manager == null)
		{
			m_manager = new JenaTripleStore(JENA_IMPL_ID, TRIPLES_MANAGER);
		}

	}

	public TripleCollection search(String query, String format, String storeId)
			throws IdUnusedException, InconsistentException
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public class JenaTripleStore implements TripleStore
	{
		protected String m_storeId;
		protected String m_modelname;
		
		protected ModelRDB m_model = null; 
		
		public JenaTripleStore(String storeId, String modelname)
		{
			m_storeId = storeId;
			m_modelname = modelname;
			init();
		}
		
		public void init()
		{
			Connection conn = null;
			try 
			{
				conn = m_sqlService.borrowConnection();
				String vendor = m_sqlService.getVendor();
				M_log.info("JenaTripleStore.init() vendor == " + vendor);
				if(vendor == null)
				{
					vendor = "HSQL";
				}
				else if("hsqldb".equals(vendor))
				{
					vendor = "HSQL";
				}
				IDBConnection connection = new DBConnection(conn, vendor);
				connection.getDriver().setTableNamePrefix(m_storeId);
				
				ModelMaker maker = ModelFactory.createModelRDBMaker(connection);
				
				m_model = (ModelRDB) maker.openModel(m_modelname, false);
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				if(conn != null)
				{
					
					m_sqlService.returnConnection(conn);

				}
			}

		}

		public void destroy() 
		{
			
		}

		public void add(TripleCollection toAdd) 
		{
			// TODO Auto-generated method stub
			
		}

		public String getId() 
		{
			// TODO Auto-generated method stub
			return m_storeId;
		}

		public void remove(TripleCollection toRemove) 
		{
			// TODO Auto-generated method stub
			
		}

		public TripleCollection search(String query, String format) throws IdUnusedException, InconsistentException 
		{
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * @return the storeId
		 */
		public String getStoreId() 
		{
			return m_storeId;
		}

		/**
		 * @param storeId the storeId to set
		 */
		public void setStoreId(String storeId) 
		{
			this.m_storeId = storeId;
		}
		
	}

}
