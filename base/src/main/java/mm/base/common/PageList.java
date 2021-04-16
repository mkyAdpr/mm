package mm.base.common;

import java.util.ArrayList;

public class PageList<E> extends ArrayList {

    private int totalRec;
    private int pagePer;
    private int pageNo;

    public PageList(int totalRec, int pagePer, int pageNo){
        this.totalRec = totalRec;
        this.pagePer = pagePer;
        this.pageNo = pageNo;
    }

    /**
     * 数据总条数
     * @return
     */
    public int getTotalRec() {
        return totalRec;
    }

    /**
     * 每页数量
     */
    public int getPagePer() {
        return pagePer;
    }

    /**
     * 页码
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 总页数
     */
    public int getTotalPage(){
        return (totalRec + pagePer - 1)/pagePer;
    }



}
