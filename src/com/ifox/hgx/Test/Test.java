package com.ifox.hgx.Test;

import com.ifox.hgx.db.DatabaseConnection;
import com.ifox.hgx.tools.IDandDate;

public class Test {
    public static void main(String[] args) {
        System.out.println(DatabaseConnection.getConnection());

      System.out.println(IDandDate.getID());
    }
}
