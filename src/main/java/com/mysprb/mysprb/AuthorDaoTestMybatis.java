package com.mysprb.mysprb;

/**
 * Created by Administrator on 2018/12/27.
 */

import com.mysprb.mysprb.domain.Author;
import com.mysprb.mysprb.mappers.AuthorMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = MysprbApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthorDaoTestMybatis {
    @Autowired
    private AuthorMapper mapper;

    @Test
    public void testInsert(){
        Author author = new Author();
        author.setId(2L);
        author.setRealName("张");
        author.setNickName("三");
        mapper.insertAuthor(author);
        System.out.println("成功！");
    }

    @Test
    public void testMybatisQuery(){
        Author author = mapper.queryById(2L);
        assertNotNull(author);
        System.out.println(author.toString());
    }

    @Test
    public void testUpdate(){
        Author author = mapper.queryById(2L);
        author.setNickName("月儿");
        author.setRealName("林月如");
        mapper.updateAuthor(author);
    }

    @Autowired
    DataSource dataSource;
    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
