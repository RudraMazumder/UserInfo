package com.wipro.userinfo.repo;

import com.wipro.userinfo.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo,Integer>{
}
