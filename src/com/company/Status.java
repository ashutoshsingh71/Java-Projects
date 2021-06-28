package com.company;

public class Status {

    private int id;
    private String accountStatusName;

    Status(int id, String accountStatusName) {
        this.id = id;
        this.accountStatusName = accountStatusName;
    }

    public int getId() {
        return id;
    }

    public String getAccountStatusName() {
        return accountStatusName;
    }

   /* public static Status forId(int id) {
        for (Status value : Status.values()) {
            if (value.id == id) {
                return value;
            }
        }

        return null;


    }*/

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", accountStatusName='" + accountStatusName + '\'' +
                '}';
    }
}
