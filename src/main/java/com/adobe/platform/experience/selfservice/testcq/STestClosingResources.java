package com.adobe.platform.experience.selfservice.testcq;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class STestClosingResources {

    private InitialContext ctx;

    private DataSource ds;

    public STestClosingResources (InitialContext ctx, DataSource ds) {
        this.ctx = ctx;
        this.ds = ds;
    }

    public final void service()
            throws Exception
    {
        Connection con = null;
        ResultSet rsGet = null;
        PreparedStatement psGet = null;
        try {
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
