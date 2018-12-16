package cust.bill.mgmt.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;

/**
 * Perform Cassandra DB connection using Bean from 'cassandra.properties'.
 * @author BHASKAR
 * @version 1.0.0
 */
@Configuration
@PropertySource(value = { "classpath:cassandra.properties" })
public class CassandraConnectionUtility {
    /**
     * Constant String for Keyspace
     */
    private static final String KEYSPACE = "cassandra.keyspace";
    /**
     * Constant String for ContactPoints
     */
    private static final String CONTACTPOINTS = "cassandra.contactpoints";
    /**
     * Constant String for Port 
     */
    private static final String PORT = "cassandra.port";
    
    /**
     * Environment Object 
     */
    @Autowired
    private Environment environment;

    /**
	 * Default Constructor
	 */
    public CassandraConnectionUtility() {}
    
    /**
	 * Get Cassandra KeySpace Name
	 * @return String
	 * 		KeySpace Name
	 * @since 1.0.0
	 */
    private String getKeyspaceName() {
        return environment.getProperty(KEYSPACE);       
    }
    
    /**
	 * Get Cassandra CONTACTPOINTS
	 * @return String
	 * 		CONTACTPOINTS
	 * @since 1.0.0
	 */
    private String getContactPoints() {
        return environment
                .getProperty(CONTACTPOINTS);        
    }
    
    /**
	 * Get Cassandra Port No
	 * @return int
	 * 		Port No
	 * @since 1.0.0
	 */
    private int getPortNumber() {
        return Integer.parseInt(environment
                .getProperty(PORT));        
    }

    /**
	 * Get CassandraClusterFactoryBean Bean
	 * @return CassandraClusterFactoryBean
	 * @since 1.0.0
	 */
    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(getContactPoints());
        cluster.setPort(getPortNumber());
        return cluster;
    }

    /**
	 * Get CassandraMappingContext Bean
	 * @return CassandraMappingContext
	 * @since 1.0.0
	 */
    @Bean
    public CassandraMappingContext mappingContext() {
        return new BasicCassandraMappingContext();
    }

    /**
	 * Get CassandraConverter Bean
	 * @return CassandraConverter
	 * @since 1.0.0
	 */
    @Bean
    public CassandraConverter converter() {
        return new MappingCassandraConverter(mappingContext());
    }

    /**
	 * Get CassandraSessionFactoryBean Bean
	 * @return CassandraSessionFactoryBean
	 * @since 1.0.0
	 */
    @Bean
    public CassandraSessionFactoryBean session() throws Exception {
        CassandraSessionFactoryBean cassandraSessionFactoryBean = new CassandraSessionFactoryBean();
        cassandraSessionFactoryBean.setCluster(cluster().getObject());
        cassandraSessionFactoryBean.setKeyspaceName(getKeyspaceName());
        cassandraSessionFactoryBean.setConverter(converter());
        cassandraSessionFactoryBean.setSchemaAction(SchemaAction.NONE);
        return cassandraSessionFactoryBean;
    }

    /**
	 * Get CassandraOperations Bean
	 * @return CassandraOperations
	 * @since 1.0.0
	 */
     @Bean
    public CassandraOperations cassandraTemplate() throws Exception {
        return new CassandraTemplate(session().getObject());
    }
     
}