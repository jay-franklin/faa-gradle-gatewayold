package faa.models;

import faa.utils.DataGenerator;

public class Holiday {
	private String blkoutId;
	private String blkoutDt;
	private String stringDt;
	private String blkoutStartTm;
	private String blkoutEndTm;
	private String blkoutTypCd;
	private String blkoutDesc;
	private String blkoutTypCdDesc;
	private String blkoutLctnCd;
	private String blkoutRsnTxt;
	private String blkoutLctnNm;
	private Boolean isEditable;
	private Boolean edit;
	private Boolean isFocused;
	private Boolean newday;
	


	
	public Holiday() {
		super();
		this.blkoutRsnTxt = DataGenerator.randomAlphaNumeric(10);
		this.isFocused = true;
		this.newday = true;
	}
	public String getBlkoutId() {
		return blkoutId;
	}
	public void setBlkoutId(String blkoutId) {
		this.blkoutId = blkoutId;
	}
	public String getBlkoutDt() {
		return blkoutDt;
	}
	public void setBlkoutDt(String blkoutDt) {
		this.blkoutDt = blkoutDt;
	}
	public String getStringDt() {
		return stringDt;
	}
	public void setStringDt(String stringDt) {
		this.stringDt = stringDt;
	}
	public String getBlkoutStartTm() {
		return blkoutStartTm;
	}
	public void setBlkoutStartTm(String blkoutStartTm) {
		this.blkoutStartTm = blkoutStartTm;
	}
	public String getBlkoutEndTm() {
		return blkoutEndTm;
	}
	public void setBlkoutEndTm(String blkoutEndTm) {
		this.blkoutEndTm = blkoutEndTm;
	}
	public String getBlkoutTypCd() {
		return blkoutTypCd;
	}
	public void setBlkoutTypCd(String blkoutTypCd) {
		this.blkoutTypCd = blkoutTypCd;
	}
	public String getBlkoutDesc() {
		return blkoutDesc;
	}
	public void setBlkoutDesc(String blkoutDesc) {
		this.blkoutDesc = blkoutDesc;
	}
	public String getBlkoutTypCdDesc() {
		return blkoutTypCdDesc;
	}
	public void setBlkoutTypCdDesc(String blkoutTypCdDesc) {
		this.blkoutTypCdDesc = blkoutTypCdDesc;
	}
	public String getBlkoutLctnCd() {
		return blkoutLctnCd;
	}
	public void setBlkoutLctnCd(String blkoutLctnCd) {
		this.blkoutLctnCd = blkoutLctnCd;
	}
	public String getBlkoutRsnTxt() {
		return blkoutRsnTxt;
	}
	public void setBlkoutRsnTxt(String blkoutRsnTxt) {
		this.blkoutRsnTxt = blkoutRsnTxt;
	}
	public String getBlkoutLctnNm() {
		return blkoutLctnNm;
	}
	public void setBlkoutLctnNm(String blkoutLctnNm) {
		this.blkoutLctnNm = blkoutLctnNm;
	}
	public Boolean getIsEditable() {
		return isEditable;
	}
	public void setIsEditable(Boolean isEditable) {
		this.isEditable = isEditable;
	}
	public Boolean getEdit() {
		return edit;
	}
	public void setEdit(Boolean edit) {
		this.edit = edit;
	}
	public Boolean getIsFocused() {
		return isFocused;
	}
	public void setIsFocused(Boolean isFocused) {
		this.isFocused = isFocused;
	}
	public Boolean getNewday() {
		return newday;
	}
	public void setNewday(Boolean newday) {
		this.newday = newday;
	}
	
	
	@Override
	public String toString() {
		return "Holiday [blkoutId=" + blkoutId + ", blkoutDt=" + blkoutDt + ", stringDt=" + stringDt
				+ ", blkoutStartTm=" + blkoutStartTm + ", blkoutEndTm=" + blkoutEndTm + ", blkoutTypCd=" + blkoutTypCd
				+ ", blkoutDesc=" + blkoutDesc + ", blkoutTypCdDesc=" + blkoutTypCdDesc + ", blkoutLctnCd="
				+ blkoutLctnCd + ", blkoutRsnTxt=" + blkoutRsnTxt + ", blkoutLctnNm=" + blkoutLctnNm + ", isEditable="
				+ isEditable + ", edit=" + edit + ", isFocused=" + isFocused + ", newday=" + newday + "]";
	}

}
