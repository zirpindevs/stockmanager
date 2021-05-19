package com.example.application.views.dashboard;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.example.application.components.leafletmap.LeafletMap;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;

@Route(value = "dashboard", layout = MainView.class)
@PageTitle("Dashboard")
public class DashBoard extends VerticalLayout {

    private LeafletMap map = new LeafletMap();

    public DashBoard() {
        setSizeFull();
        setPadding(false);
        map.setSizeFull();
        map.setView(55.0, 10.0, 4);
        add(map);
    }
}
