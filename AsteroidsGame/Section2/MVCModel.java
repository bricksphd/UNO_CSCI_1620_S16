package asteroids;

import java.util.ArrayList;
import java.util.List;

/**
A class that implements IMVCModel and provides basic model functionality.
*/
public class MVCModel implements IMVCModel {

    /**The list of views the model knows about*/
	private List<IMVCView> views = new ArrayList<IMVCView>();
	
    /**
    Update all the views
    */
	@Override
	public void updated() {
		views.forEach(v->v.modelUpdated());

	}

    /**
    Add a view to the model
    @param newView The new view to add to the model.
    */
	@Override
	public void addView(IMVCView newView) {
		if(views.contains(newView))return;
		views.add(newView);
	}

}
