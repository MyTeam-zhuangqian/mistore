package usermapper;

import com.example.mistroe.pojo.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    int deleteByPrimaryKey(String idAddress);

    int insert(Address record);

    Address selectByPrimaryKey(String idAddress);

    List<Address> selectAll();

    int updateByPrimaryKey(Address record);

    List<Address> getAddr(String name);
}