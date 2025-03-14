package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.SawonDto;

@Mapper
public interface SawonMapper {
	public void insertSawon(SawonDto dto);
	public List<SawonDto> getSelectAllSawon();
	public SawonDto getSawon(int num);
	public void deleteSawon(int num);
	public void updateSawon(SawonDto dto);
}
