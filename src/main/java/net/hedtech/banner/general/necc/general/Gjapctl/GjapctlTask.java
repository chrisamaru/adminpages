package net.hedtech.banner.general.necc.general.Gjapctl;

import java.util.Hashtable;

public class GjapctlTask extends net.hedtech.banner.general.Gjapctl.GjapctlTask {
	public GjapctlTask(String taskName) {
		super(taskName);
	}
	
	public GjapctlTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.general.necc.general.Gjapctl.model.GjapctlModel getModel() {
		return (net.hedtech.banner.general.necc.general.Gjapctl.model.GjapctlModel)super.getModel();
	}
	
	public net.hedtech.banner.general.necc.general.Gjapctl.services.GjapctlServices getServices() {
		return (net.hedtech.banner.general.necc.general.Gjapctl.services.GjapctlServices)getSupportCodeManager().getServices();
	}
}
