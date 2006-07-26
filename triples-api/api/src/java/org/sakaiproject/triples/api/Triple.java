package org.sakaiproject.triples.api;

import java.net.URI;
import java.util.Date;

public interface Triple 
{
	public URI getSubject();
	public void setSubject(URI subj);
	
	public URI getPredicate();
	public void setPredicate(URI pred);
	
	public URI getObject();
	public void setObject(URI obj);
	
	public String getStringLiteral();
	public void setStringLiteral(String literal);
	
	public Date getDateLiteral();
	public void setDateLiteral(Date literal);
	
	public Integer getIntegerLiteral();
	public void setIntegerLiteral(Integer literal);
	
	public Double getDoubleLiteral();
	public void setDoubleLiteral(Double literal);

}
