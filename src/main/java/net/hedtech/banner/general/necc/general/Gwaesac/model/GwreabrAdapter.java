package net.hedtech.banner.general.necc.general.Gwaesac.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class GwreabrAdapter extends BaseRowAdapter {

	public GwreabrAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NNumber getGwreabrPidm() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("GWREABR_PIDM"));
		return v;
	}
	
	public void setGwreabrPidm(NNumber value) {
		this.setValue("GWREABR_PIDM", value.getValue());
	}

	public NString getGwreabrRole() {
		NString v = new NString((String)this.getValue("GWREABR_ROLE"));
		return v;
	}
	
	public void setGwreabrRole(NString value) {
		this.setValue("GWREABR_ROLE", value.getValue());
	}

	public NDate getGwreabrActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("GWREABR_ACTIVITY_DATE"));
		return v;
	}
	
	public void setGwreabrActivityDate(NDate value) {
		this.setValue("GWREABR_ACTIVITY_DATE", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}