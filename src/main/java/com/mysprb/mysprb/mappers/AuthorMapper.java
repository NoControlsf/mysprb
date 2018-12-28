package com.mysprb.mysprb.mappers;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mysprb.mysprb.domain.Author;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2018/12/27.
 */
@Mapper
public interface AuthorMapper extends BaseMapper<Author> {
    public Long insertAuthor(Author author);

    public void updateAuthor(Author author);

    public Author queryById(Long id);
}
