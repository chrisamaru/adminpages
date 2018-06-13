package net.hedtech.banner.general.necc.general.Gjapctl.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import net.hedtech.banner.general.necc.general.Gjapctl.GjapctlTask;
import net.hedtech.banner.general.necc.general.Gjapctl.model.GjapctlModel;

public class GjapctlServices extends net.hedtech.banner.general.Gjapctl.services.GjapctlServices {

	public GjapctlServices(ISupportCodeContainer container) {
		super(container);
	}

	public GjapctlTask getTask() {
		return (GjapctlTask) super.getContainer();
	}

	public GjapctlModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}