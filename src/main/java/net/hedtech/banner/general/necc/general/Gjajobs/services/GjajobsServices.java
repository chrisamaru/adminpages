package net.hedtech.banner.general.necc.general.Gjajobs.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import net.hedtech.banner.general.necc.general.Gjajobs.GjajobsTask;
import net.hedtech.banner.general.necc.general.Gjajobs.model.GjajobsModel;

public class GjajobsServices extends net.hedtech.banner.general.Gjajobs.services.GjajobsServices {

	public GjajobsServices(ISupportCodeContainer container) {
		super(container);
	}

	public GjajobsTask getTask() {
		return (GjajobsTask) super.getContainer();
	}

	public GjajobsModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}