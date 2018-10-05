package net.hedtech.banner.general.necc.general.Gwaesac;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class GwaesacTask extends BaseTask {
	public GwaesacTask(String taskName) {
		super(taskName);
	}
	
	public GwaesacTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.general.necc.general.Gwaesac.model.GwaesacModel getModel() {
		return (net.hedtech.banner.general.necc.general.Gwaesac.model.GwaesacModel)super.getModel();
	}
	
	public net.hedtech.banner.general.necc.general.Gwaesac.services.GwaesacServices getServices() {
		return (net.hedtech.banner.general.necc.general.Gwaesac.services.GwaesacServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
	
	public net.hedtech.general.common.libraries.Soqrpls.SoqrplsServices getSoqrpls() {
		return (net.hedtech.general.common.libraries.Soqrpls.SoqrplsServices)getSupportCodeManager().getLibrary("SOQRPLS");
	}
}
