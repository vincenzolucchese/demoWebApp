package com.vince.boot.demo.webapp;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.junit4.SpringRunner;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoWebAppApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(DemoWebAppApplicationTests.class);

	public static final String PATH_SCRIPT = "docs/DataDictionay/ddl_dml/";
	private static final String SERVER_NAME = "localhost";
	private static final String MYSQL_USER_ROOT = "root";

//	@Autowired
//	public DataSource dataSource;

	@Test
	public void contextLoads() {
	}

	@Test
	public void loadScriptDDL_DML() throws SQLException {
		logger.debug("...STARTING SCRIPT DDL DML...");
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser(MYSQL_USER_ROOT);
//		dataSource.setPassword("");
		dataSource.setServerName(SERVER_NAME);
		Connection conn = dataSource.getConnection();
		
		Resource resourceScript = new PathResource(PATH_SCRIPT + "DDL_DEMO_TEST.SQL");		
		ScriptUtils.executeSqlScript(conn, resourceScript);
		
		resourceScript = new PathResource(PATH_SCRIPT + "DML_DEMO_TEST.SQL");		
		ScriptUtils.executeSqlScript(conn, resourceScript);
		
		logger.debug("...ENDING SCRIPT DDL DML...");
	}

}
