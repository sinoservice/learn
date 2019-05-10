package com.easyhome.vo.dms;

import java.util.List;

public class MasterRequestParseBean {


	/**
	 * 技师主信息
	 */
	private EbTechnicianModel ebTechnicianModel;
	
	/**
	 * 技师服务能力（9大品类）
	 */
	private List<EbTechnicianCapacityModel> ebTechnicianCapacityModel;
	
	/**
	 * 服务范围
	 */
	private List<EbSupplierPlaceModel> ebSupplierPlaceModelList;

	public EbTechnicianModel getEbTechnicianModel() {
		return ebTechnicianModel;
	}

	public void setEbTechnicianModel(EbTechnicianModel ebTechnicianModel) {
		this.ebTechnicianModel = ebTechnicianModel;
	}

	public List<EbTechnicianCapacityModel> getEbTechnicianCapacityModel() {
		return ebTechnicianCapacityModel;
	}

	public void setEbTechnicianCapacityModel(List<EbTechnicianCapacityModel> ebTechnicianCapacityModel) {
		this.ebTechnicianCapacityModel = ebTechnicianCapacityModel;
	}

	public List<EbSupplierPlaceModel> getEbSupplierPlaceModelList() {
		return ebSupplierPlaceModelList;
	}

	public void setEbSupplierPlaceModelList(List<EbSupplierPlaceModel> ebSupplierPlaceModelList) {
		this.ebSupplierPlaceModelList = ebSupplierPlaceModelList;
	}

}
