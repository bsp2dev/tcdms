package com.TCDMS.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("/underconstruction")
@PageTitle("Under Construction")
public class UnderConstruction extends VerticalLayout {

	public UnderConstruction() {
		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setAlignItems(FlexComponent.Alignment.CENTER);
		setSpacing(true);
		
		Icon toolsIcon = VaadinIcon.TOOLS.create();
		toolsIcon.setSize("120px");
		toolsIcon.getStyle()
		.set("color", "var(--lumo-primary-color)");
		
		H1 title = new H1("SITE IS STILL UNDER CONSTRUCTION");
		title.getStyle()
		.set("font-size", "3rem")
		.set("font-weight", "900")
		.set("text-align", "center")
		.set("margin", "0");
		
		Paragraph subtitle = new Paragraph(
		"We're working hard to bring this site online. Please check back soon."
		);
		subtitle.getStyle()
		.set("font-size", "1.2rem")
		.set("text-align", "center");
		
		add(toolsIcon, title, subtitle);
		}
} 
