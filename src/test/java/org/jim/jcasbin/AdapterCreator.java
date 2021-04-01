package org.jim.jcasbin;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * Created with IntelliJ IDEA.
 *
 * @author JimZhang
 * @since 2021/3/24
 * Description:
 */
public interface AdapterCreator {
    MongoAdapter create() throws Exception;

    class MongoAdapterCreator implements AdapterCreator,AutoCloseable {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:8081/casbin");
        @Override
        public MongoAdapter create() {

            return new MongoAdapter(mongoClient, "casbin");
        }

        @Override
        public void close() {
            mongoClient.close();
        }
    }
}
