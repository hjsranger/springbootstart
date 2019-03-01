package com.hjs.starter.service;


import com.hjs.starter.dao.FooMapper;
import com.hjs.starter.model.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"myCache"})
public class EhcacheService  {
    @Autowired
    private FooMapper fooMapper;
    /**
     * 注意：如果没有指定key，则方法参数作为key保存到缓存中
     */
    /**
     * @param foo
     * @return
     * @CachePut缓存新增的或更新的数据到缓存，其中缓存的名称为people，数据的key是person的id
     */
    @CachePut(key = "#foo.id")
    public Foo save(Foo foo) {
        fooMapper.insert(foo);
        System.out.println("为id，key为：" + foo.getId() + "数据做了缓存");
        return foo;
    }

    /**
     * @param id
     * @CacheEvict从缓存people中删除key为id的数据
     */
    @CacheEvict
    public void remove(String id) {
        System.out.println("删除了id，key为" + id + "的数据缓存");
        fooMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param foo
     * @return
     * @Cacheable缓存key为person的id数据到缓存people中
     */
    @Cacheable(key = "#foo.id")
    public Foo findOne(Foo foo) {
        Foo f = fooMapper.selectByPrimaryKey(foo.getId());
        System.out.println("为id，key为：" + foo.getId() + "数据做了缓存");
        return f;
    }
}

