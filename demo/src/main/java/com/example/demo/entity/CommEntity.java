package com.example.demo.entity;

import java.util.List;

public class CommEntity {
    private int code=20000;
    private String message="生成成功";
    private DataItem data;

    public CommEntity(List list) {
        DataItem dt=new DataItem(list);
        this.setData(dt);
    }

    public CommEntity(int errCode,String message) {
        this.code=errCode;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataItem getData() {
        return data;
    }

    private void setData(DataItem data) {
        this.data = data;
    }

    class DataItem {
        List items;
        int total;

        public List getItems() {
            return items;
        }

        public void setItems(List items) {
            this.items = items;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        private DataItem(List items) {
            this.items = items;
            this.total=items.size();
        }

    }


}
