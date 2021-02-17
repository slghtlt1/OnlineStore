package com.company.util;

import com.company.dBconn.ConnDB;

import java.sql.Connection;
import java.util.Random;
import java.util.Scanner;

public class UtilClass {
    public static final Connection conn = ConnDB.createConn();
    public static final Scanner s = new Scanner(System.in);
    public static final Random random = new Random();
}
