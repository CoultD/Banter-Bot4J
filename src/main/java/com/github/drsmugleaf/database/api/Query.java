package com.github.drsmugleaf.database.api;

import javax.annotation.Nonnull;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by DrSmugleaf on 24/06/2018
 */
public class Query implements AutoCloseable {

    final PreparedStatement STATEMENT;

    Query(@Nonnull PreparedStatement statement) {
        STATEMENT = statement;
    }

    @Override
    public void close() throws SQLException {
        STATEMENT.close();
        STATEMENT.getConnection().close();
    }

}
