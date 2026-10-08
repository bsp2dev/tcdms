package com.TCDMS.mainlayout;

import com.TCDMS.ui.subnavigation.HasSubNavigation;
import com.TCDMS.views.DocMgmtView;
import com.TCDMS.views.HomeView;
import com.TCDMS.views.UnderConstruction;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.ColorScheme;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.router.PageTitle;

@Layout
public class TcdmsAppLayout extends AppLayout {
	
	private final H2 subTitleName = new H2();
	private final HorizontalLayout subNav = new HorizontalLayout();
	
	public TcdmsAppLayout() {
        H1 title = new H1("Titles and Contracts Document Management System Beta Version");
        title.getStyle()
	    	.set("font-size", "1.125rem")
	    	.set("line-height", "1.5rem")
	    	.set("margin", "0 var(--vaadin-padding-m)");
        
        subTitleName.getStyle()
        	.set("font-size", "1.125rem")
        	.set("margin", "0");
        
        SideNav mainNav = getPrimarySideViewNavigation();
        mainNav.getStyle()
        	.set("margin", "var(--vaadin-gap-s)");
        
        DrawerToggle toggle = new DrawerToggle();
		toggle.getStyle()
			.set("margin-inline-end", "var(--vaadin-gap-s)");
		
		Scroller scroller = new Scroller(mainNav);
		
		Checkbox darkMode = new Checkbox("Dark Mode");
		darkMode
			.addValueChangeListener(
					event -> {
						UI
							.getCurrent()
							.getPage()
							.setColorScheme(event.getValue() ? ColorScheme.Value.DARK : ColorScheme.Value.LIGHT);
					}
			);
		
        HorizontalLayout toggleSubTitleWrapper = new HorizontalLayout(toggle, subTitleName, darkMode);
        toggleSubTitleWrapper.setAlignItems(FlexComponent.Alignment.CENTER);
        toggleSubTitleWrapper.setSpacing(false);
        
        VerticalLayout navbarWrapper = new VerticalLayout(toggleSubTitleWrapper, subNav);
        navbarWrapper.setPadding(false);
        navbarWrapper.setSpacing(false);
		
        addToDrawer(title, scroller);
        addToNavbar(navbarWrapper);
        
        setPrimarySection(Section.DRAWER);
        
        // update subTitleName and subNav values after each navigation
        UI.getCurrent().addAfterNavigationListener(event -> {
        	Component content = getContent();
        	
        	updateSubTitle(content);
        	updateSubNavigation(content);
        });
	}
	
	private SideNav getPrimarySideViewNavigation() {
		SideNav nav = new SideNav();
		
		nav.addItem(new SideNavItem("Home", HomeView.class, VaadinIcon.HOME.create()));
        nav.addItem(new SideNavItem("Document Management", DocMgmtView.class, VaadinIcon.RECORDS.create()));
        nav.addItem(new SideNavItem("Consolidation", UnderConstruction.class, VaadinIcon.BOOK.create()));
        nav.addItem(new SideNavItem("Inquiry", UnderConstruction.class, VaadinIcon.SEARCH.create()));
        nav.addItem(new SideNavItem("Reports", UnderConstruction.class, VaadinIcon.OPEN_BOOK.create()));
        nav.addItem(new SideNavItem("Maintenance", UnderConstruction.class,VaadinIcon.TOOLS.create()));
		
		return nav;
	}
	
	private HorizontalLayout getSecondaryTopViewNavigation() {
		HorizontalLayout secondaryView = new HorizontalLayout();
		
		secondaryView.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
		secondaryView.setHeight("2.25rem");
		secondaryView.getStyle().set("gap", "0.5rem");
		
		
		return secondaryView;
	}
	
	private void updateSubTitle(Component content) {
		if (content != null) {
    		PageTitle pageTitle = content.getClass().getAnnotation(PageTitle.class);
    		
    		subTitleName.setText(pageTitle != null ? pageTitle.value() : "");
    	}
	}
	
	private void updateSubNavigation(Component content) {
		subNav.removeAll();
		
		if (content instanceof HasSubNavigation navItem) {
			subNav.add(navItem.getSubNavigationItems());
		}
	}
}
