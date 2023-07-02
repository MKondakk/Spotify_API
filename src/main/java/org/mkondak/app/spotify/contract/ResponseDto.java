package org.mkondak.app.spotify.contract;

import java.util.List;

public class ResponseDto<T>  {
    private String href;
    private List<T> items = null;
    private Long limit;
    private String next;
    private Long offset;
    private Object previous;
    private Long total;


    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
