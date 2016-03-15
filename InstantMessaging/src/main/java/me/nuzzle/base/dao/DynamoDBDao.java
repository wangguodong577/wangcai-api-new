package me.nuzzle.base.dao;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import me.nuzzle.base.common.Constants;

/**
 * DESCRIPTION:DynamoDB
 *
 * @author:Jimmy.zhang
 */
public class DynamoDBDao {

    private static final Region usWest2 = Region.getRegion(Regions.US_WEST_2);

    private static final AWSCredentials credentials = new BasicAWSCredentials(Constants.ACCESS_KEY, Constants.SECRET_KEY);

    private static AmazonDynamoDBClient client = new AmazonDynamoDBClient(credentials);

    private static DynamoDB dynamoDB = null;

    private static DynamoDBMapper dynamoDBMapper = null;

    static {
        client.setRegion(usWest2);
        dynamoDBMapper = new DynamoDBMapper(client);
        dynamoDB = new DynamoDB(client);
    }

    protected DynamoDB getDB() {
        return dynamoDB;
    }

    protected Table getTable(String tableName) {
        return getDB().getTable(tableName);
    }

}
