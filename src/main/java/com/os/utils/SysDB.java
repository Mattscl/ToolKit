//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.os.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.naming.Context;
import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class SysDB {
    public SysDB() {
    }

    public static Connection getConn(NamedParameterJdbcTemplate jdbcTemplate) throws SQLException {
        TransactionSynchronizationManager.initSynchronization();
        DataSource dataSource = ((JdbcTemplate)jdbcTemplate.getJdbcOperations()).getDataSource();
        return DataSourceUtils.getConnection(dataSource);
    }

    public static Connection getDBConn(String sIP, int iPost, String sUser, String sPwd, String sDataBaseName) throws Exception {
        Connection con = null;
        String sConnStr = "";
        String sDriverName = "";
        sConnStr = "jdbc:oracle:thin:@" + sIP + ":" + iPost + "/" + sDataBaseName;
        sDriverName = "oracle.jdbc.driver.OracleDriver";
        Class.forName(sDriverName);
        con = DriverManager.getConnection(sConnStr, sUser, sPwd);
        return con;
    }

    public static Connection getConn(String sJndiName) throws Exception {
        Connection con = null;
        Object ds = null;
        Object ctx = null;

        try {
            if(SysString.isEmpty(sJndiName)) {
                con = null;
            } else {
                Object e = ((Context)ctx).lookup(sJndiName);
                DataSource dsTax = (DataSource)e;
                con = dsTax.getConnection();
                if(con == null) {
                    throw new Exception("无法连接数据库！");
                }
            }

            return con;
        } catch (Exception var6) {
            throw var6;
        }
    }

    public static void closeConn(Object... args) {
        Object obj = null;
        Connection con = null;

        try {
            if(args != null) {
                TransactionSynchronizationManager.clearSynchronization();

                for(int e = 0; e < args.length; ++e) {
                    obj = args[e];
                    if(obj != null) {
                        if(obj instanceof ResultSet) {
                            ((ResultSet)obj).close();
                        } else if(obj instanceof PreparedStatement) {
                            ((PreparedStatement)obj).close();
                        } else if(obj instanceof Statement) {
                            ((Statement)obj).close();
                        } else if(obj instanceof Connection) {
                            con = (Connection)obj;

                            try {
                                if(!con.getAutoCommit()) {
                                    con.rollback();
                                    con.setAutoCommit(true);
                                }
                            } catch (Exception var5) {
                                ;
                            }

                            con.close();
                        }
                    }
                }
            }
        } catch (Exception var6) {
            ;
        }

    }

    public static int getIntValue(NamedParameterJdbcTemplate jdbcTemplate, String sql, HashMap<String, Object> params) throws Exception {
        boolean iValue = false;

        int iValue1;
        try {
            iValue1 = ((Integer)jdbcTemplate.queryForObject(sql, params, Integer.class)).intValue();
        } catch (DataAccessException var5) {
            iValue1 = 0;
        }

        return iValue1;
    }

    public static int getIntValue(JdbcTemplate jdbcTemplate, String sql, Object... params) throws Exception {
        boolean iValue = false;

        int iValue1;
        try {
            iValue1 = ((Integer)jdbcTemplate.queryForObject(sql, Integer.class, params)).intValue();
        } catch (DataAccessException var5) {
            iValue1 = 0;
        }

        return iValue1;
    }

    public static int getIntValue(NamedParameterJdbcTemplate jdbcTemplate, String sql) throws Exception {
        HashMap param = new HashMap();
        boolean iValue = false;

        int iValue1;
        try {
            iValue1 = ((Integer)jdbcTemplate.queryForObject(sql, param, Integer.class)).intValue();
        } catch (DataAccessException var5) {
            iValue1 = 0;
        }

        return iValue1;
    }

    public static int getIntValue(JdbcTemplate jdbcTemplate, String sql) throws Exception {
        boolean iValue = false;

        int iValue1;
        try {
            iValue1 = ((Integer)jdbcTemplate.queryForObject(sql, Integer.class)).intValue();
        } catch (DataAccessException var4) {
            iValue1 = 0;
        }

        return iValue1;
    }

    public static String getStringValue(NamedParameterJdbcTemplate jdbcTemplate, String sql, HashMap<String, Object> params) throws Exception {
        String sValue = "";

        try {
            sValue = (String)jdbcTemplate.queryForObject(sql, params, String.class);
        } catch (DataAccessException var5) {
            sValue = "";
        }

        return sValue;
    }

    public static String getStringValue(JdbcTemplate jdbcTemplate, String sql, Object... params) throws Exception {
        String sValue = "";

        try {
            sValue = (String)jdbcTemplate.queryForObject(sql, String.class, params);
        } catch (DataAccessException var5) {
            sValue = "";
        }

        return sValue;
    }

    public static String getStringValue(NamedParameterJdbcTemplate jdbcTemplate, String sql) throws Exception {
        HashMap param = new HashMap();
        String str = "";

        try {
            str = (String)jdbcTemplate.queryForObject(sql, param, String.class);
        } catch (DataAccessException var5) {
            str = "";
        }

        return str;
    }

    public static String getStringValue(JdbcTemplate jdbcTemplate, String sql) throws Exception {
        String sValue = "";

        try {
            sValue = (String)jdbcTemplate.queryForObject(sql, String.class);
        } catch (DataAccessException var4) {
            sValue = "";
        }

        return sValue;
    }

    public static double getDoubleValue(NamedParameterJdbcTemplate jdbcTemplate, String sql, HashMap<String, Object> params) throws Exception {
        double dValue = 0.0D;

        try {
            dValue = ((Double)jdbcTemplate.queryForObject(sql, params, Double.class)).doubleValue();
        } catch (DataAccessException var6) {
            dValue = 0.0D;
        }

        return dValue;
    }

    public static double getDoubleValue(JdbcTemplate jdbcTemplate, String sql, Object... params) throws Exception {
        double dValue = 0.0D;

        try {
            dValue = ((Double)jdbcTemplate.queryForObject(sql, params, Double.class)).doubleValue();
        } catch (DataAccessException var6) {
            dValue = 0.0D;
        }

        return dValue;
    }

    public static double getDoubleValue(NamedParameterJdbcTemplate jdbcTemplate, String sql) throws Exception {
        HashMap param = new HashMap();
        double dValue = 0.0D;

        try {
            dValue = ((Double)jdbcTemplate.queryForObject(sql, param, Double.class)).doubleValue();
        } catch (DataAccessException var6) {
            dValue = 0.0D;
        }

        return dValue;
    }

    public static double getDoubleValue(JdbcTemplate jdbcTemplate, String sql) throws Exception {
        double dValue = 0.0D;

        try {
            dValue = ((Double)jdbcTemplate.queryForObject(sql, Double.class)).doubleValue();
        } catch (DataAccessException var5) {
            dValue = 0.0D;
        }

        return dValue;
    }

    public static Map<String, Object> getMapValue(NamedParameterJdbcTemplate jdbcTemplate, String sql, HashMap<String, Object> params) throws Exception {
        Map m = null;

        try {
            m = jdbcTemplate.queryForMap(sql, params);
        } catch (DataAccessException var5) {
            m = null;
        }

        return m;
    }

    public static Map<String, Object> getMapValue(JdbcTemplate jdbcTemplate, String sql, Object... params) throws Exception {
        Map m = null;

        try {
            m = jdbcTemplate.queryForMap(sql, params);
        } catch (DataAccessException var5) {
            m = null;
        }

        return m;
    }

    public static <E> Class<E> getClassValue(NamedParameterJdbcTemplate jdbcTemplate, String sql, HashMap<String, Object> params, Class<E> cls) throws Exception {
        return (Class)jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper(cls));
    }

    public static <E> Class<E> getClassValue(JdbcTemplate jdbcTemplate, String sql, Class<E> cls, Object... params) throws Exception {
        return (Class)jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(cls), params);
    }

    public static List<Map<String, Object>> getRows(NamedParameterJdbcTemplate jdbcTemplate, String sql) throws Exception {
        HashMap params = new HashMap();
        return jdbcTemplate.queryForList(sql, params);
    }

    public static List<Map<String, Object>> getRows(NamedParameterJdbcTemplate jdbcTemplate, String sql, HashMap<String, Object> params) throws Exception {
        if(params == null) {
            params = new HashMap();
        }

        return jdbcTemplate.queryForList(sql, params);
    }

    public static List<Map<String, Object>> getRows(NamedParameterJdbcTemplate jdbcTemplate, String sql, int iPageIndex, int iPageSize, HashMap<String, Object> params) throws Exception {
        int iBegPos = (iPageIndex - 1) * iPageSize + 1;
        int iEndPos = iPageIndex * iPageSize;
        StringBuilder sb = new StringBuilder();
        sb.append(" with z as ( " + sql + ")");
        sb.append(" select * from (");
        sb.append("        Select rownum FROWNUM,z.* from z");
        sb.append("    where rownum <= " + iEndPos);
        sb.append(" ) where FROWNUM >= " + iBegPos);
        return jdbcTemplate.queryForList(sb.toString(), params);
    }

    public static List<Map<String, Object>> getRows(JdbcTemplate jdbcTemplate, String sql, Object... args) throws Exception {
        return jdbcTemplate.queryForList(sql, args);
    }

    public static List<Map<String, Object>> getRows(JdbcTemplate jdbcTemplate, String sql, int iPageIndex, int iPageSize, Object... args) throws Exception {
        int iBegPos = (iPageIndex - 1) * iPageSize + 1;
        int iEndPos = iPageIndex * iPageSize;
        StringBuilder sb = new StringBuilder();
        sb.append(" with z as ( " + sql + ")");
        sb.append(" select * from (");
        sb.append("        Select rownum FROWNUM,z.* from z");
        sb.append("    where rownum <= " + iEndPos);
        sb.append(" ) where FROWNUM >= " + iBegPos);
        return jdbcTemplate.queryForList(sb.toString(), args);
    }

    public static List<Map<String, Object>> getRows(JdbcTemplate jdbcTemplate, String sql) throws Exception {
        return jdbcTemplate.queryForList(sql);
    }

    public static <E> List<E> getRows(NamedParameterJdbcTemplate jdbcTemplate, String sql, Object[] params, Class<E> cls) throws Exception {
        return jdbcTemplate.getJdbcOperations().query(sql, params, new BeanPropertyRowMapper(cls));
    }

    public static <E> List<E> getRows(JdbcTemplate jdbcTemplate, String sql, Object[] params, Class<E> cls) throws Exception {
        return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(cls));
    }

    public static List<Integer> getIntList(NamedParameterJdbcTemplate jdbcTemplate, String sql, HashMap<String, Object> params) throws Exception {
        return jdbcTemplate.queryForList(sql, params, Integer.class);
    }

    public static List<Integer> getIntList(JdbcTemplate jdbcTemplate, String sql, Object... params) throws Exception {
        return jdbcTemplate.queryForList(sql, Integer.class, params);
    }

    public static List<Integer> getIntList(NamedParameterJdbcTemplate jdbcTemplate, String sql, MapSqlParameterSource params) throws Exception {
        return jdbcTemplate.queryForList(sql, params, Integer.class);
    }

    public static List<String> getStrList(NamedParameterJdbcTemplate jdbcTemplate, String sql, HashMap<String, Object> params) throws Exception {
        return jdbcTemplate.queryForList(sql, params, String.class);
    }

    public static List<String> getStrList(JdbcTemplate jdbcTemplate, String sql, Object... params) throws Exception {
        return jdbcTemplate.queryForList(sql, String.class, params);
    }

    public static List<String> getStrList(NamedParameterJdbcTemplate jdbcTemplate, String sql, MapSqlParameterSource sqlParam) throws Exception {
        return jdbcTemplate.queryForList(sql, sqlParam, String.class);
    }

    public static SqlRowSet getResultSet(NamedParameterJdbcTemplate jdbcTemplate, String sql, HashMap<String, Object> params) throws Exception {
        return jdbcTemplate.queryForRowSet(sql, params);
    }

    public static SqlRowSet getResultSet(JdbcTemplate jdbcTemplate, String sql, Object... params) throws Exception {
        return jdbcTemplate.queryForRowSet(sql, params);
    }

    public static int update(NamedParameterJdbcTemplate jdbcTemplate, String sql, HashMap<String, Object> params) throws Exception {
        return jdbcTemplate.update(sql, params);
    }

    public static int update(JdbcTemplate jdbcTemplate, String sql, Object... params) throws Exception {
        return jdbcTemplate.update(sql, params);
    }

    public static int update(JdbcTemplate jdbcTemplate, String sql, Object[] params, int[] types) throws Exception {
        return jdbcTemplate.update(sql, params, types);
    }

    public static int update(NamedParameterJdbcTemplate jdbcTemplate, String sql, SqlParameterSource sqlSource) throws Exception {
        return jdbcTemplate.update(sql, sqlSource);
    }

    public static int update(JdbcTemplate jdbcTemplate, String sql, SqlParameterSource sqlSource) throws Exception {
        return jdbcTemplate.update(sql, new Object[]{sqlSource});
    }

    public static void execute(NamedParameterJdbcTemplate jdbcTemplate, String sql) throws Exception {
        jdbcTemplate.getJdbcOperations().execute(sql);
    }

    public static void execute(JdbcTemplate jdbcTemplate, String sql) throws Exception {
        jdbcTemplate.execute(sql);
    }

    public static int[] batchUpdate(NamedParameterJdbcTemplate jdbcTemplate, String sql, HashMap<String, Object>[] params) throws Exception {
        return jdbcTemplate.batchUpdate(sql, params);
    }

    public static int[] batchUpdate(JdbcTemplate jdbcTemplate, String sql, List<Object[]> params) throws Exception {
        return jdbcTemplate.batchUpdate(sql, params);
    }

    public static int[] batchUpdate(NamedParameterJdbcTemplate jdbcTemplate, String[] sql) throws Exception {
        return jdbcTemplate.getJdbcOperations().batchUpdate(sql);
    }

    public static int[] batchUpdate(NamedParameterJdbcTemplate jdbcTemplate, String sql, BeanPropertySqlParameterSource[] params) throws Exception {
        return jdbcTemplate.batchUpdate(sql, params);
    }

    public static boolean isExistTable(NamedParameterJdbcTemplate jdbcTemplate, String sTableName) throws Exception {
        sTableName = sTableName.toUpperCase();
        String SQL = "Select table_name from user_tables where table_name=:table";
        HashMap param = new HashMap();
        param.put("table", sTableName);
        String sTable = (String)jdbcTemplate.queryForObject(SQL, param, String.class);
        return !SysString.isEmpty(sTable);
    }

    public static boolean isExistColumn(NamedParameterJdbcTemplate jdbcTemplate, String sTableName, String sColName) throws Exception {
        sTableName = sTableName.toUpperCase();
        sColName = sColName.toUpperCase();
        String SQL = "SELECT count(1) FROM user_tab_columns t WHERE t.table_Name =:table";
        SQL = SQL + "  and t.COLUMN_NAME =:col";
        HashMap param = new HashMap();
        param.put("table", sTableName);
        param.put("col", sColName);
        int iCount = ((Integer)jdbcTemplate.queryForObject(SQL, param, Integer.class)).intValue();
        return iCount != 0;
    }

    public static boolean isExistPartition(NamedParameterJdbcTemplate jdbcTemplate, String tableName, String partitionName) throws Exception {
        boolean bFlag = false;
        String sql = "select count(1) from user_tab_partitions t ";
        sql = sql + "where t.table_name=:tabname and t.partition_name=:pname";
        tableName = tableName.toUpperCase();
        partitionName = partitionName.toUpperCase();
        HashMap map = new HashMap();
        map.put("tabname", tableName);
        map.put("pname", partitionName);
        int iValue = getIntValue(jdbcTemplate, sql, map);
        if(iValue > 0) {
            bFlag = true;
        }

        return bFlag;
    }

    public static void addPartition(NamedParameterJdbcTemplate jdbcTemplate, String sTableName, String sValue, boolean IsNumber, String sTableSpace) throws Exception {
        if(!SysString.isEmpty(sValue)) {
            String sPartitionName = "P_" + sValue.replace(".", "_");
            sTableName = sTableName.toUpperCase();
            String SQL = " Alter table " + sTableName + " Add Partition " + sPartitionName;
            if(IsNumber) {
                SQL = SQL + " Values (" + sValue + ")";
            } else {
                SQL = SQL + " Values (\'" + sValue + "\')";
            }

            SQL = SQL + " TableSpace " + sTableSpace;
            jdbcTemplate.getJdbcOperations().execute(SQL);
        }
    }

    public static void truncPartition(NamedParameterJdbcTemplate jdbcTemplate, String sTableName, String sValue) throws Exception {
        String sPartitionName = "P_" + sValue.replace(".", "_");
        sTableName = sTableName.toUpperCase();
        String SQL = " Alter table " + sTableName + " truncate Partition " + sPartitionName;
        jdbcTemplate.getJdbcOperations().execute(SQL);
    }

    public static void dropPartition(NamedParameterJdbcTemplate jdbcTemplate, String sTableName, String sValue) throws Exception {
        String sPartitionName = "P_" + sValue.replace(".", "_");
        sTableName = sTableName.toUpperCase();
        String SQL = " Alter table " + sTableName + " truncate Partition " + sPartitionName;
        jdbcTemplate.getJdbcOperations().execute(SQL);
        SQL = " Alter table " + sTableName + " DROP Partition " + sPartitionName;
        jdbcTemplate.getJdbcOperations().execute(SQL);
    }

    public static DataSource getDataSource(String sIP, int iPost, String sUser, String sPwd, String sDataBase) throws Exception {
        Properties p = new Properties();
        p.put("url", "jdbc:oracle:thin:@" + sIP + ":" + iPost + "/" + sDataBase);
        p.put("username", sUser);
        p.put("password", sPwd);
        p.put("initialSize", "3");
        p.put("maxActive", "30");
        p.put("minIdle", "2");
        p.put("filters", "stat,wall");
        p.put("validationQuery", "select 1 from dual");
        p.put("poolPreparedStatements", "true");
        p.put("maxPoolPreparedStatementPerConnectionSize", "20");
        return DruidDataSourceFactory.createDataSource(p);
    }

    public static NamedParameterJdbcTemplate getJdbcTemplate(String sIP, int iPost, String sUser, String sPwd, String sDataBase) throws Exception {
        DataSource dataSource = getDataSource(sIP, iPost, sUser, sPwd, sDataBase);
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        return jdbcTemplate;
    }
}
