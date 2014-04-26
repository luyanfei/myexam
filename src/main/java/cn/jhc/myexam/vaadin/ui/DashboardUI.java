package cn.jhc.myexam.vaadin.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import cn.jhc.myexam.server.domain.Capability;
import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.server.service.UserService;
import cn.jhc.myexam.shared.domain.CapabilityType;
import cn.jhc.myexam.vaadin.ioc.Injector;
import cn.jhc.myexam.vaadin.view.DashboardView;
import cn.jhc.myexam.vaadin.view.QuestionsManagerView;
import cn.jhc.myexam.vaadin.view.UserManagerView;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("dashboard")
public class DashboardUI extends UI {

	@WebServlet(urlPatterns= {"/dashboard/*"}, asyncSupported=true, 
			initParams = {@WebInitParam(name="UIProvider", value="cn.jhc.myexam.vaadin.ioc.AutowiredUIProvider")})
	@VaadinServletConfiguration(ui=DashboardUI.class, productionMode=false)
	public static class Servlet extends VaadinServlet{
	}
	
	private Navigator navigator;
	
    private VerticalLayout root;

	private HorizontalLayout content = new HorizontalLayout();
	
	private CssLayout menu = new CssLayout();
	
    HashMap<String, Button> viewNameToMenuButton = new HashMap<String, Button>();
    
    @Autowired
    private transient UserService userService;
    
    @Autowired
    private UserManagerView userManagerView;
    @Autowired
    private QuestionsManagerView questionsManagerView;

	private User currentUser;

	@Override
	protected void init(VaadinRequest request) {
		checkNewUser();
        root = new VerticalLayout();
        root.setSizeFull();
        setContent(root);

        buildNavigator();
        buildMainView();
	}
	
	protected void buildMainView() {

        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setSizeFull();
        mainLayout.addStyleName("main-view");
        
        VerticalLayout sidebarLayout = new VerticalLayout();
        sidebarLayout.addStyleName("sidebar");
        sidebarLayout.setWidth(null);
        sidebarLayout.setHeight("100%");
        //Branding element
        sidebarLayout.addComponent(new CssLayout() {
            {
                addStyleName("branding");
                Label logo = new Label("<span>在线考试系统</span> 仪表盘", ContentMode.HTML);
                logo.setSizeUndefined();
                addComponent(logo);
                // addComponent(new Image(null, new
                // ThemeResource(
                // "img/branding.png")));
            }
        });
        
        sidebarLayout.addComponent(menu);
        sidebarLayout.setExpandRatio(menu, 1.0f);
        
        sidebarLayout.addComponent(buildUserMenu());
        
        mainLayout.addComponent(sidebarLayout);
        mainLayout.addComponent(content);
        content.setSizeFull();
        content.addStyleName("view-content");
        mainLayout.setExpandRatio(content, 1);
        root.addComponent(mainLayout);
        
        buildMenu();
	}

	private void buildNavigator() {
		navigator = new Navigator(this, content);
        navigator.addView("/dashboard", DashboardView.class);
        navigator.addView("/" + CapabilityType.USER_MANAGEMENT.getName(), userManagerView);
        navigator.addView("/" + CapabilityType.QUESTION_MANAGEMENT.getName(), questionsManagerView);
	}

	private void buildMenu() {
		menu.removeAllComponents();
		
		addMenuButton("dashboard", "仪表盘");
		
		Set<Capability> capabilities = userService.findCapabilities(currentUser);
		for(final Capability c : capabilities) {
			addMenuButton(c.getName(),c.getDescription());
		}
		
        menu.addStyleName("menu");
        menu.setHeight("100%");

        viewNameToMenuButton.get("/dashboard").setHtmlContentAllowed(true);
        viewNameToMenuButton.get("/dashboard").setCaption(
                "仪表盘<span class=\"badge\"></span>");

        String f = Page.getCurrent().getUriFragment();
        if (f != null && f.startsWith("!")) {
            f = f.substring(1);
        }
        if (f == null || f.equals("") || f.equals("/")) {
            navigator.navigateTo("/dashboard");
            menu.getComponent(0).addStyleName("selected");

        } else {
            navigator.navigateTo(f);

            viewNameToMenuButton.get(f).addStyleName("selected");
        }
	}
	
	private void addMenuButton(final String view, final String description) {
		Button b = new NativeButton(description);
		b.addStyleName("icon-" + view);
		b.addClickListener(new ClickListener() {
		    @Override
		    public void buttonClick(ClickEvent event) {
		        clearMenuSelection();
		        event.getButton().addStyleName("selected");
		        if (!navigator.getState().equals("/" + view))
		            navigator.navigateTo("/" + view);
		    }
		});
		menu.addComponent(b);
		viewNameToMenuButton.put("/" + view, b);
	}
	
    private void clearMenuSelection() {
        for (Iterator<Component> it = menu.iterator(); it.hasNext();) {
            Component next = it.next();
            if (next instanceof NativeButton) {
                next.removeStyleName("selected");
            } 
        }
    }

	private VerticalLayout buildUserMenu() {
		VerticalLayout userLayout = new VerticalLayout();
		userLayout.setSizeUndefined();
		userLayout.addStyleName("user");
		
		Image profile = new Image(null, new ThemeResource("img/profile-pic.png"));
		profile.setWidth("34px");
		userLayout.addComponent(profile);
		
		Label userName = new Label(currentUser.getDisplayName());
		userName.setSizeUndefined();
		userLayout.addComponent(userName);
		
		Command cmd = new Command() {
            @Override
            public void menuSelected(
                    MenuItem selectedItem) {
                Notification.show("Not implemented in this demo");
            }
        };
        MenuBar settings = new MenuBar();
        MenuItem settingsMenu = settings.addItem("", null);
        settingsMenu.setStyleName("icon-cog");
        settingsMenu.addItem("Settings", cmd);
        settingsMenu.addItem("Preferences", cmd);
        settingsMenu.addSeparator();
        settingsMenu.addItem("My Account", cmd);
        userLayout.addComponent(settings);
        
        Button exit = new NativeButton("Exit");
        exit.addStyleName("icon-cancel");
        exit.setDescription("Sign Out");
        userLayout.addComponent(exit);
		return userLayout;
	}
	/**
	 * If user is logged in by authentication provider other than system database, these user should be added to system.
	 */
	private void checkNewUser() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = ((org.springframework.security.core.userdetails.User)authentication.getPrincipal()).getUsername();
		currentUser = userService.findByUsername(username);
	}

}
