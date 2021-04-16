package mm.base.common;

import org.springframework.util.StringUtils;

public abstract class QueryCriteria {
    protected int pageNo = 1;
    protected int pagePer = 100;
    private String asc;
    private String desc;

    public int getPageNo() {
        return pageNo;
    }

    public int getPagePer() {
        return pagePer;
    }

    public String getAsc() {
        return StringUtils.hasText(asc) ? asc : null;
    }

    public String getDesc() {
        return StringUtils.hasText(desc) ? desc : null;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setPagePer(int pagePer) {
        this.pagePer = pagePer;
    }

    public void setAsc(String asc) {
        this.asc = asc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
