package com.walmartlabs.ollie.example;

/*-
 * *****
 * Ollie
 * -----
 * Copyright (C) 2018 Takari
 * -----
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =====
 */

import com.walmartlabs.ollie.database.AbstractDaoTest;
import com.walmartlabs.ollie.database.DatabaseModule;
import org.jooq.SQLDialect;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UserDaoTest extends AbstractDaoTest {
    private final String driver = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql://localhost:%s/postgres";
    private final String username = "postgres";
    private final String password = "q1";
    private final SQLDialect dialect = SQLDialect.POSTGRES;
    private final int maxPoolSize = 3;
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        String port = System.getProperty("db.port");
        String urlWithDynamicPort = String.format(url, port);
        System.setProperty("ollie.db.autoMigrate", "false");
        userDao = new UserDao(getConfiguration(driver, urlWithDynamicPort, username, password, dialect, maxPoolSize));
    }

    @Test
    public void insertTest() throws Exception {
        userDao.insert("Ryan", "Savage");
    }
}
