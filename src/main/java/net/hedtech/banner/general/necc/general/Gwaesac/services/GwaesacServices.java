package net.hedtech.banner.general.necc.general.Gwaesac.services;

import morphis.foundations.core.appdatalayer.data.DataCursor;
import static morphis.foundations.core.types.Types.*;
import morphis.foundations.core.appdatalayer.data.ResultSet;
import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.foundations.core.types.NString;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.general.necc.general.Gwaesac.GwaesacTask;
import net.hedtech.banner.general.necc.general.Gwaesac.model.GwaesacModel;

public class GwaesacServices extends DefaultSupportCodeObject {

	public GwaesacServices(ISupportCodeContainer container) {
		super(container);
	}

	public GwaesacTask getTask() {
		return (GwaesacTask) super.getContainer();
	}

	public GwaesacModel getFormModel() {
		return getTask().getModel();
	}

	public NString getCurrentDwAccess() {
		NString currentDwAccess = NString.EmptyString;

		String dwAccessC = "SELECT shp_filter\r\n" + 
				"  FROM shp_user_mst@dwrpt  dwac\r\n" + 
				"       JOIN spriden iden\r\n" + 
				"           ON     TRIM (dwac.SHP_ACCESS_ID) = iden.SPRIDEN_ID\r\n" + 
				"              AND iden.SPRIDEN_CHANGE_IND IS NULL\r\n" + 
				" WHERE iden.SPRIDEN_PIDM = :PIDM";
		DataCursor dwAccessCursor = new DataCursor(dwAccessC);
		try {
			// Setting query parameters
			dwAccessCursor.addParameter("PIDM", getFormModel().getKeyBlock().getPidm());
			dwAccessCursor.open();
			ResultSet gwvdwrlCResults = dwAccessCursor.fetchInto();
			if (gwvdwrlCResults != null) {
				currentDwAccess = gwvdwrlCResults.getStr(0);
			} else {
				currentDwAccess = toStr("NONE");
			}
		} finally {
			dwAccessCursor.close();
		}
				
		return currentDwAccess;
	}
}