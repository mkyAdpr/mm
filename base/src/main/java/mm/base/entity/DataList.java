package mm.base.entity;

import java.util.ArrayList;
import java.util.Collection;

public class DataList<E> extends ArrayList<E>{
    private Integer pageSize;   //每页记录数量
    private Integer pageNo;     //当前第几页
    private Integer totalRec;   //记录总数

    public DataList(Collection<? extends E> c, int pageSize, int pageNo, int totalRec){
        super(c);
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.totalRec = totalRec;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getTotalRec() {
        return totalRec;
    }
}
