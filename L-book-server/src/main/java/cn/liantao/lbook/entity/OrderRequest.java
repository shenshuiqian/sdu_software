package cn.liantao.lbook.entity;

public class OrderRequest {
    private String account;
    private String isbn;
    private int count;

    // Getter 和 Setter 必须有
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

