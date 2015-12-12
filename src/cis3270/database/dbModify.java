package cis3270.database;

import java.sql.*;

public interface dbModify {
	
	/* This interface is for administrator to add, delete, and update flight. 
	 * This can also be used to add, delete, or update customer when registering */
	
	public abstract Connection initializeDB() 
			throws SQLException, ClassNotFoundException;
	
	public abstract void add()
			throws SQLException, ClassNotFoundException;
	
	public abstract void delete()
			throws SQLException, ClassNotFoundException;
	
	public abstract void update()
			throws SQLException, ClassNotFoundException;
	
}
