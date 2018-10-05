package net.hedtech.banner.general.necc.general.Gwaesac.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class GwbesacAdapter extends BaseRowAdapter {

	public GwbesacAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NNumber getGwbesacPidm() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("GWBESAC_PIDM"));
		return v;
	}
	
	public void setGwbesacPidm(NNumber value) {
		this.setValue("GWBESAC_PIDM", value.getValue());
	}

	public NString getGwbesacStaffInd() {
		NString v = new NString((String)this.getValue("GWBESAC_STAFF_IND"));
		return v;
	}
	
	public void setGwbesacStaffInd(NString value) {
		this.setValue("GWBESAC_STAFF_IND", value.getValue());
	}

	public NString getGwbesacDwAccess() {
		NString v = new NString((String)this.getValue("GWBESAC_DW_ACCESS"));
		return v;
	}
	
	public void setGwbesacDwAccess(NString value) {
		this.setValue("GWBESAC_DW_ACCESS", value.getValue());
	}

	public NString getGwbesacDwEnabledInd() {
		NString v = new NString((String)this.getValue("GWBESAC_DW_ENABLED_IND"));
		return v;
	}
	
	public void setGwbesacDwEnabledInd(NString value) {
		this.setValue("GWBESAC_DW_ENABLED_IND", value.getValue());
	}

	public NString getGwbesacEabEnabledInd() {
		NString v = new NString((String)this.getValue("GWBESAC_EAB_ENABLED_IND"));
		return v;
	}
	
	public void setGwbesacEabEnabledInd(NString value) {
		this.setValue("GWBESAC_EAB_ENABLED_IND", value.getValue());
	}

	public NDate getGwbesacActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("GWBESAC_ACTIVITY_DATE"));
		return v;
	}
	
	public void setGwbesacActivityDate(NDate value) {
		this.setValue("GWBESAC_ACTIVITY_DATE", value.getValue());
	}

	public NString getGwbesacUser() {
		NString v = new NString((String)this.getValue("GWBESAC_USER"));
		return v;
	}
	
	public void setGwbesacUser(NString value) {
		this.setValue("GWBESAC_USER", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}