package cn.itbluebox.product.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "basic_school_infor")
public class BasicSchoolInfor {

  @Id
  private Long id;
  private Date createTime;
  private Date updateTime;
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
  private Date validStartTime;
  private Date validEndTime;
  private Long eduBureauFkCode;
  private Long remindAuto;
  private Date setupTime;
  private Long schoolArea;
  private String schoolMotto;
  private String schoolProfile;
  private String schoolLatlng;
  private String schoolImage;



}
