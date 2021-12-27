package hansecom;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @Test
    void mySecondtest () {
        // Откройте https://the-internet.herokuapp.com/drag_and_drop
    open("https://the-internet.herokuapp.com/drag_and_drop");
        // Перенесите прямоугольник А на место В
    $("#column-a").dragAndDropTo("#column-b");
        // Проверьте, что прямоугольники действительно поменялись
    $("#column-a").shouldNotHave(text("A"));
    $("#column-b").shouldNotHave(text("B"));

    }
}