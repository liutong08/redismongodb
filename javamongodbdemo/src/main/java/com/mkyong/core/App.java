package com.mkyong.core;

import java.net.UnknownHostException;
import java.util.Date;

import com.mongodb.*;

/**
 * Java + MongoDB Hello world Example
 * 
 */
public class App {
	public static void main(String[] args) {

		try {

			/**** Connect to MongoDB ****/
			// Since 2.10.0, uses MongoClient
			MongoClient mongo = new MongoClient("localhost", 27017);

			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("testdb");

			/**** Get collection / table from 'testdb' ****/
			// if collection doesn't exists, MongoDB will create it for you
			DBCollection table = db.getCollection("user");

			/**** Insert ****/
			// create a document to store key and value
//			for(int i=0;i<10;i++) {
//				BasicDBObject document = new BasicDBObject();
//				document.put("name", "nameTest"+i);
//				document.put("age", 23+i);
//				document.put("createdDate", new Date());
//				table.insert(document);
//			}

			BasicDBObject searchQuery1 = new BasicDBObject();
			searchQuery1.put("age", new BasicDBObject("$gte",25).append("$lte",30));
			DBObject dbObject=new BasicDBObject();
			dbObject.put("age",-1);
			DBCursor cursor1 = table.find(searchQuery1).limit(3).skip(3).sort(dbObject);
			while (cursor1.hasNext()) {
				System.out.println(cursor1.next());
			}
//
//			/**** Find and display ****/
//			BasicDBObject searchQuery = new BasicDBObject();
//			searchQuery.put("name", "nameTest");
//
//			DBCursor cursor = table.find(searchQuery);
//
//			while (cursor.hasNext()) {
//				System.out.println(cursor.next());
//			}
//
//			/**** Update ****/
//			// search document where name="mkyong" and update it with new values
//			BasicDBObject query = new BasicDBObject();
//			query.put("name", "nameTest");
//
//			BasicDBObject newDocument = new BasicDBObject();
//			newDocument.put("name", "nameTest-updated");
//
//			BasicDBObject updateObj = new BasicDBObject();
//			updateObj.put("$set", newDocument);
//
//			table.update(query, updateObj);
//
//			/**** Find and display ****/
//			BasicDBObject searchQuery2
//				= new BasicDBObject().append("name", "nameTest-updated");
//
//			DBCursor cursor2 = table.find(searchQuery2);
//
//			while (cursor2.hasNext()) {
//				System.out.println(cursor2.next());
//			}
//
//			/**** Done ****/
//			System.out.println("Done");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
}
