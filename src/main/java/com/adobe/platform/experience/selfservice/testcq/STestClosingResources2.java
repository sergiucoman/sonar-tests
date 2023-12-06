package com.adobe.platform.experience.selfservice.testcq;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class STestClosingResources2 {

    public final void service()
            throws Exception
    {
        try (InitialContext ctx = new InitialContext();
             DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/testci");
             Connection con = ds.getConnection();
             PreparedStatement psGet = con.prepareStatement("SELECT * FROM TEST");
             ResultSet rsGet = psGet.executeQuery()) {
            int counter = 0;
            while (rsGet.next()) {
                counter++;
                System.err.println(counter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
