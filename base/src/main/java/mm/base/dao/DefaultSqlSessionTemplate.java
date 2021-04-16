package mm.base.dao;

import mm.base.common.PageList;
import mm.base.common.QueryCriteria;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.support.PersistenceExceptionTranslator;

import java.util.List;

public class DefaultSqlSessionTemplate extends SqlSessionTemplate {

    public DefaultSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    public DefaultSqlSessionTemplate(SqlSessionFactory sqlSessionFactory, ExecutorType executorType) {
        super(sqlSessionFactory, executorType);
    }

    public DefaultSqlSessionTemplate(SqlSessionFactory sqlSessionFactory, ExecutorType executorType, PersistenceExceptionTranslator exceptionTranslator) {
        super(sqlSessionFactory, executorType, exceptionTranslator);
    }

    public <E> List<E> selectList(String statement,QueryCriteria queryCriteria) {
        List<E> list = this.selectList(statement, queryCriteria, new RowBounds((queryCriteria.getPageNo() - 1) * queryCriteria.getPagePer(),queryCriteria.getPagePer()));
        int count = this.selectOne(statement + "ForCount", queryCriteria);
        PageList plist =  new PageList(count,queryCriteria.getPagePer(),queryCriteria.getPageNo());
        plist.addAll(list);
        return  plist;
    }
}
