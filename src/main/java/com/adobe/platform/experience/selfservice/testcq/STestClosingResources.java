package com.adobe.platform.experience.selfservice.testcq; 

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class STestClosingResources extends HttpServlet{

    public final void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        Connection con = null;
        ResultSet rsGet = null;
        PreparedStatement psGet = null;
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/testci");
            con = ds.getConnection();

            psGet = con.prepareStatement("SELECT * FROM TEST");
            rsGet = psGet.executeQuery();
            int counter = 0;
            while (rsGet.next()) {
                counter++;
                System.err.println(counter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rsGet != null) {
                    rsGet.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            rsGet = null;
            try {
                if (psGet != null) {
                    psGet.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            psGet = null;
        }
    }
}
