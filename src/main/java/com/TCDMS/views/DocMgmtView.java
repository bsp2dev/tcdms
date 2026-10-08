package com.TCDMS.views;

import java.util.List;

import com.TCDMS.ui.subnavigation.HasSubNavigation;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("/docmgmt")
@PageTitle("Document Management")
public class DocMgmtView extends VerticalLayout implements HasSubNavigation{

	@Override
	public List<Component> getSubNavigationItems() {
		return List.of(
				createSubLink("Receipt of Document", UnderConstruction.class),
				createSubLink("Withawal of Document", UnderConstruction.class),
				createSubLink("Release of Document", UnderConstruction.class),
				createSubLink("Return of Document", UnderConstruction.class),
				createSubLink("Release to Manager", UnderConstruction.class),
				createSubLink("Modification of Document", UnderConstruction.class),
				createSubLink("Email Notification", UnderConstruction.class)		
		);
	}
	
	private RouterLink createSubLink (String title, Class<? extends Component> navigationTargetClass) {
		RouterLink link = new RouterLink(title, navigationTargetClass);
		
		link.getStyle()
			.set("display", "flex")
			.set("align-items", "center")
			.set("padding", "0 1rem")
			.set("font-weight", "500")
			.set("text-decoration", "none");
		
		return link;
	}

}
