/*******************************************************************************
 * Copyright 2015 Observational Health Data Sciences and Informatics
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.ohdsi.jCdmBuilder.cdm;

import org.ohdsi.utilities.files.Row;
import org.ohdsi.utilities.files.WriteCSVFileWithHeader;

import org.ohdsi.databases.DbType;
import org.ohdsi.databases.RichConnection;

public class FetchNullableFromServer {

	public static void main(String[] args) {
		RichConnection connection = new RichConnection("127.0.0.1", null, "root", "F1r3starter", DbType.MYSQL);
		connection.use("cdm_v4");

		WriteCSVFileWithHeader out = new WriteCSVFileWithHeader("c:/temp/NotNullableV4.csv");
		String query = "SELECT table_name,column_name,is_nullable FROM information_schema.columns WHERE table_schema = 'cdm_v4';";
		for (Row row : connection.query(query))
			out.write(row);
		out.close();

	}

}
