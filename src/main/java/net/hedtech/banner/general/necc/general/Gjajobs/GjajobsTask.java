package net.hedtech.banner.general.necc.general.Gjajobs;

import java.util.Hashtable;

public class GjajobsTask extends net.hedtech.banner.general.Gjajobs.GjajobsTask {
	public GjajobsTask(String taskName) {
		super(taskName);
	}
	
	public GjajobsTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.general.necc.general.Gjajobs.model.GjajobsModel getModel() {
		return (net.hedtech.banner.general.necc.general.Gjajobs.model.GjajobsModel)super.getModel();
	}
	
	public net.hedtech.banner.general.necc.general.Gjajobs.services.GjajobsServices getServices() {
		return (net.hedtech.banner.general.necc.general.Gjajobs.services.GjajobsServices)getSupportCodeManager().getServices();
	}
}
