package net.hedtech.banner.general.necc.general.Gjajobs.controller;

import morphis.foundations.core.appsupportlib.runtime.ITask;
import net.hedtech.banner.general.necc.general.Gjajobs.GjajobsTask;
import net.hedtech.banner.general.necc.general.Gjajobs.model.GjajobsModel;

public class GjajobsFormController extends net.hedtech.banner.general.Gjajobs.controller.GjajobsFormController {

	public GjajobsFormController(ITask task) {
		super(task);
	}

	@Override
	public GjajobsTask getTask() {
		return (GjajobsTask) super.getTask();
	}

	public GjajobsModel getFormModel() {
		return getTask().getModel();
	}
}