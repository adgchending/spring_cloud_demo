package cn.itbluebox.order.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "basic_school_infor")
public class BasicSchoolInfor {

  @Id
  private Long id;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private Long fkCode;
  private Long delStatus;
  private String schoolName;
  private Long schoolStages;
  private String schoolCode;
  private String schoolTel;
  private String schoolFax;
  private String schoolAddress;
  private String provinceName;
  private Long provinceCode;
  private String cityName;
  private Long cityCode;
  private String districtName;
  private Long districtCode;
  private String schoolEnglishName;
  private Long schoolNature;
  private Long schoolPostcode;
  private java.sql.Timestamp validStartTime;
  private java.sql.Timestamp validEndTime;
  private Long eduBureauFkCode;
  private Long remindAuto;
  private java.sql.Timestamp setupTime;
  private Long schoolArea;
  private String schoolMotto;
  private String schoolProfile;
  private String schoolLatlng;
  private String schoolImage;



}
