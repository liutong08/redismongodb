package cn.com.taiji.redis.test.service;


import cn.com.taiji.redis.test.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface UserService {

//	执行方法前先查看缓存中是否有数据，如果有数据，则直接返回缓存数据；若没有数据，执行该方法并将方法返回值放进缓存。
	@Cacheable(value="users", key="'user_'+#id")
	User getUser(String id);

	//方法执行成功后会从缓存中移除相应数据。

//	value缓存名、 key缓存键值、 condition满足缓存条件、unless否决缓存条件
	@CacheEvict(value="users", key="'user_'+#id",condition="#id!=1")
	void deleteUser(String id);

	//把方法的返回值放入缓存中, 主要用于数据新增和修改方法
	@CachePut(value="users")
	User putUser(String id);

	@Cacheable(value="users")
	User getUserNokey(String id);

}
