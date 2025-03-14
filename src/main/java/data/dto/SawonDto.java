package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("SawonDto")
public class SawonDto {
	private int num;
	private String sawonname;
	private String photo;
	private String gender;
	private String hp;
	private String buseo;
	private String ipsaday;
	private Timestamp writeday;	
}
