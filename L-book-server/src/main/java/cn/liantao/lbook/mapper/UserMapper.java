package cn.liantao.lbook.mapper;
import cn.liantao.lbook.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUser(String account);
    void addUser(String account,String password,String username,Boolean isManager,String mail,Float money);
}
