package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.jdbc.repository;

import com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.jdbc.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Collection;
import java.util.Collections;

/**
 * @Description: {@link User} 用户的仓储（SQL、或NoSQL、或内存型）
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@Repository
public class UserRepository {

    /**
     * 推荐写法
     */
    private final DataSource dataSource;

    private final DataSource masterDataSource;

    private final DataSource slaveDataSource;

    private final JdbcTemplate jdbcTemplate;

    private final PlatformTransactionManager platformTransactionManager;

    public UserRepository(DataSource dataSource,
                          @Qualifier("masterDataSource") DataSource masterDataSource,
                          @Qualifier("slaveDataSource") DataSource slaveDataSource,
                          JdbcTemplate jdbcTemplate,
                          PlatformTransactionManager platformTransactionManager) {
        this.dataSource = dataSource;
        this.masterDataSource = masterDataSource;
        this.slaveDataSource = slaveDataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.platformTransactionManager = platformTransactionManager;
    }

    private boolean jdbcSave(User user) {
        boolean success = false;
        System.out.println("User Repository Thread name is " + Thread.currentThread().getName());
        System.out.println("save user :" + user);
        Connection connection = null;
        Savepoint savepoint = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("T1");

            //嵌套事务T2
//            try {
//                transactionalSave(user); {
//                    //嵌入式事务，事务与还原点息息相关
//                    Savepoint savepoint2 = connection.setSavepoint("T2");
//                }
//            } catch (Exception e) {
//                connection.rollback(savepoint);
//            }

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(name) values (?)");
            preparedStatement.setString(1, user.getName());
            success = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.commit();
                    //释放还原点
//                    connection.releaseSavepoint(savepoint);
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }

    private boolean transactionalSave(User user) {
        boolean success = false;
        jdbcTemplate.execute("INSERT INTO user(name) VALUES (?);",
                new PreparedStatementCallback<Boolean>() {
                    @Override
                    public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                        preparedStatement.setString(1, user.getName());;
                        return preparedStatement.executeUpdate() > 0;
                    }
                });
        return success;
    }

    @Transactional
    public boolean save(User user) {
        boolean success = false;
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        //开始事务
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(defaultTransactionDefinition);
        try {
            success = jdbcTemplate.execute("INSERT INTO user(name) VALUES (?);",
                    new PreparedStatementCallback<Boolean>() {
                        @Override
                        public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                            preparedStatement.setString(1, user.getName());
                            ;
                            return preparedStatement.executeUpdate() > 0;
                        }
                    });
            platformTransactionManager.commit(transactionStatus);
        } catch (Exception e) {
            platformTransactionManager.rollback(transactionStatus);
        }
        return success;
    }

    public Collection<User> findAll() {
        return Collections.emptyList();
    }
}
