/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 * OpenAPI spec version: 0.8.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.github.drsmugleaf.eve.esi.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-06T12:27:50.305+02:00")
public class GetCorporationsCorporationIdOk {
  @SerializedName("alliance_id")
  private Integer allianceId = null;

  @SerializedName("ceo_id")
  private Integer ceoId = null;

  @SerializedName("creator_id")
  private Integer creatorId = null;

  @SerializedName("date_founded")
  private OffsetDateTime dateFounded = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("faction_id")
  private Integer factionId = null;

  @SerializedName("home_station_id")
  private Integer homeStationId = null;

  @SerializedName("member_count")
  private Integer memberCount = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("shares")
  private Long shares = null;

  @SerializedName("tax_rate")
  private Float taxRate = null;

  @SerializedName("ticker")
  private String ticker = null;

  @SerializedName("url")
  private String url = null;

  public GetCorporationsCorporationIdOk allianceId(Integer allianceId) {
    this.allianceId = allianceId;
    return this;
  }

   /**
   * ID of the alliance that corporation is a member of, if any
   * @return allianceId
  **/
  @ApiModelProperty(value = "ID of the alliance that corporation is a member of, if any")
  public Integer getAllianceId() {
    return allianceId;
  }

  public void setAllianceId(Integer allianceId) {
    this.allianceId = allianceId;
  }

  public GetCorporationsCorporationIdOk ceoId(Integer ceoId) {
    this.ceoId = ceoId;
    return this;
  }

   /**
   * ceo_id integer
   * @return ceoId
  **/
  @ApiModelProperty(required = true, value = "ceo_id integer")
  public Integer getCeoId() {
    return ceoId;
  }

  public void setCeoId(Integer ceoId) {
    this.ceoId = ceoId;
  }

  public GetCorporationsCorporationIdOk creatorId(Integer creatorId) {
    this.creatorId = creatorId;
    return this;
  }

   /**
   * creator_id integer
   * @return creatorId
  **/
  @ApiModelProperty(required = true, value = "creator_id integer")
  public Integer getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(Integer creatorId) {
    this.creatorId = creatorId;
  }

  public GetCorporationsCorporationIdOk dateFounded(OffsetDateTime dateFounded) {
    this.dateFounded = dateFounded;
    return this;
  }

   /**
   * date_founded string
   * @return dateFounded
  **/
  @ApiModelProperty(value = "date_founded string")
  public OffsetDateTime getDateFounded() {
    return dateFounded;
  }

  public void setDateFounded(OffsetDateTime dateFounded) {
    this.dateFounded = dateFounded;
  }

  public GetCorporationsCorporationIdOk description(String description) {
    this.description = description;
    return this;
  }

   /**
   * description string
   * @return description
  **/
  @ApiModelProperty(value = "description string")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GetCorporationsCorporationIdOk factionId(Integer factionId) {
    this.factionId = factionId;
    return this;
  }

   /**
   * faction_id integer
   * @return factionId
  **/
  @ApiModelProperty(value = "faction_id integer")
  public Integer getFactionId() {
    return factionId;
  }

  public void setFactionId(Integer factionId) {
    this.factionId = factionId;
  }

  public GetCorporationsCorporationIdOk homeStationId(Integer homeStationId) {
    this.homeStationId = homeStationId;
    return this;
  }

   /**
   * home_station_id integer
   * @return homeStationId
  **/
  @ApiModelProperty(value = "home_station_id integer")
  public Integer getHomeStationId() {
    return homeStationId;
  }

  public void setHomeStationId(Integer homeStationId) {
    this.homeStationId = homeStationId;
  }

  public GetCorporationsCorporationIdOk memberCount(Integer memberCount) {
    this.memberCount = memberCount;
    return this;
  }

   /**
   * member_count integer
   * @return memberCount
  **/
  @ApiModelProperty(required = true, value = "member_count integer")
  public Integer getMemberCount() {
    return memberCount;
  }

  public void setMemberCount(Integer memberCount) {
    this.memberCount = memberCount;
  }

  public GetCorporationsCorporationIdOk name(String name) {
    this.name = name;
    return this;
  }

   /**
   * the full name of the corporation
   * @return name
  **/
  @ApiModelProperty(required = true, value = "the full name of the corporation")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetCorporationsCorporationIdOk shares(Long shares) {
    this.shares = shares;
    return this;
  }

   /**
   * shares integer
   * @return shares
  **/
  @ApiModelProperty(value = "shares integer")
  public Long getShares() {
    return shares;
  }

  public void setShares(Long shares) {
    this.shares = shares;
  }

  public GetCorporationsCorporationIdOk taxRate(Float taxRate) {
    this.taxRate = taxRate;
    return this;
  }

   /**
   * tax_rate number
   * minimum: 0
   * maximum: 1
   * @return taxRate
  **/
  @ApiModelProperty(required = true, value = "tax_rate number")
  public Float getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(Float taxRate) {
    this.taxRate = taxRate;
  }

  public GetCorporationsCorporationIdOk ticker(String ticker) {
    this.ticker = ticker;
    return this;
  }

   /**
   * the short name of the corporation
   * @return ticker
  **/
  @ApiModelProperty(required = true, value = "the short name of the corporation")
  public String getTicker() {
    return ticker;
  }

  public void setTicker(String ticker) {
    this.ticker = ticker;
  }

  public GetCorporationsCorporationIdOk url(String url) {
    this.url = url;
    return this;
  }

   /**
   * url string
   * @return url
  **/
  @ApiModelProperty(value = "url string")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCorporationsCorporationIdOk getCorporationsCorporationIdOk = (GetCorporationsCorporationIdOk) o;
    return Objects.equals(this.allianceId, getCorporationsCorporationIdOk.allianceId) &&
        Objects.equals(this.ceoId, getCorporationsCorporationIdOk.ceoId) &&
        Objects.equals(this.creatorId, getCorporationsCorporationIdOk.creatorId) &&
        Objects.equals(this.dateFounded, getCorporationsCorporationIdOk.dateFounded) &&
        Objects.equals(this.description, getCorporationsCorporationIdOk.description) &&
        Objects.equals(this.factionId, getCorporationsCorporationIdOk.factionId) &&
        Objects.equals(this.homeStationId, getCorporationsCorporationIdOk.homeStationId) &&
        Objects.equals(this.memberCount, getCorporationsCorporationIdOk.memberCount) &&
        Objects.equals(this.name, getCorporationsCorporationIdOk.name) &&
        Objects.equals(this.shares, getCorporationsCorporationIdOk.shares) &&
        Objects.equals(this.taxRate, getCorporationsCorporationIdOk.taxRate) &&
        Objects.equals(this.ticker, getCorporationsCorporationIdOk.ticker) &&
        Objects.equals(this.url, getCorporationsCorporationIdOk.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allianceId, ceoId, creatorId, dateFounded, description, factionId, homeStationId, memberCount, name, shares, taxRate, ticker, url);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationsCorporationIdOk {\n");
    
    sb.append("    allianceId: ").append(toIndentedString(allianceId)).append("\n");
    sb.append("    ceoId: ").append(toIndentedString(ceoId)).append("\n");
    sb.append("    creatorId: ").append(toIndentedString(creatorId)).append("\n");
    sb.append("    dateFounded: ").append(toIndentedString(dateFounded)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    factionId: ").append(toIndentedString(factionId)).append("\n");
    sb.append("    homeStationId: ").append(toIndentedString(homeStationId)).append("\n");
    sb.append("    memberCount: ").append(toIndentedString(memberCount)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    shares: ").append(toIndentedString(shares)).append("\n");
    sb.append("    taxRate: ").append(toIndentedString(taxRate)).append("\n");
    sb.append("    ticker: ").append(toIndentedString(ticker)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
