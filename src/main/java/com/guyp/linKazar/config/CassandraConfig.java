package com.guyp.linKazar.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.net.URISyntaxException;

@Configuration
public class CassandraConfig {


    @Bean("cassandraSession")
    public CqlSession getCassandraSession() throws URISyntaxException {
        CqlSession cqlSession  = CqlSession.builder().addContactPoint(new InetSocketAddress("cassandra", 9042))
                                                     .withLocalDatacenter("datacenter1")
                                                     .build();

        Boolean isKeyspaceNotExists = cqlSession.execute("SELECT keyspace_name FROM system_schema.keyspaces WHERE keyspace_name='tiny_keyspace';").all().isEmpty();
        if(isKeyspaceNotExists) {
            cqlSession.execute("CREATE KEYSPACE tiny_keyspace WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};");
        }

        cqlSession.close();

        return CqlSession.builder()
                .addContactPoint(new InetSocketAddress("cassandra", 9042))
                .withKeyspace("tiny_keyspace")
                .withLocalDatacenter("datacenter1")
                .build();
    }

}
