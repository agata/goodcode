package goodcode;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.sql.DataSource;

import org.h2.tools.RunScript;
import org.seasar.framework.container.SingletonS2Container;

/**
 * Servletコンテナ起動時にDBを初期化するリスナ
 */
public class RunDdlServletRequestListener implements ServletRequestListener {

	private boolean initialized = false;

	public void requestInitialized(ServletRequestEvent event) {
		if (!initialized) {
			initialize();
		}
	}

	private synchronized void initialize() {
		if (!initialized) {
			try {
				DataSource dataSource = SingletonS2Container
						.getComponent(DataSource.class);
				Connection connection = dataSource.getConnection();
				InputStream input = Thread.currentThread()
						.getContextClassLoader().getResourceAsStream("ddl.sql");
				Reader reader = new InputStreamReader(input);
				RunScript.execute(connection, reader);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			initialized = true;
		}
	}

	public void requestDestroyed(ServletRequestEvent event) {
	}

}