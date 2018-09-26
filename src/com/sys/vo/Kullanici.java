package com.sys.vo;

public class Kullanici {
	
	private int id;
	private String ad_soyad;
	private String sifre;
	private boolean isActive;
	
	// Constructors
	
	public Kullanici(int id, String ad_soyad, String sifre, boolean isActive) {
		setId(id);
		setAd_soyad(ad_soyad);
		setSifre(sifre);
		setActive(isActive);
	}
	
	public Kullanici() {
		setId(0);
		setAd_soyad("");
		setSifre("");
		setActive(false);
	}
	
	// Getters and Setters
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getAd_soyad() { return ad_soyad; }
	public void setAd_soyad(String ad_soyad) { this.ad_soyad = ad_soyad; }
	public String getSifre() { return sifre; }
	public void setSifre(String sifre) { this.sifre = sifre; }
	public boolean isActive() { return isActive; }
	public void setActive(boolean isActive) { this.isActive = isActive; }
	
	// Overrides

	@Override
	public String toString() { return ad_soyad; }

}
