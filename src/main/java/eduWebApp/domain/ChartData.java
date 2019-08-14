package eduWebApp.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ChartData {
	private static JdbcTemplate jdbcTemplate;
	static Map<Object,Object> map = null;
	static List<List<DataPointModel>> list = new ArrayList<List<DataPointModel>>();
	static List<DataPointModel> dataPoints1 = new ArrayList<DataPointModel>();
	static {
		
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://mysql.mcscw3.le.ac.uk:3306/kg219");
        dataSource.setUsername("kg219");
        dataSource.setPassword("iecohR7e");
        jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public static class DataPointModel {
		int x;
		int y;
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
	}
	
	public static class DatabaseConnectionException  extends RuntimeException{
		
		private static final long serialVersionUID = 1L;
 
		public DatabaseConnectionException(String message) {
			super(message);
		}
	}
	private static void getDataPoints(){
        String sql = "SELECT username, high_score FROM user";
        
        try {
        	dataPoints1 = jdbcTemplate.query(sql, new RowMapper<DataPointModel>() {
 
				@Override
				public DataPointModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	DataPointModel dataPoint = new DataPointModel();
	     
	            	dataPoint.setX(rs.getInt("x"));
	            	dataPoint.setY(rs.getInt("y"));
	     
	                return dataPoint;
				}});
        }
        catch(Exception e){
        	dataPoints1 = null;
        	throw new DatabaseConnectionException("Error while getting dataPoints");
        }
		list.add(dataPoints1);
	}
	
	public static List<List<DataPointModel>> getDataList() {
		getDataPoints();
		return list;
	}

}