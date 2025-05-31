package cn.liantao.lbook.mapper;
import cn.liantao.lbook.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUser(String account);
    List<User> getAllUser();
    void changeState(String account);
//    List<User>
    void addUser(String account,String password,String username,Boolean isManager,String mail,Float money,Boolean allowed);
}
