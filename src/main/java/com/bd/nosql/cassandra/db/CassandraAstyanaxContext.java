package com.bd.nosql.cassandra.db;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.astyanax.AstyanaxContext;
import com.netflix.astyanax.Keyspace;
import com.netflix.astyanax.connectionpool.NodeDiscoveryType;
import com.netflix.astyanax.connectionpool.impl.ConnectionPoolConfigurationImpl;
import com.netflix.astyanax.connectionpool.impl.CountingConnectionPoolMonitor;
import com.netflix.astyanax.impl.AstyanaxConfigurationImpl;
import com.netflix.astyanax.model.ColumnFamily;
import com.netflix.astyanax.serializers.IntegerSerializer;
import com.netflix.astyanax.serializers.StringSerializer;
import com.netflix.astyanax.thrift.ThriftFamilyFactory;

@Resource
public class CassandraAstyanaxContext {

	private static final Logger logger = LoggerFactory.getLogger(CassandraAstyanaxContext.class);

	private AstyanaxContext<Keyspace> context;
	// private Keyspace keyspace;
	private ColumnFamily<Integer, String> USER_PROFILE_CF;
	private static final String USER_PROFILE_CF_NAME = "users_tbl";

	public Keyspace getKeyspace() {

		AstyanaxContext<Keyspace> context = new AstyanaxContext.Builder().forCluster("BlueDiamondCassandraCluster").forKeyspace("bdcdb")
				.withAstyanaxConfiguration(new AstyanaxConfigurationImpl().setCqlVersion("3.0.0").setTargetCassandraVersion("2.0.4").setDiscoveryType(NodeDiscoveryType.RING_DESCRIBE))
				.withConnectionPoolConfiguration(new ConnectionPoolConfigurationImpl("bdcdbConnectionPool").setPort(9160).setMaxConnsPerHost(1).setSeeds("192.168.1.102:9160"))
				.withConnectionPoolMonitor(new CountingConnectionPoolMonitor()).buildKeyspace(ThriftFamilyFactory.getInstance());

		context.start();

		Keyspace keyspace = context.getEntity();

		return keyspace;

	}

	public ColumnFamily<Integer, String> getUserProfileColumnFamily() {
		USER_PROFILE_CF = ColumnFamily.newColumnFamily(USER_PROFILE_CF_NAME, IntegerSerializer.get(), StringSerializer.get());
		return USER_PROFILE_CF;
	}
}
