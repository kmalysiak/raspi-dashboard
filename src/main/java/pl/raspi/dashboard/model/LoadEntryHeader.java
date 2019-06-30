package pl.raspi.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
public class LoadEntryHeader {

  private long id;
  private LocalDateTime pickTime;
  private String machineName;
  private String systemName;
  List<EntryItems> entryItems;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }

  @JsonProperty("invoiceId")
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @ApiModelProperty(example = "raspi box")
  public String getMachineName() {
    return machineName;
  }

  public void setMachineName(String machineNAme) {
    this.machineName = machineName;
  }

  @ApiModelProperty(example = "raspi box")
  public String getSystemName() {
    return systemName;
  }

  public void setSystemName(String systemName) {
    this.systemName = systemName;
  }

  @ApiModelProperty(example = "2019-06-15")
  public LocalDateTime getPickDate() {
    return pickTime;
  }

  public void setPickDate(LocalDateTime pickTime) {
    this.pickTime = pickTime;
  }


  public List<EntryItems> getProducts() {
    return entryItems;
  }

  public void setProducts(List<EntryItems> entryItems) {
    this.entryItems = entryItems;
  }


  @Override
  public boolean equals(Object object) {
    return EqualsBuilder.reflectionEquals(this, object);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this, true);
  }
}
