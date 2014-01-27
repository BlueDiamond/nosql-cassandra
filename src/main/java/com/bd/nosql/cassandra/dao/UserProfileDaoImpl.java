package com.bd.nosql.cassandra.dao;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.bd.nosql.cassandra.db.CassandraAstyanaxContext;
import com.netflix.astyanax.Keyspace;
import com.netflix.astyanax.connectionpool.OperationResult;
import com.netflix.astyanax.connectionpool.exceptions.ConnectionException;
import com.netflix.astyanax.model.CqlResult;
import com.netflix.astyanax.model.Row;

@Resource
public class UserProfileDaoImpl implements UserProfileDao {

	@Autowired
	private CassandraAstyanaxContext cassandraAstyanaxContext;

	public void getuserProfileList() {

//		try {
//			Keyspace keyspace = cassandraAstyanaxContext.getKeyspace();
//			OperationResult<CqlResult<String, String>> result = keyspace.prepareQuery("CF_STANDARD1").withCql("SELECT * FROM Standard1;").execute();
//			for (Row<String, String> row : result.getResult().getRows()) {
//			}
//		} catch (ConnectionException e) {
//
//		}

	}

	public int getUserProfileCount() {

//		try {
//			Keyspace keyspace = cassandraAstyanaxContext.getKeyspace();
//			OperationResult<CqlResult<String, String>> result = keyspace.prepareQuery("CF_STANDARD1").withCql("SELECT count(*) FROM Standard1 where KEY='A';").execute();
//
//			System.out.println("CQL Count: " + result.getResult().getNumber());
//		} catch (ConnectionException e) {
//
//		}
		return 0;

	}

}
