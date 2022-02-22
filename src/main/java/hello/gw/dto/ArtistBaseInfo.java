package hello.gw.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ArtistBaseInfo {
	
	//@Data 얘가 getter,setter,tostring,생성자 다 해줌
	//@Getter : 게터
	//@Setter : 세터
	//@ToString : toString()
	//@NoArgsConstructor : 기본생성자
	//@AllArgsConstructor : 다 들어있는 생성자
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) //: insert 할 때 id 값을 디비에서 자동으로 설정해줄 때 사용
	private int id;
	private String main_class;
	private String middle_class;
	private String sub_class;
	private String nm;
	private String afltn_agc_nm;
	private String afltn_agc_tel;
	private String afltn_agc_addr;
	private String afltn_agc_home_page;
}
