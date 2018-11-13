package test;

import com.task.components.MainView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MainViewTest {

    MainView testView;

    @BeforeEach
    public void CreateMainView() {
        testView = new MainView();
    }

    @Test
    public void MainViewShouldExist() {
        assertNotNull(testView);
    }

}
