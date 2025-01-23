//Program to demonstrate Database MetaData and ResultSet Metadata
package com.tnsif.daytwentyfour.client;

import com.tnsif.daytwentyfour.metadata.DBMetadata;

public class MetaDataDemo {

	public static void main(String[] args) {
		DBMetadata.showDatabaseMetataData();
		DBMetadata.showRSMetadata();

	}

}
