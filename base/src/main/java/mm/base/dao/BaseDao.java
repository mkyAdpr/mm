package mm.base.dao;

import mm.base.entity.DataList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.util.List;

public class BaseDao {

    @Resource
    JdbcTemplate template;

    public Integer nextval(String sequence) {
        String sql = "select nextval('" + sequence + "')";
        return (Integer)template.queryForObject(sql,Integer.class);
    }

    public int count(String sql){
        return (int)template.queryForObject("select count(*) from (" + sql + ") t_count",Integer.class);
    }

    public int count(String sql,Object[] args){
        return (int)template.queryForObject("select count(*) from (" + sql + ") t_count",args,Integer.class);
    }

    /**
     * 分页查找
     */
    public List<?> queryForPages(String sql,RowMapper rm,Integer pageNo,Integer pageSize) {
        int count = count(sql);
        if(pageNo < 1){
            pageNo = 1;
        }
        sql += " limit " + (pageNo - 1) * pageSize + "," + pageNo * pageSize;
        return new DataList<>(template.query(sql,rm),pageSize,pageNo,count);
    }

    /**
     * 分页查找
     */
    public List<?> queryForPages(String sql,Object[] args,RowMapper rm,Integer pageNo,Integer pageSize) {
        int count = count(sql,args);
        if(pageNo < 1){
            pageNo = 1;
        }
        sql += " limit " + (pageNo - 1) * pageSize + "," + pageNo * pageSize;
        return new DataList<>(template.query(sql,rm,args),pageSize,pageNo,count);
    }
}
