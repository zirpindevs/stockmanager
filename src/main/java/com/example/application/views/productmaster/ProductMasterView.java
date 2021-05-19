package com.example.application.views.productmaster;

import com.example.application.backend.model.Product;
import com.example.application.backend.service.ProductService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "ProductMaster", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Product Master")
public class ProductMasterView extends HorizontalLayout {
    private ProductService productService;
    Grid<Product> grid;

    public ProductMasterView(ProductService productService){

        super();
        this.productService = productService;

        setSizeFull();
        setPadding(true);

        addClassName("product-master-view");

        add(createGrid());
    }

/*    private void loadGrid(){
        productProvider = DataProvider.ofCollection((this.products));
    }*/

    private Component createGrid(){
        grid = new Grid<Product>(Product.class);
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS,
                GridVariant.LUMO_ROW_STRIPES);

        try {
            // bind the Department collection to the grid
            grid.setItems(this.productService.findAll());

            grid.setColumns("warehouse.name", "description", "family", "price");
            grid.getColumnByKey("warehouse.name").setFlexGrow(0).setWidth("200px").setHeader("Warehouse");
            grid.getColumnByKey("description").setFlexGrow(1).setWidth("200px").setHeader("description");
            grid.getColumnByKey("family").setFlexGrow(0).setWidth("150px").setHeader("family");
            grid.getColumnByKey("price").setFlexGrow(0).setWidth("100px").setHeader("price");

            grid.removeColumnByKey("id");

        } catch (Exception e) {
            Notification.show(e.getLocalizedMessage());
        } finally {
            return grid;
        }

    }



}
