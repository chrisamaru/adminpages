package net.hedtech.banner.general.necc.general.Gwaesac.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
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

	// TODO: put your services here

}