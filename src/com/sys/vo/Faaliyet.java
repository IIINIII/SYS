package com.sys.vo;

public class Faaliyet {
	
	private int id;
	private String konu;
	private String talepTarihi;
	private double maliyetBedeli;
	private String odenek;
	private String ihaleTarihi;
	private String sozlesmeTarihi;
	private String teslimSuresi;
	private double sozlesmeAlimBedeli;
	private double ilaveSiparisBedeli;
	private double odenen;
	private String firma;
	private String aciklama;
	private String sorumlu;
	
	// Constructors
	
	public Faaliyet(int id, String konu, String talepTarihi, double maliyetBedeli, String odenek, String ihaleTarihi,
			String sozlesmeTarihi, String teslimSuresi, double sozlesmeAlimBedeli, double ilaveSiparisBedeli,
			double odenen, String firma, String aciklama, String sorumlu) {
		this.id = id;
		this.konu = konu;
		this.talepTarihi = talepTarihi;
		this.maliyetBedeli = maliyetBedeli;
		this.odenek = odenek;
		this.ihaleTarihi = ihaleTarihi;
		this.sozlesmeTarihi = sozlesmeTarihi;
		this.teslimSuresi = teslimSuresi;
		this.sozlesmeAlimBedeli = sozlesmeAlimBedeli;
		this.ilaveSiparisBedeli = ilaveSiparisBedeli;
		this.odenen = odenen;
		this.firma = firma;
		this.aciklama = aciklama;
		this.sorumlu = sorumlu;
	}
	
	public Faaliyet() {
		this.id = 0;
		this.konu = "";
		this.talepTarihi = "";
		this.maliyetBedeli = 0;
		this.odenek = "";
		this.ihaleTarihi = "";
		this.sozlesmeTarihi = "";
		this.teslimSuresi = "";
		this.sozlesmeAlimBedeli = 0;
		this.ilaveSiparisBedeli = 0;
		this.odenen = 0;
		this.firma = "";
		this.aciklama = "";
		this.sorumlu = "";
	}
	
	public Object[] toObjectArray() {
		Object[] objectArray = new Object[14];
		int sn = 0;
		objectArray[sn++]=toObject(id);
		objectArray[sn++]=toObject(konu);
		objectArray[sn++]=toObject(talepTarihi);
		objectArray[sn++]=toObject(maliyetBedeli);
		objectArray[sn++]=toObject(odenek);
		objectArray[sn++]=toObject(ihaleTarihi);
		objectArray[sn++]=toObject(sozlesmeTarihi);
		objectArray[sn++]=toObject(teslimSuresi);
		objectArray[sn++]=toObject(sozlesmeAlimBedeli);
		objectArray[sn++]=toObject(ilaveSiparisBedeli);
		objectArray[sn++]=toObject(odenek);
		objectArray[sn++]=toObject(firma);
		objectArray[sn++]=toObject(aciklama);
		objectArray[sn++]=toObject(sorumlu);
		return objectArray;
	}
	
	public static Object toObject(Object o) {
		if(o==null)
			return "";
		else
			return o;
	}
	
	@Override
	public String toString() {
		return konu;
	}
	
	// Getters and Setters

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getKonu() { return konu; }
	public void setKonu(String konu) { this.konu = konu; }
	public String getTalepTarihi() { return talepTarihi; }
	public void setTalepTarihi(String talepTarihi) { this.talepTarihi = talepTarihi; }
	public double getMaliyetBedeli() { return maliyetBedeli; }
	public void setMaliyetBedeli(double maliyetBedeli) { this.maliyetBedeli = maliyetBedeli; }
	public String getOdenek() { return odenek; }
	public void setOdenek(String odenek) { this.odenek = odenek; }
	public String getIhaleTarihi() { return ihaleTarihi; }
	public void setIhaleTarihi(String ihaleTarihi) { this.ihaleTarihi = ihaleTarihi; }
	public String getSozlesmeTarihi() { return sozlesmeTarihi; }
	public void setSozlesmeTarihi(String sozlesmeTarihi) { this.sozlesmeTarihi = sozlesmeTarihi; }
	public String getTeslimSuresi() { return teslimSuresi; }
	public void setTeslimSuresi(String teslimSuresi) { this.teslimSuresi = teslimSuresi; }
	public double getSozlesmeAlimBedeli() { return sozlesmeAlimBedeli; }
	public void setSozlesmeAlimBedeli(double sozlesmeAlimBedeli) { this.sozlesmeAlimBedeli = sozlesmeAlimBedeli; }
	public double getIlaveSiparisBedeli() { return ilaveSiparisBedeli; }
	public void setIlaveSiparisBedeli(double ilaveSiparisBedeli) { this.ilaveSiparisBedeli = ilaveSiparisBedeli; }
	public double getOdenen() { return odenen; }
	public void setOdenen(double odenen) { this.odenen = odenen; }
	public String getFirma() { return firma; }
	public void setFirma(String firma) { this.firma = firma; }
	public String getAciklama() { return aciklama; }
	public void setAciklama(String aciklama) { this.aciklama = aciklama; }
	public String getSorumlu() { return sorumlu; }
	public void setSorumlu(String sorumlu) { this.sorumlu = sorumlu; }

}
